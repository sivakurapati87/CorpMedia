package com.intuiture.corp.json;

import java.util.Date;

public class EmployeeLeaveJson {
	private Integer employeeId;
	private Integer leaveId;
	private Integer statusId;
	private Integer projectId;
	private String leaveTime;
	private String strLeaveStartDate;
	private String strLeaveEndDate;
	private String strTotalLeaveTime;
	private Integer leaveTypeId;
	private String note;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private String comment;
	private Integer approvedOrRejectedById;

	private String strLeaveIds;
	private String strLeaveDate;
	private String leaveType;
	private String appliedOn;
	private String employeeName;
	// This is to concatenate list of leave dates
	private String strLeaveDates;
	private Boolean isShowBlock = false;
	private String approveOrReject;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}

	public String getStrLeaveStartDate() {
		return strLeaveStartDate;
	}

	public void setStrLeaveStartDate(String strLeaveStartDate) {
		this.strLeaveStartDate = strLeaveStartDate;
	}

	public String getStrLeaveEndDate() {
		return strLeaveEndDate;
	}

	public void setStrLeaveEndDate(String strLeaveEndDate) {
		this.strLeaveEndDate = strLeaveEndDate;
	}

	public String getStrTotalLeaveTime() {
		return strTotalLeaveTime;
	}

	public void setStrTotalLeaveTime(String strTotalLeaveTime) {
		this.strTotalLeaveTime = strTotalLeaveTime;
	}

	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getLeaveStartDate() {
		return leaveStartDate;
	}

	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}

	public Date getLeaveEndDate() {
		return leaveEndDate;
	}

	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}

	public String getStrLeaveIds() {
		return strLeaveIds;
	}

	public void setStrLeaveIds(String strLeaveIds) {
		this.strLeaveIds = strLeaveIds;
	}

	public String getStrLeaveDate() {
		return strLeaveDate;
	}

	public void setStrLeaveDate(String strLeaveDate) {
		this.strLeaveDate = strLeaveDate;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getAppliedOn() {
		return appliedOn;
	}

	public void setAppliedOn(String appliedOn) {
		this.appliedOn = appliedOn;
	}

	public String getStrLeaveDates() {
		return strLeaveDates;
	}

	public void setStrLeaveDates(String strLeaveDates) {
		this.strLeaveDates = strLeaveDates;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Boolean getIsShowBlock() {
		return isShowBlock;
	}

	public void setIsShowBlock(Boolean isShowBlock) {
		this.isShowBlock = isShowBlock;
	}

	public String getApproveOrReject() {
		return approveOrReject;
	}

	public void setApproveOrReject(String approveOrReject) {
		this.approveOrReject = approveOrReject;
	}

	public Integer getApprovedOrRejectedById() {
		return approvedOrRejectedById;
	}

	public void setApprovedOrRejectedById(Integer approvedOrRejectedById) {
		this.approvedOrRejectedById = approvedOrRejectedById;
	}

}
