package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "generalsettings")
public class GeneralSettings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer generalsettingsId;
	private Integer hoursPerWeek;
	private Integer hoursPerMonth;
	private Integer companyId;
	private Date createdOn;

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

	public Integer getGeneralsettingsId() {
		return generalsettingsId;
	}

	public void setGeneralsettingsId(Integer generalsettingsId) {
		this.generalsettingsId = generalsettingsId;
	}

	public Integer getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(Integer hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public Integer getHoursPerMonth() {
		return hoursPerMonth;
	}

	public void setHoursPerMonth(Integer hoursPerMonth) {
		this.hoursPerMonth = hoursPerMonth;
	}

}
