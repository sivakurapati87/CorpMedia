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
@Table(name = "companyemployeedefaults")
public class CompanyEmployeeDefaults {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyEmployeeDefaultsId;
	private Integer probationPeriod;
	private Integer probatioPeriodTypeId;
	private Integer workerTypeId;
	private Integer timeTypeId;
	private Integer noticePeriod;
	private Integer noticePeriodId;
	private Integer companyId;
	private Date createdOn;
	private Date updatedOn;
	private Boolean isDeleted;
	private Boolean isEmpAllowedToUpdate;
	@ManyToOne
	@JoinColumn(name = "probatioPeriodTypeId", insertable = false, updatable = false)
	private LookUpDetails probationPeriodType;
	@ManyToOne
	@JoinColumn(name = "workerTypeId", insertable = false, updatable = false)
	private LookUpDetails workerType;
	@ManyToOne
	@JoinColumn(name = "timeTypeId", insertable = false, updatable = false)
	private LookUpDetails timeType;
	@ManyToOne
	@JoinColumn(name = "noticePeriodId", insertable = false, updatable = false)
	private LookUpDetails noticePeriodType;

	public Integer getCompanyEmployeeDefaultsId() {
		return companyEmployeeDefaultsId;
	}

	public void setCompanyEmployeeDefaultsId(Integer companyEmployeeDefaultsId) {
		this.companyEmployeeDefaultsId = companyEmployeeDefaultsId;
	}

	public Integer getProbationPeriod() {
		return probationPeriod;
	}

	public void setProbationPeriod(Integer probationPeriod) {
		this.probationPeriod = probationPeriod;
	}

	public Integer getProbatioPeriodTypeId() {
		return probatioPeriodTypeId;
	}

	public void setProbatioPeriodTypeId(Integer probatioPeriodTypeId) {
		this.probatioPeriodTypeId = probatioPeriodTypeId;
	}

	public Integer getWorkerTypeId() {
		return workerTypeId;
	}

	public void setWorkerTypeId(Integer workerTypeId) {
		this.workerTypeId = workerTypeId;
	}

	public Integer getTimeTypeId() {
		return timeTypeId;
	}

	public void setTimeTypeId(Integer timeTypeId) {
		this.timeTypeId = timeTypeId;
	}

	public Integer getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(Integer noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public Integer getNoticePeriodId() {
		return noticePeriodId;
	}

	public void setNoticePeriodId(Integer noticePeriodId) {
		this.noticePeriodId = noticePeriodId;
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

	public LookUpDetails getProbationPeriodType() {
		return probationPeriodType;
	}

	public void setProbationPeriodType(LookUpDetails probationPeriodType) {
		this.probationPeriodType = probationPeriodType;
	}

	public LookUpDetails getWorkerType() {
		return workerType;
	}

	public void setWorkerType(LookUpDetails workerType) {
		this.workerType = workerType;
	}

	public LookUpDetails getTimeType() {
		return timeType;
	}

	public void setTimeType(LookUpDetails timeType) {
		this.timeType = timeType;
	}

	public LookUpDetails getNoticePeriodType() {
		return noticePeriodType;
	}

	public void setNoticePeriodType(LookUpDetails noticePeriodType) {
		this.noticePeriodType = noticePeriodType;
	}

	public Boolean getIsEmpAllowedToUpdate() {
		return isEmpAllowedToUpdate;
	}

	public void setIsEmpAllowedToUpdate(Boolean isEmpAllowedToUpdate) {
		this.isEmpAllowedToUpdate = isEmpAllowedToUpdate;
	}

}
