package com.intuiture.corp.json;

import java.util.Date;

public class DeptWorkHoursJson {
	
	private Date from;
	private Date to;
	private String strFrom;
	private String strTo;
	private Date createOn;
	private Boolean isDeleted;
	private Integer departmentId;
	private Integer groupById;
	private Integer companyId;
	private Integer deptWorkHourId;
	private Boolean includeNonbillableHours;
	
	
	
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public String getStrFrom() {
		return strFrom;
	}
	public void setStrFrom(String strFrom) {
		this.strFrom = strFrom;
	}
	public String getStrTo() {
		return strTo;
	}
	public void setStrTo(String strTo) {
		this.strTo = strTo;
	}
	public Date getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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
	public Integer getDeptWorkHourId() {
		return deptWorkHourId;
	}
	public void setDeptWorkHourId(Integer deptWorkHourId) {
		this.deptWorkHourId = deptWorkHourId;
	}
	public Boolean getIncludeNonbillableHours() {
		return includeNonbillableHours;
	}
	public void setIncludeNonbillableHours(Boolean includeNonbillableHours) {
		this.includeNonbillableHours = includeNonbillableHours;
	}
	

}


