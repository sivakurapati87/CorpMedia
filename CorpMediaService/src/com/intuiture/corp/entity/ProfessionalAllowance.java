package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professionalallowance")
public class ProfessionalAllowance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer professionalAllowanceId;
	private Double maxAnnualLimit;
	private Integer requireSubmissionId;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private Integer companyId;

	public Integer getProfessionalAllowanceId() {
		return professionalAllowanceId;
	}

	public void setProfessionalAllowanceId(Integer professionalAllowanceId) {
		this.professionalAllowanceId = professionalAllowanceId;
	}

	public Double getMaxAnnualLimit() {
		return maxAnnualLimit;
	}

	public void setMaxAnnualLimit(Double maxAnnualLimit) {
		this.maxAnnualLimit = maxAnnualLimit;
	}

	public Integer getRequireSubmissionId() {
		return requireSubmissionId;
	}

	public void setRequireSubmissionId(Integer requireSubmissionId) {
		this.requireSubmissionId = requireSubmissionId;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

}
