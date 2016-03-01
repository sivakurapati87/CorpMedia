package com.intuiture.corp.json;

import java.util.Date;

public class ReportsJson {
	
    private Integer reportsId;
	private Integer companyId;
	private String strFromDate;
	private String strToDate;
	private Date fromDate;
	private Date toDate;
	
	
	public Integer getReportsId() {
		return reportsId;
	}
	public void setReportsId(Integer reportsId) {
		this.reportsId = reportsId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getStrFromDate() {
		return strFromDate;
	}
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	public String getStrToDate() {
		return strToDate;
	}
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	
	

}
