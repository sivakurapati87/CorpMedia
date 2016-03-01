package com.intuiture.corp.json;


public class ShiftsJson {

	private Integer shiftsId;
	private String shiftName;
	private Integer startTimeHrs;
	private Integer startTimeMns;
	private String startTimeType;
	private Integer toTimeHrs;
	private Integer toTimeMns;
	private String toTimeType;
	private Integer breakDuratation;
	private Integer companyId;
	private Boolean isDeleted;

	public Integer getShiftsId() {
		return shiftsId;
	}

	public void setShiftsId(Integer shiftsId) {
		this.shiftsId = shiftsId;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public Integer getStartTimeHrs() {
		return startTimeHrs;
	}

	public void setStartTimeHrs(Integer startTimeHrs) {
		this.startTimeHrs = startTimeHrs;
	}

	public Integer getStartTimeMns() {
		return startTimeMns;
	}

	public void setStartTimeMns(Integer startTimeMns) {
		this.startTimeMns = startTimeMns;
	}

	public String getStartTimeType() {
		return startTimeType;
	}

	public void setStartTimeType(String startTimeType) {
		this.startTimeType = startTimeType;
	}

	public Integer getToTimeHrs() {
		return toTimeHrs;
	}

	public void setToTimeHrs(Integer toTimeHrs) {
		this.toTimeHrs = toTimeHrs;
	}

	public Integer getToTimeMns() {
		return toTimeMns;
	}

	public void setToTimeMns(Integer toTimeMns) {
		this.toTimeMns = toTimeMns;
	}

	public String getToTimeType() {
		return toTimeType;
	}

	public void setToTimeType(String toTimeType) {
		this.toTimeType = toTimeType;
	}

	public Integer getBreakDuratation() {
		return breakDuratation;
	}

	public void setBreakDuratation(Integer breakDuratation) {
		this.breakDuratation = breakDuratation;
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
