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
@Table(name = "deptworkhours")
public class DeptWorkHours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deptWorkHourId;
	private Integer departmentId;
	private Integer groupById;
	private Integer companyId;
	private Date deptFrom;
	private Date deptTo;
	private Boolean includeNonbillableHours;
	private Date createOn;
	private Date updatedOn;
	private Boolean isDeleted;
	@ManyToOne
	@JoinColumn(name = "departmentId", insertable = false, updatable = false)
	private Department department;
	@ManyToOne
	@JoinColumn(name = "groupById", insertable = false, updatable = false)
	private LookUpDetails groupBy;

	public Integer getDeptWorkHourId() {
		return deptWorkHourId;
	}

	public void setDeptWorkHourId(Integer deptWorkHourId) {
		this.deptWorkHourId = deptWorkHourId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getGroupById() {
		return groupById;
	}

	public void setGroupById(Integer groupById) {
		this.groupById = groupById;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Date getDeptFrom() {
		return deptFrom;
	}

	public void setDeptFrom(Date deptFrom) {
		this.deptFrom = deptFrom;
	}

	public Date getDeptTo() {
		return deptTo;
	}

	public void setDeptTo(Date deptTo) {
		this.deptTo = deptTo;
	}

	public Boolean getIncludeNonbillableHours() {
		return includeNonbillableHours;
	}

	public void setIncludeNonbillableHours(Boolean includeNonbillableHours) {
		this.includeNonbillableHours = includeNonbillableHours;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public LookUpDetails getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(LookUpDetails groupBy) {
		this.groupBy = groupBy;
	}

}
