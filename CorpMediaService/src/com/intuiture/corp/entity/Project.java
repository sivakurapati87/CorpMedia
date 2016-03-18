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
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	private Integer companyId;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private String projectName;
	private Integer clientsId;
	private Integer statusId;
	private Date startDate;
	private Date endDate;
	private String description;
	private Boolean isProjectAssignToAllEmployees;
	@ManyToOne
	@JoinColumn(name = "clientsId", insertable = false, updatable = false)
	private Clients clients;
	@ManyToOne
	@JoinColumn(name = "statusId", insertable = false, updatable = false)
	private LookUpDetails status;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
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

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public LookUpDetails getStatus() {
		return status;
	}

	public void setStatus(LookUpDetails status) {
		this.status = status;
	}

}
