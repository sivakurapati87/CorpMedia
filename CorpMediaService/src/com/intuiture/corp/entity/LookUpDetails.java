package com.intuiture.corp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "lookupdetails")
//@NamedQueries({ @NamedQuery(name = "LookUpDetails.lookupDetailsByType", query = "select l from LookUpDetails l where l.lookUpMaster.lookupType = ?1"),
//		@NamedQuery(name = "LookUpDetails.lookupDetailsByParent", query = "select l from LookUpDetails l where l.parent = ?1"),
//		@NamedQuery(name = "LookUpDetails.lookupDetailsByDetailIds", query = "select l from LookUpDetails l where l.lookupDetailId in ?1"),
//		@NamedQuery(name = "LookUpDetails.lookupDetailsByPrevDetailId", query = "select l from LookUpDetails l where l.lookUpMaster.lookupType = ?1 and l.lookupDetailId >= ?2"),
//		@NamedQuery(name = "LookUpDetails.decLookupDetailsByPrevDetailId", query = "select l from LookUpDetails l where l.lookUpMaster.lookupType = ?1 and l.lookupDetailId <= ?2"),
//		@NamedQuery(name = "LookUpDetails.lookupDetailsByTypeList", query = "select l from LookUpDetails l where l.lookUpMaster.lookupType in ?1") })
public class LookUpDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lookupDetailId;
	private String description;
	private Integer parent;
	private Integer lookupMasterId;
	@ManyToOne
	@JoinColumn(name = "lookupMasterId", insertable = false, updatable = false)
	private LookUpMaster lookUpMaster;

	public Integer getLookupMasterId() {
		return lookupMasterId;
	}

	public void setLookupMasterId(Integer lookupMasterId) {
		this.lookupMasterId = lookupMasterId;
	}

	public Integer getLookupDetailId() {
		return lookupDetailId;
	}

	public void setLookupDetailId(Integer lookupDetailId) {
		this.lookupDetailId = lookupDetailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LookUpMaster getLookUpMaster() {
		return lookUpMaster;
	}

	public void setLookUpMaster(LookUpMaster lookUpMaster) {
		this.lookUpMaster = lookUpMaster;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

}
