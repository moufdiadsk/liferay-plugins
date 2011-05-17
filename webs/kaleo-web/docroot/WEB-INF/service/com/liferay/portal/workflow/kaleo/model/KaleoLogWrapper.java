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

package com.liferay.portal.workflow.kaleo.model;

/**
 * <p>
 * This class is a wrapper for {@link KaleoLog}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       KaleoLog
 * @generated
 */
public class KaleoLogWrapper implements KaleoLog {
	public KaleoLogWrapper(KaleoLog kaleoLog) {
		_kaleoLog = kaleoLog;
	}

	public Class<?> getModelClass() {
		return KaleoLog.class;
	}

	public String getModelClassName() {
		return KaleoLog.class.getName();
	}

	/**
	* Gets the primary key of this kaleo log.
	*
	* @return the primary key of this kaleo log
	*/
	public long getPrimaryKey() {
		return _kaleoLog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this kaleo log
	*
	* @param primaryKey the primary key of this kaleo log
	*/
	public void setPrimaryKey(long primaryKey) {
		_kaleoLog.setPrimaryKey(primaryKey);
	}

	/**
	* Gets the kaleo log ID of this kaleo log.
	*
	* @return the kaleo log ID of this kaleo log
	*/
	public long getKaleoLogId() {
		return _kaleoLog.getKaleoLogId();
	}

	/**
	* Sets the kaleo log ID of this kaleo log.
	*
	* @param kaleoLogId the kaleo log ID of this kaleo log
	*/
	public void setKaleoLogId(long kaleoLogId) {
		_kaleoLog.setKaleoLogId(kaleoLogId);
	}

	/**
	* Gets the group ID of this kaleo log.
	*
	* @return the group ID of this kaleo log
	*/
	public long getGroupId() {
		return _kaleoLog.getGroupId();
	}

	/**
	* Sets the group ID of this kaleo log.
	*
	* @param groupId the group ID of this kaleo log
	*/
	public void setGroupId(long groupId) {
		_kaleoLog.setGroupId(groupId);
	}

	/**
	* Gets the company ID of this kaleo log.
	*
	* @return the company ID of this kaleo log
	*/
	public long getCompanyId() {
		return _kaleoLog.getCompanyId();
	}

	/**
	* Sets the company ID of this kaleo log.
	*
	* @param companyId the company ID of this kaleo log
	*/
	public void setCompanyId(long companyId) {
		_kaleoLog.setCompanyId(companyId);
	}

	/**
	* Gets the user ID of this kaleo log.
	*
	* @return the user ID of this kaleo log
	*/
	public long getUserId() {
		return _kaleoLog.getUserId();
	}

	/**
	* Sets the user ID of this kaleo log.
	*
	* @param userId the user ID of this kaleo log
	*/
	public void setUserId(long userId) {
		_kaleoLog.setUserId(userId);
	}

	/**
	* Gets the user uuid of this kaleo log.
	*
	* @return the user uuid of this kaleo log
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kaleoLog.getUserUuid();
	}

	/**
	* Sets the user uuid of this kaleo log.
	*
	* @param userUuid the user uuid of this kaleo log
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_kaleoLog.setUserUuid(userUuid);
	}

	/**
	* Gets the user name of this kaleo log.
	*
	* @return the user name of this kaleo log
	*/
	public java.lang.String getUserName() {
		return _kaleoLog.getUserName();
	}

	/**
	* Sets the user name of this kaleo log.
	*
	* @param userName the user name of this kaleo log
	*/
	public void setUserName(java.lang.String userName) {
		_kaleoLog.setUserName(userName);
	}

	/**
	* Gets the create date of this kaleo log.
	*
	* @return the create date of this kaleo log
	*/
	public java.util.Date getCreateDate() {
		return _kaleoLog.getCreateDate();
	}

	/**
	* Sets the create date of this kaleo log.
	*
	* @param createDate the create date of this kaleo log
	*/
	public void setCreateDate(java.util.Date createDate) {
		_kaleoLog.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this kaleo log.
	*
	* @return the modified date of this kaleo log
	*/
	public java.util.Date getModifiedDate() {
		return _kaleoLog.getModifiedDate();
	}

	/**
	* Sets the modified date of this kaleo log.
	*
	* @param modifiedDate the modified date of this kaleo log
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_kaleoLog.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the kaleo definition ID of this kaleo log.
	*
	* @return the kaleo definition ID of this kaleo log
	*/
	public long getKaleoDefinitionId() {
		return _kaleoLog.getKaleoDefinitionId();
	}

	/**
	* Sets the kaleo definition ID of this kaleo log.
	*
	* @param kaleoDefinitionId the kaleo definition ID of this kaleo log
	*/
	public void setKaleoDefinitionId(long kaleoDefinitionId) {
		_kaleoLog.setKaleoDefinitionId(kaleoDefinitionId);
	}

	/**
	* Gets the kaleo instance ID of this kaleo log.
	*
	* @return the kaleo instance ID of this kaleo log
	*/
	public long getKaleoInstanceId() {
		return _kaleoLog.getKaleoInstanceId();
	}

	/**
	* Sets the kaleo instance ID of this kaleo log.
	*
	* @param kaleoInstanceId the kaleo instance ID of this kaleo log
	*/
	public void setKaleoInstanceId(long kaleoInstanceId) {
		_kaleoLog.setKaleoInstanceId(kaleoInstanceId);
	}

	/**
	* Gets the kaleo instance token ID of this kaleo log.
	*
	* @return the kaleo instance token ID of this kaleo log
	*/
	public long getKaleoInstanceTokenId() {
		return _kaleoLog.getKaleoInstanceTokenId();
	}

	/**
	* Sets the kaleo instance token ID of this kaleo log.
	*
	* @param kaleoInstanceTokenId the kaleo instance token ID of this kaleo log
	*/
	public void setKaleoInstanceTokenId(long kaleoInstanceTokenId) {
		_kaleoLog.setKaleoInstanceTokenId(kaleoInstanceTokenId);
	}

	/**
	* Gets the kaleo task instance token ID of this kaleo log.
	*
	* @return the kaleo task instance token ID of this kaleo log
	*/
	public long getKaleoTaskInstanceTokenId() {
		return _kaleoLog.getKaleoTaskInstanceTokenId();
	}

	/**
	* Sets the kaleo task instance token ID of this kaleo log.
	*
	* @param kaleoTaskInstanceTokenId the kaleo task instance token ID of this kaleo log
	*/
	public void setKaleoTaskInstanceTokenId(long kaleoTaskInstanceTokenId) {
		_kaleoLog.setKaleoTaskInstanceTokenId(kaleoTaskInstanceTokenId);
	}

	/**
	* Gets the kaleo node ID of this kaleo log.
	*
	* @return the kaleo node ID of this kaleo log
	*/
	public long getKaleoNodeId() {
		return _kaleoLog.getKaleoNodeId();
	}

	/**
	* Sets the kaleo node ID of this kaleo log.
	*
	* @param kaleoNodeId the kaleo node ID of this kaleo log
	*/
	public void setKaleoNodeId(long kaleoNodeId) {
		_kaleoLog.setKaleoNodeId(kaleoNodeId);
	}

	/**
	* Gets the kaleo node name of this kaleo log.
	*
	* @return the kaleo node name of this kaleo log
	*/
	public java.lang.String getKaleoNodeName() {
		return _kaleoLog.getKaleoNodeName();
	}

	/**
	* Sets the kaleo node name of this kaleo log.
	*
	* @param kaleoNodeName the kaleo node name of this kaleo log
	*/
	public void setKaleoNodeName(java.lang.String kaleoNodeName) {
		_kaleoLog.setKaleoNodeName(kaleoNodeName);
	}

	/**
	* Gets the terminal kaleo node of this kaleo log.
	*
	* @return the terminal kaleo node of this kaleo log
	*/
	public boolean getTerminalKaleoNode() {
		return _kaleoLog.getTerminalKaleoNode();
	}

	/**
	* Determines if this kaleo log is terminal kaleo node.
	*
	* @return <code>true</code> if this kaleo log is terminal kaleo node; <code>false</code> otherwise
	*/
	public boolean isTerminalKaleoNode() {
		return _kaleoLog.isTerminalKaleoNode();
	}

	/**
	* Sets whether this kaleo log is terminal kaleo node.
	*
	* @param terminalKaleoNode the terminal kaleo node of this kaleo log
	*/
	public void setTerminalKaleoNode(boolean terminalKaleoNode) {
		_kaleoLog.setTerminalKaleoNode(terminalKaleoNode);
	}

	/**
	* Gets the kaleo action ID of this kaleo log.
	*
	* @return the kaleo action ID of this kaleo log
	*/
	public long getKaleoActionId() {
		return _kaleoLog.getKaleoActionId();
	}

	/**
	* Sets the kaleo action ID of this kaleo log.
	*
	* @param kaleoActionId the kaleo action ID of this kaleo log
	*/
	public void setKaleoActionId(long kaleoActionId) {
		_kaleoLog.setKaleoActionId(kaleoActionId);
	}

	/**
	* Gets the kaleo action name of this kaleo log.
	*
	* @return the kaleo action name of this kaleo log
	*/
	public java.lang.String getKaleoActionName() {
		return _kaleoLog.getKaleoActionName();
	}

	/**
	* Sets the kaleo action name of this kaleo log.
	*
	* @param kaleoActionName the kaleo action name of this kaleo log
	*/
	public void setKaleoActionName(java.lang.String kaleoActionName) {
		_kaleoLog.setKaleoActionName(kaleoActionName);
	}

	/**
	* Gets the kaleo action description of this kaleo log.
	*
	* @return the kaleo action description of this kaleo log
	*/
	public java.lang.String getKaleoActionDescription() {
		return _kaleoLog.getKaleoActionDescription();
	}

	/**
	* Sets the kaleo action description of this kaleo log.
	*
	* @param kaleoActionDescription the kaleo action description of this kaleo log
	*/
	public void setKaleoActionDescription(
		java.lang.String kaleoActionDescription) {
		_kaleoLog.setKaleoActionDescription(kaleoActionDescription);
	}

	/**
	* Gets the previous kaleo node ID of this kaleo log.
	*
	* @return the previous kaleo node ID of this kaleo log
	*/
	public long getPreviousKaleoNodeId() {
		return _kaleoLog.getPreviousKaleoNodeId();
	}

	/**
	* Sets the previous kaleo node ID of this kaleo log.
	*
	* @param previousKaleoNodeId the previous kaleo node ID of this kaleo log
	*/
	public void setPreviousKaleoNodeId(long previousKaleoNodeId) {
		_kaleoLog.setPreviousKaleoNodeId(previousKaleoNodeId);
	}

	/**
	* Gets the previous kaleo node name of this kaleo log.
	*
	* @return the previous kaleo node name of this kaleo log
	*/
	public java.lang.String getPreviousKaleoNodeName() {
		return _kaleoLog.getPreviousKaleoNodeName();
	}

	/**
	* Sets the previous kaleo node name of this kaleo log.
	*
	* @param previousKaleoNodeName the previous kaleo node name of this kaleo log
	*/
	public void setPreviousKaleoNodeName(java.lang.String previousKaleoNodeName) {
		_kaleoLog.setPreviousKaleoNodeName(previousKaleoNodeName);
	}

	/**
	* Gets the previous assignee class name of this kaleo log.
	*
	* @return the previous assignee class name of this kaleo log
	*/
	public java.lang.String getPreviousAssigneeClassName() {
		return _kaleoLog.getPreviousAssigneeClassName();
	}

	/**
	* Sets the previous assignee class name of this kaleo log.
	*
	* @param previousAssigneeClassName the previous assignee class name of this kaleo log
	*/
	public void setPreviousAssigneeClassName(
		java.lang.String previousAssigneeClassName) {
		_kaleoLog.setPreviousAssigneeClassName(previousAssigneeClassName);
	}

	/**
	* Gets the previous assignee class p k of this kaleo log.
	*
	* @return the previous assignee class p k of this kaleo log
	*/
	public long getPreviousAssigneeClassPK() {
		return _kaleoLog.getPreviousAssigneeClassPK();
	}

	/**
	* Sets the previous assignee class p k of this kaleo log.
	*
	* @param previousAssigneeClassPK the previous assignee class p k of this kaleo log
	*/
	public void setPreviousAssigneeClassPK(long previousAssigneeClassPK) {
		_kaleoLog.setPreviousAssigneeClassPK(previousAssigneeClassPK);
	}

	/**
	* Gets the current assignee class name of this kaleo log.
	*
	* @return the current assignee class name of this kaleo log
	*/
	public java.lang.String getCurrentAssigneeClassName() {
		return _kaleoLog.getCurrentAssigneeClassName();
	}

	/**
	* Sets the current assignee class name of this kaleo log.
	*
	* @param currentAssigneeClassName the current assignee class name of this kaleo log
	*/
	public void setCurrentAssigneeClassName(
		java.lang.String currentAssigneeClassName) {
		_kaleoLog.setCurrentAssigneeClassName(currentAssigneeClassName);
	}

	/**
	* Gets the current assignee class p k of this kaleo log.
	*
	* @return the current assignee class p k of this kaleo log
	*/
	public long getCurrentAssigneeClassPK() {
		return _kaleoLog.getCurrentAssigneeClassPK();
	}

	/**
	* Sets the current assignee class p k of this kaleo log.
	*
	* @param currentAssigneeClassPK the current assignee class p k of this kaleo log
	*/
	public void setCurrentAssigneeClassPK(long currentAssigneeClassPK) {
		_kaleoLog.setCurrentAssigneeClassPK(currentAssigneeClassPK);
	}

	/**
	* Gets the type of this kaleo log.
	*
	* @return the type of this kaleo log
	*/
	public java.lang.String getType() {
		return _kaleoLog.getType();
	}

	/**
	* Sets the type of this kaleo log.
	*
	* @param type the type of this kaleo log
	*/
	public void setType(java.lang.String type) {
		_kaleoLog.setType(type);
	}

	/**
	* Gets the comment of this kaleo log.
	*
	* @return the comment of this kaleo log
	*/
	public java.lang.String getComment() {
		return _kaleoLog.getComment();
	}

	/**
	* Sets the comment of this kaleo log.
	*
	* @param comment the comment of this kaleo log
	*/
	public void setComment(java.lang.String comment) {
		_kaleoLog.setComment(comment);
	}

	/**
	* Gets the start date of this kaleo log.
	*
	* @return the start date of this kaleo log
	*/
	public java.util.Date getStartDate() {
		return _kaleoLog.getStartDate();
	}

	/**
	* Sets the start date of this kaleo log.
	*
	* @param startDate the start date of this kaleo log
	*/
	public void setStartDate(java.util.Date startDate) {
		_kaleoLog.setStartDate(startDate);
	}

	/**
	* Gets the end date of this kaleo log.
	*
	* @return the end date of this kaleo log
	*/
	public java.util.Date getEndDate() {
		return _kaleoLog.getEndDate();
	}

	/**
	* Sets the end date of this kaleo log.
	*
	* @param endDate the end date of this kaleo log
	*/
	public void setEndDate(java.util.Date endDate) {
		_kaleoLog.setEndDate(endDate);
	}

	/**
	* Gets the duration of this kaleo log.
	*
	* @return the duration of this kaleo log
	*/
	public long getDuration() {
		return _kaleoLog.getDuration();
	}

	/**
	* Sets the duration of this kaleo log.
	*
	* @param duration the duration of this kaleo log
	*/
	public void setDuration(long duration) {
		_kaleoLog.setDuration(duration);
	}

	/**
	* Gets the workflow context of this kaleo log.
	*
	* @return the workflow context of this kaleo log
	*/
	public java.lang.String getWorkflowContext() {
		return _kaleoLog.getWorkflowContext();
	}

	/**
	* Sets the workflow context of this kaleo log.
	*
	* @param workflowContext the workflow context of this kaleo log
	*/
	public void setWorkflowContext(java.lang.String workflowContext) {
		_kaleoLog.setWorkflowContext(workflowContext);
	}

	public boolean isNew() {
		return _kaleoLog.isNew();
	}

	public void setNew(boolean n) {
		_kaleoLog.setNew(n);
	}

	public boolean isCachedModel() {
		return _kaleoLog.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_kaleoLog.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _kaleoLog.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_kaleoLog.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _kaleoLog.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_kaleoLog.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _kaleoLog.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_kaleoLog.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new KaleoLogWrapper((KaleoLog)_kaleoLog.clone());
	}

	public int compareTo(
		com.liferay.portal.workflow.kaleo.model.KaleoLog kaleoLog) {
		return _kaleoLog.compareTo(kaleoLog);
	}

	public int hashCode() {
		return _kaleoLog.hashCode();
	}

	public com.liferay.portal.workflow.kaleo.model.KaleoLog toEscapedModel() {
		return new KaleoLogWrapper(_kaleoLog.toEscapedModel());
	}

	public java.lang.String toString() {
		return _kaleoLog.toString();
	}

	public java.lang.String toXmlString() {
		return _kaleoLog.toXmlString();
	}

	public KaleoLog getWrappedKaleoLog() {
		return _kaleoLog;
	}

	public void resetOriginalValues() {
		_kaleoLog.resetOriginalValues();
	}

	private KaleoLog _kaleoLog;
}