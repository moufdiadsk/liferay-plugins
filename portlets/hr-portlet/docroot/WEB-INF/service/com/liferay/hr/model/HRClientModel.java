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

package com.liferay.hr.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the HRClient service. Represents a row in the &quot;HRClient&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.hr.model.impl.HRClientModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.hr.model.impl.HRClientImpl}.
 * </p>
 *
 * @author Wesley Gong
 * @see HRClient
 * @see com.liferay.hr.model.impl.HRClientImpl
 * @see com.liferay.hr.model.impl.HRClientModelImpl
 * @generated
 */
public interface HRClientModel extends BaseModel<HRClient>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a h r client model instance should use the {@link HRClient} interface instead.
	 */

	/**
	 * Gets the primary key of this h r client.
	 *
	 * @return the primary key of this h r client
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this h r client
	 *
	 * @param primaryKey the primary key of this h r client
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Gets the hr client ID of this h r client.
	 *
	 * @return the hr client ID of this h r client
	 */
	public long getHrClientId();

	/**
	 * Sets the hr client ID of this h r client.
	 *
	 * @param hrClientId the hr client ID of this h r client
	 */
	public void setHrClientId(long hrClientId);

	/**
	 * Gets the group ID of this h r client.
	 *
	 * @return the group ID of this h r client
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this h r client.
	 *
	 * @param groupId the group ID of this h r client
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company ID of this h r client.
	 *
	 * @return the company ID of this h r client
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this h r client.
	 *
	 * @param companyId the company ID of this h r client
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user ID of this h r client.
	 *
	 * @return the user ID of this h r client
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this h r client.
	 *
	 * @param userId the user ID of this h r client
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this h r client.
	 *
	 * @return the user uuid of this h r client
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this h r client.
	 *
	 * @param userUuid the user uuid of this h r client
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this h r client.
	 *
	 * @return the user name of this h r client
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this h r client.
	 *
	 * @param userName the user name of this h r client
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this h r client.
	 *
	 * @return the create date of this h r client
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this h r client.
	 *
	 * @param createDate the create date of this h r client
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this h r client.
	 *
	 * @return the modified date of this h r client
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this h r client.
	 *
	 * @param modifiedDate the modified date of this h r client
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the name of this h r client.
	 *
	 * @return the name of this h r client
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this h r client.
	 *
	 * @param name the name of this h r client
	 */
	public void setName(String name);

	/**
	 * Gets the description of this h r client.
	 *
	 * @return the description of this h r client
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this h r client.
	 *
	 * @param description the description of this h r client
	 */
	public void setDescription(String description);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(HRClient hrClient);

	public int hashCode();

	public HRClient toEscapedModel();

	public String toString();

	public String toXmlString();
}