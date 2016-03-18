package com.intuiture.corp.json;

import java.util.Date;

public class ProjectJson {

	private Integer projectId;
	private Integer companyId;
	private Boolean isDeleted;

	private String client;
	private String projectName;
	private Integer clientsId;
	private Integer statusId;
	private String strStartDate;
	private String strEndDate;
	private Date startDate;
	private Date endDate;
	private String description;
	private String status;
	private Boolean isProjectAssignToAllEmployees;

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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStrStartDate() {
		return strStartDate;
	}

	public void setStrStartDate(String strStartDate) {
		this.strStartDate = strStartDate;
	}

	public String getStrEndDate() {
		return strEndDate;
	}

	public void setStrEndDate(String strEndDate) {
		this.strEndDate = strEndDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsProjectAssignToAllEmployees() {
		return isProjectAssignToAllEmployees;
	}

	public void setIsProjectAssignToAllEmployees(Boolean isProjectAssignToAllEmployees) {
		this.isProjectAssignToAllEmployees = isProjectAssignToAllEmployees;
	}

	public Integer getClientsId() {
		return clientsId;
	}

	public void setClientsId(Integer clientsId) {
		this.clientsId = clientsId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

}
