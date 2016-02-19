package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobtitles")
public class JobTitles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobtitlesId;
	private Date createdOn;
	private Date updatedOn;
	private Integer companyId;
	private String jobtitle;
	private String description;
	
	
	
	public Integer getJobtitlesId() {
		return jobtitlesId;
	}
	public void setJobtitlesId(Integer jobtitlesId) {
		this.jobtitlesId = jobtitlesId;
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
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
