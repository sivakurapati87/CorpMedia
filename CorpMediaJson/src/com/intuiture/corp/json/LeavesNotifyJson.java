package com.intuiture.corp.json;

import java.util.Date;

public class LeavesNotifyJson {
	private Integer leavesNotifyId;
	private Date createdOn;
	private Date updatedOn;
	private Integer companyId;
	private Boolean isDeleted;
	private Integer notifyEmpId;
	private String notifierName;

	public Integer getLeavesNotifyId() {
		return leavesNotifyId;
	}

	public void setLeavesNotifyId(Integer leavesNotifyId) {
		this.leavesNotifyId = leavesNotifyId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getNotifyEmpId() {
		return notifyEmpId;
	}

	public void setNotifyEmpId(Integer notifyEmpId) {
		this.notifyEmpId = notifyEmpId;
	}

	public String getNotifierName() {
		return notifierName;
	}

	public void setNotifierName(String notifierName) {
		this.notifierName = notifierName;
	}

}
