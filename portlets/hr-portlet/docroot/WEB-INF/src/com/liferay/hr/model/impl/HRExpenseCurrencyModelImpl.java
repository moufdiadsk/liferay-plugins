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

import com.liferay.hr.model.HRExpenseCurrency;
import com.liferay.hr.model.HRExpenseCurrencyModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
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
 * The base model implementation for the HRExpenseCurrency service. Represents a row in the &quot;HRExpenseCurrency&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.hr.model.HRExpenseCurrencyModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HRExpenseCurrencyImpl}.
 * </p>
 *
 * @author Wesley Gong
 * @see HRExpenseCurrencyImpl
 * @see com.liferay.hr.model.HRExpenseCurrency
 * @see com.liferay.hr.model.HRExpenseCurrencyModel
 * @generated
 */
public class HRExpenseCurrencyModelImpl extends BaseModelImpl<HRExpenseCurrency>
	implements HRExpenseCurrencyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a h r expense currency model instance should use the {@link com.liferay.hr.model.HRExpenseCurrency} interface instead.
	 */
	public static final String TABLE_NAME = "HRExpenseCurrency";
	public static final Object[][] TABLE_COLUMNS = {
			{ "hrExpenseCurrencyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "fromCurrencyCode", Types.VARCHAR },
			{ "toCurrencyCode", Types.VARCHAR },
			{ "conversionDate", Types.TIMESTAMP },
			{ "conversionValue", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table HRExpenseCurrency (hrExpenseCurrencyId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,fromCurrencyCode VARCHAR(75) null,toCurrencyCode VARCHAR(75) null,conversionDate DATE null,conversionValue DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table HRExpenseCurrency";
	public static final String ORDER_BY_JPQL = " ORDER BY hrExpenseCurrency.conversionDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY HRExpenseCurrency.conversionDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.hr.model.HRExpenseCurrency"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.hr.model.HRExpenseCurrency"),
			true);

	public Class<?> getModelClass() {
		return HRExpenseCurrency.class;
	}

	public String getModelClassName() {
		return HRExpenseCurrency.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.hr.model.HRExpenseCurrency"));

	public HRExpenseCurrencyModelImpl() {
	}

	public long getPrimaryKey() {
		return _hrExpenseCurrencyId;
	}

	public void setPrimaryKey(long primaryKey) {
		setHrExpenseCurrencyId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_hrExpenseCurrencyId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getHrExpenseCurrencyId() {
		return _hrExpenseCurrencyId;
	}

	public void setHrExpenseCurrencyId(long hrExpenseCurrencyId) {
		_hrExpenseCurrencyId = hrExpenseCurrencyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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

	public String getFromCurrencyCode() {
		if (_fromCurrencyCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _fromCurrencyCode;
		}
	}

	public void setFromCurrencyCode(String fromCurrencyCode) {
		if (_originalFromCurrencyCode == null) {
			_originalFromCurrencyCode = _fromCurrencyCode;
		}

		_fromCurrencyCode = fromCurrencyCode;
	}

	public String getOriginalFromCurrencyCode() {
		return GetterUtil.getString(_originalFromCurrencyCode);
	}

	public String getToCurrencyCode() {
		if (_toCurrencyCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _toCurrencyCode;
		}
	}

	public void setToCurrencyCode(String toCurrencyCode) {
		if (_originalToCurrencyCode == null) {
			_originalToCurrencyCode = _toCurrencyCode;
		}

		_toCurrencyCode = toCurrencyCode;
	}

	public String getOriginalToCurrencyCode() {
		return GetterUtil.getString(_originalToCurrencyCode);
	}

	public Date getConversionDate() {
		return _conversionDate;
	}

	public void setConversionDate(Date conversionDate) {
		if (_originalConversionDate == null) {
			_originalConversionDate = _conversionDate;
		}

		_conversionDate = conversionDate;
	}

	public Date getOriginalConversionDate() {
		return _originalConversionDate;
	}

	public double getConversionValue() {
		return _conversionValue;
	}

	public void setConversionValue(double conversionValue) {
		_conversionValue = conversionValue;
	}

	public HRExpenseCurrency toEscapedModel() {
		if (isEscapedModel()) {
			return (HRExpenseCurrency)this;
		}
		else {
			return (HRExpenseCurrency)Proxy.newProxyInstance(HRExpenseCurrency.class.getClassLoader(),
				new Class[] { HRExpenseCurrency.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					HRExpenseCurrency.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		HRExpenseCurrencyImpl hrExpenseCurrencyImpl = new HRExpenseCurrencyImpl();

		hrExpenseCurrencyImpl.setHrExpenseCurrencyId(getHrExpenseCurrencyId());
		hrExpenseCurrencyImpl.setGroupId(getGroupId());
		hrExpenseCurrencyImpl.setCompanyId(getCompanyId());
		hrExpenseCurrencyImpl.setUserId(getUserId());
		hrExpenseCurrencyImpl.setUserName(getUserName());
		hrExpenseCurrencyImpl.setCreateDate(getCreateDate());
		hrExpenseCurrencyImpl.setModifiedDate(getModifiedDate());
		hrExpenseCurrencyImpl.setFromCurrencyCode(getFromCurrencyCode());
		hrExpenseCurrencyImpl.setToCurrencyCode(getToCurrencyCode());
		hrExpenseCurrencyImpl.setConversionDate(getConversionDate());
		hrExpenseCurrencyImpl.setConversionValue(getConversionValue());

		hrExpenseCurrencyImpl.resetOriginalValues();

		return hrExpenseCurrencyImpl;
	}

	public int compareTo(HRExpenseCurrency hrExpenseCurrency) {
		int value = 0;

		value = DateUtil.compareTo(getConversionDate(),
				hrExpenseCurrency.getConversionDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		HRExpenseCurrency hrExpenseCurrency = null;

		try {
			hrExpenseCurrency = (HRExpenseCurrency)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hrExpenseCurrency.getPrimaryKey();

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
		HRExpenseCurrencyModelImpl hrExpenseCurrencyModelImpl = this;

		hrExpenseCurrencyModelImpl._originalGroupId = hrExpenseCurrencyModelImpl._groupId;

		hrExpenseCurrencyModelImpl._setOriginalGroupId = false;

		hrExpenseCurrencyModelImpl._originalFromCurrencyCode = hrExpenseCurrencyModelImpl._fromCurrencyCode;

		hrExpenseCurrencyModelImpl._originalToCurrencyCode = hrExpenseCurrencyModelImpl._toCurrencyCode;

		hrExpenseCurrencyModelImpl._originalConversionDate = hrExpenseCurrencyModelImpl._conversionDate;
	}

	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{hrExpenseCurrencyId=");
		sb.append(getHrExpenseCurrencyId());
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
		sb.append(", fromCurrencyCode=");
		sb.append(getFromCurrencyCode());
		sb.append(", toCurrencyCode=");
		sb.append(getToCurrencyCode());
		sb.append(", conversionDate=");
		sb.append(getConversionDate());
		sb.append(", conversionValue=");
		sb.append(getConversionValue());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.hr.model.HRExpenseCurrency");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>hrExpenseCurrencyId</column-name><column-value><![CDATA[");
		sb.append(getHrExpenseCurrencyId());
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
			"<column><column-name>fromCurrencyCode</column-name><column-value><![CDATA[");
		sb.append(getFromCurrencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toCurrencyCode</column-name><column-value><![CDATA[");
		sb.append(getToCurrencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>conversionDate</column-name><column-value><![CDATA[");
		sb.append(getConversionDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>conversionValue</column-name><column-value><![CDATA[");
		sb.append(getConversionValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _hrExpenseCurrencyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _fromCurrencyCode;
	private String _originalFromCurrencyCode;
	private String _toCurrencyCode;
	private String _originalToCurrencyCode;
	private Date _conversionDate;
	private Date _originalConversionDate;
	private double _conversionValue;
	private transient ExpandoBridge _expandoBridge;
}