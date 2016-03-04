package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addleavetype")
public class AddLeaveType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addLeaveTypeId;
	private Integer companyId;
	private Date createdOn;
	private Date updatedOn;
	private Boolean isDeleted;
	private Integer companyLeavePlanId;
	private Integer leaveTypeId;
	private Integer annualQuota;
	private Boolean isProrate;
	private Integer prorateFrom;
	private Integer annualQuotaTypeId;
	private Integer leavesAvailedFrom;
	private Integer leavesAvailedFromTypeId;
	private Integer leaveAvailabilityTypeId;
	private Integer accruedRateId;
	private Integer accruedRateOn;
	private Integer accrualStartFromTypeId;
	private Integer accruedLeaveLapseAfter;
	private Integer accruedLeaveLapseTypeId;
	private Boolean isAllowUtilizationOfLeaves;
	private Integer frequencyOfLeaves;
	private Integer consecutiveBtPaidLeavesHoliday;
	private Integer consecutiveBtPaidLeavesWeekOff;
	private Integer endOfLeaveCalenderTypeId;
	private Integer carryForwardMaxValue;
	private Integer payMaximumValue;
	@ManyToOne
	@JoinColumn(name = "leaveTypeId", insertable = false, updatable = false)
	private CompanyLeaveType companyLeaveType;

	public Integer getAddLeaveTypeId() {
		return addLeaveTypeId;
	}

	public void setAddLeaveTypeId(Integer addLeaveTypeId) {
		this.addLeaveTypeId = addLeaveTypeId;
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

	public Integer getCompanyLeavePlanId() {
		return companyLeavePlanId;
	}

	public void setCompanyLeavePlanId(Integer companyLeavePlanId) {
		this.companyLeavePlanId = companyLeavePlanId;
	}

	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public Integer getAnnualQuota() {
		return annualQuota;
	}

	public void setAnnualQuota(Integer annualQuota) {
		this.annualQuota = annualQuota;
	}

	public Boolean getIsProrate() {
		return isProrate;
	}

	public void setIsProrate(Boolean isProrate) {
		this.isProrate = isProrate;
	}

	public Integer getProrateFrom() {
		return prorateFrom;
	}

	public void setProrateFrom(Integer prorateFrom) {
		this.prorateFrom = prorateFrom;
	}

	public Integer getAnnualQuotaTypeId() {
		return annualQuotaTypeId;
	}

	public void setAnnualQuotaTypeId(Integer annualQuotaTypeId) {
		this.annualQuotaTypeId = annualQuotaTypeId;
	}

	public Integer getLeavesAvailedFrom() {
		return leavesAvailedFrom;
	}

	public void setLeavesAvailedFrom(Integer leavesAvailedFrom) {
		this.leavesAvailedFrom = leavesAvailedFrom;
	}

	public Integer getLeavesAvailedFromTypeId() {
		return leavesAvailedFromTypeId;
	}

	public void setLeavesAvailedFromTypeId(Integer leavesAvailedFromTypeId) {
		this.leavesAvailedFromTypeId = leavesAvailedFromTypeId;
	}

	public Integer getLeaveAvailabilityTypeId() {
		return leaveAvailabilityTypeId;
	}

	public void setLeaveAvailabilityTypeId(Integer leaveAvailabilityTypeId) {
		this.leaveAvailabilityTypeId = leaveAvailabilityTypeId;
	}

	public Integer getAccruedRateId() {
		return accruedRateId;
	}

	public void setAccruedRateId(Integer accruedRateId) {
		this.accruedRateId = accruedRateId;
	}

	public Integer getAccruedRateOn() {
		return accruedRateOn;
	}

	public void setAccruedRateOn(Integer accruedRateOn) {
		this.accruedRateOn = accruedRateOn;
	}

	public Integer getAccrualStartFromTypeId() {
		return accrualStartFromTypeId;
	}

	public void setAccrualStartFromTypeId(Integer accrualStartFromTypeId) {
		this.accrualStartFromTypeId = accrualStartFromTypeId;
	}

	public Integer getAccruedLeaveLapseAfter() {
		return accruedLeaveLapseAfter;
	}

	public void setAccruedLeaveLapseAfter(Integer accruedLeaveLapseAfter) {
		this.accruedLeaveLapseAfter = accruedLeaveLapseAfter;
	}

	public Integer getAccruedLeaveLapseTypeId() {
		return accruedLeaveLapseTypeId;
	}

	public void setAccruedLeaveLapseTypeId(Integer accruedLeaveLapseTypeId) {
		this.accruedLeaveLapseTypeId = accruedLeaveLapseTypeId;
	}

	public Boolean getIsAllowUtilizationOfLeaves() {
		return isAllowUtilizationOfLeaves;
	}

	public void setIsAllowUtilizationOfLeaves(Boolean isAllowUtilizationOfLeaves) {
		this.isAllowUtilizationOfLeaves = isAllowUtilizationOfLeaves;
	}

	public Integer getFrequencyOfLeaves() {
		return frequencyOfLeaves;
	}

	public void setFrequencyOfLeaves(Integer frequencyOfLeaves) {
		this.frequencyOfLeaves = frequencyOfLeaves;
	}

	public Integer getConsecutiveBtPaidLeavesHoliday() {
		return consecutiveBtPaidLeavesHoliday;
	}

	public void setConsecutiveBtPaidLeavesHoliday(Integer consecutiveBtPaidLeavesHoliday) {
		this.consecutiveBtPaidLeavesHoliday = consecutiveBtPaidLeavesHoliday;
	}

	public Integer getConsecutiveBtPaidLeavesWeekOff() {
		return consecutiveBtPaidLeavesWeekOff;
	}

	public void setConsecutiveBtPaidLeavesWeekOff(Integer consecutiveBtPaidLeavesWeekOff) {
		this.consecutiveBtPaidLeavesWeekOff = consecutiveBtPaidLeavesWeekOff;
	}

	public Integer getEndOfLeaveCalenderTypeId() {
		return endOfLeaveCalenderTypeId;
	}

	public void setEndOfLeaveCalenderTypeId(Integer endOfLeaveCalenderTypeId) {
		this.endOfLeaveCalenderTypeId = endOfLeaveCalenderTypeId;
	}

	public Integer getCarryForwardMaxValue() {
		return carryForwardMaxValue;
	}

	public void setCarryForwardMaxValue(Integer carryForwardMaxValue) {
		this.carryForwardMaxValue = carryForwardMaxValue;
	}

	public Integer getPayMaximumValue() {
		return payMaximumValue;
	}

	public void setPayMaximumValue(Integer payMaximumValue) {
		this.payMaximumValue = payMaximumValue;
	}

	public CompanyLeaveType getCompanyLeaveType() {
		return companyLeaveType;
	}

	public void setCompanyLeaveType(CompanyLeaveType companyLeaveType) {
		this.companyLeaveType = companyLeaveType;
	}

}
