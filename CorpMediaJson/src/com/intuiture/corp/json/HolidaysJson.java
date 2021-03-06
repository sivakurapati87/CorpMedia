package com.intuiture.corp.json;

import java.util.Date;

public class HolidaysJson {
	private Integer holidaysId;
	private Date createdOn;
	private Date updatedOn;
	private Integer companyId;
	private String holidayName;
	private String description;
	private Date holidayDate;
	private String strHolidayDate;
	private Boolean isFloatingHoliday;
	private Boolean isDeleted;

	public Integer getHolidaysId() {
		return holidaysId;
	}

	public void setHolidaysId(Integer holidaysId) {
		this.holidaysId = holidaysId;
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

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	public Boolean getIsFloatingHoliday() {
		return isFloatingHoliday;
	}

	public void setIsFloatingHoliday(Boolean isFloatingHoliday) {
		this.isFloatingHoliday = isFloatingHoliday;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getStrHolidayDate() {
		return strHolidayDate;
	}

	public void setStrHolidayDate(String strHolidayDate) {
		this.strHolidayDate = strHolidayDate;
	}

}
