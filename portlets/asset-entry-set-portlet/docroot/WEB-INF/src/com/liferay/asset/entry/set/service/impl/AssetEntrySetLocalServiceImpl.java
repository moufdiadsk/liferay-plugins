/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.asset.entry.set.service.impl;

import com.liferay.asset.entry.set.model.AssetEntrySet;
import com.liferay.asset.entry.set.service.base.AssetEntrySetLocalServiceBaseImpl;
import com.liferay.asset.entry.set.util.AssetEntrySetConstants;
import com.liferay.asset.entry.set.util.AssetEntrySetManagerUtil;
import com.liferay.asset.sharing.service.AssetSharingEntryLocalServiceUtil;
import com.liferay.asset.sharing.util.AssetSharingUtil;
import com.liferay.compat.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserConstants;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.ratings.model.RatingsStats;

import java.io.File;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author Calvin Keum
 * @author Sherry Yang
 */
public class AssetEntrySetLocalServiceImpl
	extends AssetEntrySetLocalServiceBaseImpl {

	@Override
	public AssetEntrySet addAssetEntrySet(
			long userId, JSONObject payloadJSONObject, File file,
			boolean privateAssetEntrySet)
		throws PortalException, SystemException {

		return addAssetEntrySet(
			userId, 0, payloadJSONObject, file, privateAssetEntrySet);
	}

	@Override
	public AssetEntrySet addAssetEntrySet(
			long userId, long parentAssetEntrySetId,
			JSONObject payloadJSONObject, File file,
			boolean privateAssetEntrySet)
		throws PortalException, SystemException {

		return addAssetEntrySet(
			userId, parentAssetEntrySetId, _USER_CLASS_NAME_ID, userId,
			payloadJSONObject, file, privateAssetEntrySet);
	}

	@Override
	public AssetEntrySet addAssetEntrySet(
			long userId, long parentAssetEntrySetId, long creatorClassNameId,
			long creatorClassPK, JSONObject payloadJSONObject, File file,
			boolean privateAssetEntrySet)
		throws PortalException, SystemException {

		long assetEntrySetId = counterLocalService.increment();

		AssetEntrySet assetEntrySet = assetEntrySetPersistence.create(
			assetEntrySetId);

		User user = userPersistence.findByPrimaryKey(userId);

		assetEntrySet.setCompanyId(user.getCompanyId());
		assetEntrySet.setUserId(user.getUserId());

		Date now = new Date();

		assetEntrySet.setCreateTime(now.getTime());
		assetEntrySet.setModifiedTime(now.getTime());

		assetEntrySet.setParentAssetEntrySetId(parentAssetEntrySetId);
		assetEntrySet.setCreatorClassNameId(creatorClassNameId);
		assetEntrySet.setCreatorClassPK(creatorClassPK);
		assetEntrySet.setPayload(
			JSONFactoryUtil.looseSerialize(
				AssetEntrySetManagerUtil.interpret(payloadJSONObject, file)));
		assetEntrySet.setPrivateAssetEntrySet(privateAssetEntrySet);

		assetEntrySetPersistence.update(assetEntrySet);

		setCreatorJSONObject(assetEntrySet);

		updateChildAssetEntrySetsCount(parentAssetEntrySetId);

		updateAssetEntry(
			assetEntrySet,
			StringUtil.split(
				payloadJSONObject.getString(
					AssetEntrySetConstants.PAYLOAD_KEY_ASSET_TAG_NAMES)));

		Map<Long, long[]> sharedToClassPKsMap = getSharedToClassPKsMap(
			payloadJSONObject);

		addUserToSharedToClassPKsMap(sharedToClassPKsMap, userId);

		AssetSharingEntryLocalServiceUtil.addAssetSharingEntries(
			_ASSET_ENTRY_SET_CLASS_NAME_ID, assetEntrySetId,
			sharedToClassPKsMap);

		return assetEntrySet;
	}

	@Override
	public AssetEntrySet deleteAssetEntrySet(AssetEntrySet assetEntrySet)
		throws PortalException, SystemException {

		assetEntrySetPersistence.remove(assetEntrySet);

		assetEntryLocalService.deleteEntry(
			AssetEntrySet.class.getName(), assetEntrySet.getAssetEntrySetId());

		return assetEntrySet;
	}

	@Override
	public AssetEntrySet deleteAssetEntrySet(long assetEntrySetId)
		throws PortalException, SystemException {

		AssetEntrySet assetEntrySet = assetEntrySetPersistence.findByPrimaryKey(
			assetEntrySetId);

		return deleteAssetEntrySet(assetEntrySet);
	}

	@Override
	public List<AssetEntrySet> getAssetEntrySets(
			long userId, int start, int end)
		throws PortalException, SystemException {

		Map<Long, long[]> sharedToClassPKsMap =
			AssetSharingUtil.getSharedToClassPKsMap(userId);

		return assetEntrySetFinder.findBySharedToClassPKsMap(
			sharedToClassPKsMap, start, end);
	}

	@Override
	public List<AssetEntrySet> getAssetEntrySets(
			long userId, long creatorClassNameId, long creatorClassPK,
			String assetTagName, boolean andOperator, int start, int end)
		throws PortalException, SystemException {

		Map<Long, long[]> sharedToClassPKsMap =
			AssetSharingUtil.getSharedToClassPKsMap(userId);

		List<AssetEntrySet> assetEntrySets =
			assetEntrySetFinder.findByCCNI_CCPK_ATN(
				creatorClassNameId, creatorClassPK, assetTagName,
				sharedToClassPKsMap, andOperator, start, end);

		setCreatorJSONObjects(assetEntrySets);

		return assetEntrySets;
	}

	@Override
	public List<AssetEntrySet> getAssetEntrySets(
			long userId, long creatorClassNameId, String assetTagName,
			int start, int end)
		throws PortalException, SystemException {

		Map<Long, long[]> sharedToClassPKsMap =
			AssetSharingUtil.getSharedToClassPKsMap(userId);

		List<AssetEntrySet> assetEntrySets = assetEntrySetFinder.findByCCNI_ATN(
			creatorClassNameId, assetTagName, sharedToClassPKsMap, start, end);

		setCreatorJSONObjects(assetEntrySets);

		return assetEntrySets;
	}

	@Override
	public int getAssetEntrySetsCount(long userId)
		throws PortalException, SystemException {

		Map<Long, long[]> sharedToClassPKsMap =
			AssetSharingUtil.getSharedToClassPKsMap(userId);

		return assetEntrySetFinder.countBySharedToClassPKsMap(
			sharedToClassPKsMap);
	}

	@Override
	public int getAssetEntrySetsCount(
			long userId, long creatorClassNameId, long creatorClassPK,
			String assetTagName, boolean andOperator)
		throws PortalException, SystemException {

		Map<Long, long[]> sharedToClassPKsMap =
			AssetSharingUtil.getSharedToClassPKsMap(userId);

		return assetEntrySetFinder.countByCCNI_CCPK_ATN(
			creatorClassNameId, creatorClassPK, assetTagName,
			sharedToClassPKsMap, andOperator);
	}

	@Override
	public int getAssetEntrySetsCount(
			long userId, long creatorClassNameId, String assetTagName)
		throws PortalException, SystemException {

		Map<Long, long[]> sharedToClassPKsMap =
			AssetSharingUtil.getSharedToClassPKsMap(userId);

		return assetEntrySetFinder.countByCCNI_ATN(
			creatorClassNameId, assetTagName, sharedToClassPKsMap);
	}

	@Override
	public List<AssetEntrySet> getChildAssetEntrySets(
			long parentAssetEntrySetId, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return assetEntrySetPersistence.findByParentAssetEntrySetId(
			parentAssetEntrySetId, start, end, orderByComparator);
	}

	@Override
	public List<AssetEntrySet> getNewAssetEntrySets(
			long userId, long createTime, long parentAssetEntrySetId, int start,
			int end)
		throws PortalException, SystemException {

		return getAssetEntrySets(
			userId, createTime, true, parentAssetEntrySetId, start, end);
	}

	@Override
	public List<AssetEntrySet> getOldAssetEntrySets(
			long userId, long createTime, long parentAssetEntrySetId, int start,
			int end)
		throws PortalException, SystemException {

		return getAssetEntrySets(
			userId, createTime, false, parentAssetEntrySetId, start, end);
	}

	public JSONObject getPreviewJSONObject(String url) throws Exception {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		Http.Options options = new Http.Options();

		int pos = url.indexOf(CharPool.QUESTION);

		if (pos != -1) {
			options.setBody(
				url.substring(pos + 1),
				ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED,
				StringPool.UTF8);
			options.setLocation(url.substring(0, pos));
		}
		else {
			options.setLocation(url);
		}

		String html = HttpUtil.URLtoString(options);

		Document document = Jsoup.parse(html);

		jsonObject.put("description", getLinkDescription(document));

		StringBundler sb = new StringBundler(4);

		sb.append(HttpUtil.getProtocol(url));
		sb.append(StringPool.COLON);
		sb.append(StringPool.DOUBLE_SLASH);
		sb.append(HttpUtil.getDomain(url));

		jsonObject.put("imageURL", getLinkImageURL(document, sb.toString()));

		String domain = HttpUtil.getDomain(options.getLocation());

		jsonObject.put("shortURL", StringUtil.toUpperCase(domain));

		jsonObject.put("title", getLinkTitle(document));

		return jsonObject;
	}

	@Override
	public AssetEntrySet likeAssetEntrySet(long userId, long assetEntrySetId)
		throws PortalException, SystemException {

		return updateRatingsStatsTotalScore(userId, assetEntrySetId, 1);
	}

	@Override
	public AssetEntrySet unlikeAssetEntrySet(long userId, long assetEntrySetId)
		throws PortalException, SystemException {

		return updateRatingsStatsTotalScore(userId, assetEntrySetId, 0);
	}

	@Override
	public void updateAssetEntry(long assetEntrySetId, String[] assetTagNames)
		throws PortalException, SystemException {

		AssetEntrySet assetEntrySet = assetEntrySetPersistence.findByPrimaryKey(
			assetEntrySetId);

		updateAssetEntry(assetEntrySet, assetTagNames);
	}

	@Override
	public AssetEntrySet updateAssetEntrySet(
			long assetEntrySetId, JSONObject payloadJSONObject, File file,
			boolean privateAssetEntrySet)
		throws PortalException, SystemException {

		AssetEntrySet assetEntrySet = assetEntrySetPersistence.findByPrimaryKey(
			assetEntrySetId);

		Date now = new Date();

		assetEntrySet.setModifiedTime(now.getTime());

		assetEntrySet.setPayload(
			JSONFactoryUtil.looseSerialize(
				AssetEntrySetManagerUtil.interpret(payloadJSONObject, file)));
		assetEntrySet.setPrivateAssetEntrySet(privateAssetEntrySet);

		assetEntrySetPersistence.update(assetEntrySet);

		setCreatorJSONObject(assetEntrySet);

		updateAssetEntry(
			assetEntrySet,
			StringUtil.split(
				payloadJSONObject.getString(
					AssetEntrySetConstants.PAYLOAD_KEY_ASSET_TAG_NAMES)));

		AssetSharingEntryLocalServiceUtil.deleteAssetSharingEntries(
			_ASSET_ENTRY_SET_CLASS_NAME_ID, assetEntrySetId);

		Map<Long, long[]> sharedToClassPKsMap = getSharedToClassPKsMap(
			payloadJSONObject);

		addUserToSharedToClassPKsMap(
			sharedToClassPKsMap, assetEntrySet.getUserId());

		AssetSharingEntryLocalServiceUtil.addAssetSharingEntries(
			_ASSET_ENTRY_SET_CLASS_NAME_ID, assetEntrySetId,
			sharedToClassPKsMap);

		return assetEntrySet;
	}

	@Override
	public AssetEntrySet updateChildAssetEntrySetsCount(
			long parentAssetEntrySetId)
		throws PortalException, SystemException {

		if (parentAssetEntrySetId == 0) {
			return null;
		}

		AssetEntrySet assetEntrySet = assetEntrySetPersistence.findByPrimaryKey(
			parentAssetEntrySetId);

		int childAssetEntrySetsCount =
			assetEntrySetPersistence.countByParentAssetEntrySetId(
				parentAssetEntrySetId);

		assetEntrySet.setChildAssetEntrySetsCount(childAssetEntrySetsCount);

		assetEntrySetPersistence.update(assetEntrySet);

		return assetEntrySet;
	}

	protected void addUserToSharedToClassPKsMap(
		Map<Long, long[]> sharedToClassPKsMap, long userId) {

		long[] sharedToUserIds = sharedToClassPKsMap.get(_USER_CLASS_NAME_ID);

		if (sharedToUserIds == null) {
			sharedToClassPKsMap.put(_USER_CLASS_NAME_ID, new long[] {userId});
		}
		else if (!ArrayUtil.contains(sharedToUserIds, userId)) {
			sharedToClassPKsMap.put(
				_USER_CLASS_NAME_ID, ArrayUtil.append(sharedToUserIds, userId));
		}
	}

	protected List<AssetEntrySet> getAssetEntrySets(
			long userId, long createTime, boolean gtCreateTime,
			long parentAssetEntrySetId, int start, int end)
		throws PortalException, SystemException {

		Map<Long, long[]> sharedToClassPKsMap =
			AssetSharingUtil.getSharedToClassPKsMap(userId);

		List<AssetEntrySet> assetEntrySets =
			assetEntrySetFinder.findByCT_PASEI(
				createTime, gtCreateTime, parentAssetEntrySetId,
				sharedToClassPKsMap, start, end);

		setCreatorJSONObjects(assetEntrySets);

		return assetEntrySets;
	}

	protected String getLinkDescription(Document document) {
		Elements descriptionElement = document.select(
			"meta[property=og:description]");

		if (descriptionElement.size() <= 0) {
			descriptionElement = document.select("meta[name=description]");
		}

		String description = descriptionElement.attr("content");

		return StringUtil.shorten(description, 200);
	}

	protected String getLinkImageURL(Document document, String baseURL) {
		String imageURL = StringPool.BLANK;

		Elements imageElement = document.select("meta[property=og:image]");

		if (imageElement.size() <= 0) {
			imageElement = document.select("img");

			imageURL = imageElement.get(0).attr("src");
		}
		else {
			imageURL = imageElement.attr("content");
		}

		if (!HttpUtil.hasDomain(imageURL)) {
			imageURL = baseURL + imageURL;
		}

		return imageURL;
	}

	protected String getLinkTitle(Document document) {
		Elements titleElement = document.select("meta[property=og:title]");

		String title = titleElement.attr("content");

		if (Validator.isNull(title)) {
			titleElement = document.select("meta[name=title]");

			title = titleElement.attr("content");
		}

		if (Validator.isNull(title)) {
			titleElement = document.select("title");

			title = titleElement.html();
		}

		if (Validator.isNull(title)) {
			titleElement = document.select("meta[property=og:site_name]");

			title = titleElement.attr("content");
		}

		return StringUtil.shorten(title, 200);
	}

	protected Map<Long, long[]> getSharedToClassPKsMap(
		JSONObject payloadJSONObject) {

		Map<Long, long[]> sharedToClassPKsMap =
			new LinkedHashMap<Long, long[]>();

		JSONArray sharedToJSONArray = payloadJSONObject.getJSONArray(
			AssetEntrySetConstants.PAYLOAD_KEY_SHARED_TO);

		if (sharedToJSONArray == null) {
			return sharedToClassPKsMap;
		}

		for (int i = 0; i < sharedToJSONArray.length(); i++) {
			JSONObject sharedToJSONObject = sharedToJSONArray.getJSONObject(i);

			long classNameId = sharedToJSONObject.getLong("classNameId");
			long classPK = sharedToJSONObject.getLong("classPK");

			if (sharedToClassPKsMap.containsKey(classNameId)) {
				sharedToClassPKsMap.put(
					classNameId,
					ArrayUtil.append(
						sharedToClassPKsMap.get(classNameId), classPK));
			}
			else {
				sharedToClassPKsMap.put(classNameId, new long[] {classPK});
			}
		}

		return sharedToClassPKsMap;
	}

	protected void setCreatorJSONObject(AssetEntrySet assetEntrySet)
		throws PortalException, SystemException {

		JSONObject creatorJSONObject = JSONFactoryUtil.createJSONObject();

		String creatorFullName = StringPool.BLANK;
		String creatorPortraitURL = StringPool.BLANK;
		String creatorURL = StringPool.BLANK;

		if (assetEntrySet.getCreatorClassNameId() == _USER_CLASS_NAME_ID) {
			User user = userPersistence.findByPrimaryKey(
				assetEntrySet.getUserId());

			creatorFullName = user.getFullName();

			creatorPortraitURL = UserConstants.getPortraitURL(
				PortalUtil.getPathImage(), user.isMale(), user.getPortraitId());

			Group group = user.getGroup();

			creatorURL = PropsUtil.get(
				PropsKeys.LAYOUT_FRIENDLY_URL_PUBLIC_SERVLET_MAPPING);

			creatorURL += group.getFriendlyURL();
		}
		else {
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
				PortalUtil.getClassName(assetEntrySet.getCreatorClassNameId()),
				assetEntrySet.getCreatorClassPK());

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
				assetEntry.getDescription());

			creatorFullName = jsonObject.getString(
				AssetEntrySetConstants.ASSET_ENTRY_KEY_CREATOR_FULL_NAME);
			creatorPortraitURL = jsonObject.getString(
				AssetEntrySetConstants.ASSET_ENTRY_KEY_CREATOR_PORTRAIT_URL);
			creatorURL = jsonObject.getString(
				AssetEntrySetConstants.ASSET_ENTRY_KEY_CREATOR_URL);
		}

		creatorJSONObject.put(
			AssetEntrySetConstants.ASSET_ENTRY_KEY_CREATOR_FULL_NAME,
			creatorFullName);
		creatorJSONObject.put(
			AssetEntrySetConstants.ASSET_ENTRY_KEY_CREATOR_PORTRAIT_URL,
			creatorPortraitURL);
		creatorJSONObject.put(
			AssetEntrySetConstants.ASSET_ENTRY_KEY_CREATOR_URL, creatorURL);

		assetEntrySet.setCreator(creatorJSONObject);
	}

	protected void setCreatorJSONObjects(List<AssetEntrySet> assetEntrySets)
		throws PortalException, SystemException {

		for (AssetEntrySet assetEntrySet : assetEntrySets) {
			setCreatorJSONObject(assetEntrySet);
		}
	}

	protected void updateAssetEntry(
			AssetEntrySet assetEntrySet, String[] assetTagNames)
		throws PortalException, SystemException {

		Group group = groupLocalService.getCompanyGroup(
			assetEntrySet.getCompanyId());

		assetEntryLocalService.updateEntry(
			assetEntrySet.getUserId(), group.getGroupId(),
			AssetEntrySet.class.getName(), assetEntrySet.getAssetEntrySetId(),
			null, assetTagNames);
	}

	protected AssetEntrySet updateRatingsStatsTotalScore(
			long userId, long assetEntrySetId, long score)
		throws PortalException, SystemException {

		String className = AssetEntrySet.class.getName();

		ratingsEntryLocalService.updateEntry(
			userId, className, assetEntrySetId, score, new ServiceContext());

		AssetEntrySet assetEntrySet = assetEntrySetPersistence.findByPrimaryKey(
			assetEntrySetId);

		RatingsStats ratingsStats = ratingsStatsLocalService.getStats(
			className, assetEntrySetId);

		assetEntrySet.setRatingsStatsTotalScore(
			(int)ratingsStats.getTotalScore());

		assetEntrySetPersistence.update(assetEntrySet);

		return assetEntrySet;
	}

	private static final long _ASSET_ENTRY_SET_CLASS_NAME_ID =
		ClassNameLocalServiceUtil.getClassNameId(AssetEntrySet.class);

	private static final long _USER_CLASS_NAME_ID =
		ClassNameLocalServiceUtil.getClassNameId(User.class);

}