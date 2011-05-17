/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.hr.model.impl;

import com.liferay.hr.model.HRTimeSheet;
import com.liferay.hr.model.HRTimeSheetModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the HRTimeSheet service. Represents a row in the &quot;HRTimeSheet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.hr.model.HRTimeSheetModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HRTimeSheetImpl}.
 * </p>
 *
 * @author Wesley Gong
 * @see HRTimeSheetImpl
 * @see com.liferay.hr.model.HRTimeSheet
 * @see com.liferay.hr.model.HRTimeSheetModel
 * @generated
 */
public class HRTimeSheetModelImpl extends BaseModelImpl<HRTimeSheet>
	implements HRTimeSheetModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a h r time sheet model instance should use the {@link com.liferay.hr.model.HRTimeSheet} interface instead.
	 */
	public static final String TABLE_NAME = "HRTimeSheet";
	public static final Object[][] TABLE_COLUMNS = {
			{ "hrTimeSheetId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "hrUserId", Types.BIGINT },
			{ "startDayOfYear", Types.INTEGER },
			{ "endDayOfYear", Types.INTEGER },
			{ "year", Types.INTEGER },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table HRTimeSheet (hrTimeSheetId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,hrUserId LONG,startDayOfYear INTEGER,endDayOfYear INTEGER,year INTEGER,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table HRTimeSheet";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.hr.model.HRTimeSheet"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.hr.model.HRTimeSheet"),
			true);

	public Class<?> getModelClass() {
		return HRTimeSheet.class;
	}

	public String getModelClassName() {
		return HRTimeSheet.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.hr.model.HRTimeSheet"));

	public HRTimeSheetModelImpl() {
	}

	public long getPrimaryKey() {
		return _hrTimeSheetId;
	}

	public void setPrimaryKey(long primaryKey) {
		setHrTimeSheetId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_hrTimeSheetId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getHrTimeSheetId() {
		return _hrTimeSheetId;
	}

	public void setHrTimeSheetId(long hrTimeSheetId) {
		_hrTimeSheetId = hrTimeSheetId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getHrUserId() {
		return _hrUserId;
	}

	public void setHrUserId(long hrUserId) {
		_hrUserId = hrUserId;
	}

	public String getHrUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getHrUserId(), "uuid", _hrUserUuid);
	}

	public void setHrUserUuid(String hrUserUuid) {
		_hrUserUuid = hrUserUuid;
	}

	public int getStartDayOfYear() {
		return _startDayOfYear;
	}

	public void setStartDayOfYear(int startDayOfYear) {
		_startDayOfYear = startDayOfYear;
	}

	public int getEndDayOfYear() {
		return _endDayOfYear;
	}

	public void setEndDayOfYear(int endDayOfYear) {
		_endDayOfYear = endDayOfYear;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	/**
	 * @deprecated {@link #isApproved}
	 */
	public boolean getApproved() {
		return isApproved();
	}

	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	public HRTimeSheet toEscapedModel() {
		if (isEscapedModel()) {
			return (HRTimeSheet)this;
		}
		else {
			return (HRTimeSheet)Proxy.newProxyInstance(HRTimeSheet.class.getClassLoader(),
				new Class[] { HRTimeSheet.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					HRTimeSheet.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		HRTimeSheetImpl hrTimeSheetImpl = new HRTimeSheetImpl();

		hrTimeSheetImpl.setHrTimeSheetId(getHrTimeSheetId());
		hrTimeSheetImpl.setGroupId(getGroupId());
		hrTimeSheetImpl.setCompanyId(getCompanyId());
		hrTimeSheetImpl.setUserId(getUserId());
		hrTimeSheetImpl.setUserName(getUserName());
		hrTimeSheetImpl.setCreateDate(getCreateDate());
		hrTimeSheetImpl.setModifiedDate(getModifiedDate());
		hrTimeSheetImpl.setHrUserId(getHrUserId());
		hrTimeSheetImpl.setStartDayOfYear(getStartDayOfYear());
		hrTimeSheetImpl.setEndDayOfYear(getEndDayOfYear());
		hrTimeSheetImpl.setYear(getYear());
		hrTimeSheetImpl.setStatus(getStatus());
		hrTimeSheetImpl.setStatusByUserId(getStatusByUserId());
		hrTimeSheetImpl.setStatusByUserName(getStatusByUserName());
		hrTimeSheetImpl.setStatusDate(getStatusDate());

		hrTimeSheetImpl.resetOriginalValues();

		return hrTimeSheetImpl;
	}

	public int compareTo(HRTimeSheet hrTimeSheet) {
		long primaryKey = hrTimeSheet.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		HRTimeSheet hrTimeSheet = null;

		try {
			hrTimeSheet = (HRTimeSheet)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hrTimeSheet.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public void resetOriginalValues() {
	}

	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{hrTimeSheetId=");
		sb.append(getHrTimeSheetId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", hrUserId=");
		sb.append(getHrUserId());
		sb.append(", startDayOfYear=");
		sb.append(getStartDayOfYear());
		sb.append(", endDayOfYear=");
		sb.append(getEndDayOfYear());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.liferay.hr.model.HRTimeSheet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>hrTimeSheetId</column-name><column-value><![CDATA[");
		sb.append(getHrTimeSheetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hrUserId</column-name><column-value><![CDATA[");
		sb.append(getHrUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDayOfYear</column-name><column-value><![CDATA[");
		sb.append(getStartDayOfYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDayOfYear</column-name><column-value><![CDATA[");
		sb.append(getEndDayOfYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _hrTimeSheetId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _hrUserId;
	private String _hrUserUuid;
	private int _startDayOfYear;
	private int _endDayOfYear;
	private int _year;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private transient ExpandoBridge _expandoBridge;
}