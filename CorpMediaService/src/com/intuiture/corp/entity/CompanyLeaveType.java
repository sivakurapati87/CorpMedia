package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companyleavetype")
public class CompanyLeaveType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyLeaveTypeId;
	private Integer companyId;
	private Date createdOn;
	private Date updatedOn;
	private Boolean isDeleted;
	private String leaveTypeName;
	private String leaveTypeDescription;
	private Boolean isPaidLeave;
	private Boolean isSickLeave;
	private Boolean isStatutoryLeave;
	private Boolean isCommentRequired;
	private Boolean isDocumentProofRequired;
	private Integer documentNeeded_After;
	private Boolean isPriorNoticeRequired;
	private Integer priorNoticeRequered_After;
	private Integer restrictToId;
	private Boolean isRestricted;
	private Boolean isHalfDayLeaveAllowed;

	public Integer getCompanyLeaveTypeId() {
		return companyLeaveTypeId;
	}

	public void setCompanyLeaveTypeId(Integer companyLeaveTypeId) {
		this.companyLeaveTypeId = companyLeaveTypeId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public String getLeaveTypeDescription() {
		return leaveTypeDescription;
	}

	public void setLeaveTypeDescription(String leaveTypeDescription) {
		this.leaveTypeDescription = leaveTypeDescription;
	}

	public Boolean getIsPaidLeave() {
		return isPaidLeave;
	}

	public void setIsPaidLeave(Boolean isPaidLeave) {
		this.isPaidLeave = isPaidLeave;
	}

	public Boolean getIsSickLeave() {
		return isSickLeave;
	}

	public void setIsSickLeave(Boolean isSickLeave) {
		this.isSickLeave = isSickLeave;
	}

	public Boolean getIsStatutoryLeave() {
		return isStatutoryLeave;
	}

	public void setIsStatutoryLeave(Boolean isStatutoryLeave) {
		this.isStatutoryLeave = isStatutoryLeave;
	}

	public Boolean getIsCommentRequired() {
		return isCommentRequired;
	}

	public void setIsCommentRequired(Boolean isCommentRequired) {
		this.isCommentRequired = isCommentRequired;
	}

	public Boolean getIsDocumentProofRequired() {
		return isDocumentProofRequired;
	}

	public void setIsDocumentProofRequired(Boolean isDocumentProofRequired) {
		this.isDocumentProofRequired = isDocumentProofRequired;
	}

	public Integer getDocumentNeeded_After() {
		return documentNeeded_After;
	}

	public void setDocumentNeeded_After(Integer documentNeeded_After) {
		this.documentNeeded_After = documentNeeded_After;
	}

	public Boolean getIsPriorNoticeRequired() {
		return isPriorNoticeRequired;
	}

	public void setIsPriorNoticeRequired(Boolean isPriorNoticeRequired) {
		this.isPriorNoticeRequired = isPriorNoticeRequired;
	}

	public Integer getPriorNoticeRequered_After() {
		return priorNoticeRequered_After;
	}

	public void setPriorNoticeRequered_After(Integer priorNoticeRequered_After) {
		this.priorNoticeRequered_After = priorNoticeRequered_After;
	}

	public Integer getRestrictToId() {
		return restrictToId;
	}

	public void setRestrictToId(Integer restrictToId) {
		this.restrictToId = restrictToId;
	}

	public Boolean getIsRestricted() {
		return isRestricted;
	}

	public void setIsRestricted(Boolean isRestricted) {
		this.isRestricted = isRestricted;
	}

	public Boolean getIsHalfDayLeaveAllowed() {
		return isHalfDayLeaveAllowed;
	}

	public void setIsHalfDayLeaveAllowed(Boolean isHalfDayLeaveAllowed) {
		this.isHalfDayLeaveAllowed = isHalfDayLeaveAllowed;
	}

}
