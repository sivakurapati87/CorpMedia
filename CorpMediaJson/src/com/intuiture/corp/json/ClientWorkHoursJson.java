package com.intuiture.corp.json;

import java.util.Date;

public class ClientWorkHoursJson {

	private Integer clientWorkHourId;
	private Integer companyId;
	private Date createOn;
	private Boolean isDeleted;
	private Integer clientsId;
	private Date from;
	private Date to;
	private String strFrom;
	private String strTo;


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

	public Integer getClientsId() {
		return clientsId;
	}

	public void setClientsId(Integer clientId) {
		this.clientsId = clientId;
	}

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

	public Integer getClientWorkHourId() {
		return clientWorkHourId;
	}

	public void setClientWorkHourId(Integer clientWorkHourId) {
		this.clientWorkHourId = clientWorkHourId;
	}

}
