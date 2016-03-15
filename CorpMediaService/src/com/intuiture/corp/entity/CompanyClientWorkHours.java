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
@Table(name = "companyclientworkhours")
public class CompanyClientWorkHours {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clientWorkHourId;
	private Integer companyId;
	private Date createOn;
	private Boolean isDeleted;
	private Integer clientId;
	private Date clientFrom;
	private Date clientTo;
	private Date updatedOn;
	@ManyToOne
	@JoinColumn(name = "clientId", insertable = false, updatable = false)
	private Clients clients;

	public Integer getClientWorkHourId() {
		return clientWorkHourId;
	}

	public void setClientWorkHourId(Integer clientWorkHourId) {
		this.clientWorkHourId = clientWorkHourId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Date getClientFrom() {
		return clientFrom;
	}

	public void setClientFrom(Date clientFrom) {
		this.clientFrom = clientFrom;
	}

	public Date getClientTo() {
		return clientTo;
	}

	public void setClientTo(Date clientTo) {
		this.clientTo = clientTo;
	}

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

}
