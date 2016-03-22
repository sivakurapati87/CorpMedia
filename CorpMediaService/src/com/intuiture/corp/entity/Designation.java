package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "designation")
public class Designation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer designationId;
	private String designationName;
	
	private Date createdOn;
	private Integer companyId;
	private Boolean isDeleted;
	
	public Integer getDesignationId() {
		return designationId;
	}
	
	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}
	
	public String getDesignationName() {
		return designationName;
	}
	
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
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
	
	

}
