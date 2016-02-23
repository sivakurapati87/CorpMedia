package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bonuses")
public class Bonuses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bonusesId;
	private String bonusesName;
	private String bonusesDescription;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private Integer companyId;
	
	
	public Integer getBonusesId() {
		return bonusesId;
	}
	public void setBonusesId(Integer bonusesId) {
		this.bonusesId = bonusesId;
	}
	public String getBonusesName() {
		return bonusesName;
	}
	public void setBonusesName(String bonusesName) {
		this.bonusesName = bonusesName;
	}
	public String getBonusesDescription() {
		return bonusesDescription;
	}
	public void setBonusesDescription(String bonusesDescription) {
		this.bonusesDescription = bonusesDescription;
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
