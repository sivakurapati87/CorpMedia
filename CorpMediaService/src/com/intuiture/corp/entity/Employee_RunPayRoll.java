package com.intuiture.corp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_runpayroll")
@IdClass(Employee_RunPayRollId.class)
public class Employee_RunPayRoll implements Serializable {
	private static final long serialVersionUID = -5500532619687497146L;
	@Id
	private Integer employeeId;
	@Id
	private Integer runPayRollId;
	private Double basic;
	private Double pf;
	private Double hra;
	private Double taxDeduction;
	private Double medicalAllowance;
	private Double professionalTax;
	private Double transportAllowance;
	private Double otherDeductions;
	private Double specialAllowance;
	private String grossEarnings;
	private String grossDeductions;
	private String netAmount;
	private Integer totalDays;
	private Integer paidDays;

	@ManyToOne
	@JoinColumn(name = "employeeId", updatable = false, insertable = false, referencedColumnName = "employeeId")
	private Employee employee;
	@ManyToOne
	@JoinColumn(name = "runPayRollId", updatable = false, insertable = false, referencedColumnName = "runPayRollId")
	private RunPayRoll runPayRoll;

	public Integer getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(Integer totalDays) {
		this.totalDays = totalDays;
	}

	public Integer getPaidDays() {
		return paidDays;
	}

	public void setPaidDays(Integer paidDays) {
		this.paidDays = paidDays;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getRunPayRollId() {
		return runPayRollId;
	}

	public void setRunPayRollId(Integer runPayRollId) {
		this.runPayRollId = runPayRollId;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public Double getPf() {
		return pf;
	}

	public void setPf(Double pf) {
		this.pf = pf;
	}

	public Double getHra() {
		return hra;
	}

	public void setHra(Double hra) {
		this.hra = hra;
	}

	public Double getTaxDeduction() {
		return taxDeduction;
	}

	public void setTaxDeduction(Double taxDeduction) {
		this.taxDeduction = taxDeduction;
	}

	public Double getMedicalAllowance() {
		return medicalAllowance;
	}

	public void setMedicalAllowance(Double medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}

	public Double getProfessionalTax() {
		return professionalTax;
	}

	public void setProfessionalTax(Double professionalTax) {
		this.professionalTax = professionalTax;
	}

	public Double getTransportAllowance() {
		return transportAllowance;
	}

	public void setTransportAllowance(Double transportAllowance) {
		this.transportAllowance = transportAllowance;
	}

	public Double getOtherDeductions() {
		return otherDeductions;
	}

	public void setOtherDeductions(Double otherDeductions) {
		this.otherDeductions = otherDeductions;
	}

	public Double getSpecialAllowance() {
		return specialAllowance;
	}

	public void setSpecialAllowance(Double specialAllowance) {
		this.specialAllowance = specialAllowance;
	}

	public String getGrossEarnings() {
		return grossEarnings;
	}

	public void setGrossEarnings(String grossEarnings) {
		this.grossEarnings = grossEarnings;
	}

	public String getGrossDeductions() {
		return grossDeductions;
	}

	public void setGrossDeductions(String grossDeductions) {
		this.grossDeductions = grossDeductions;
	}

	public String getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public RunPayRoll getRunPayRoll() {
		return runPayRoll;
	}

	public void setRunPayRoll(RunPayRoll runPayRoll) {
		this.runPayRoll = runPayRoll;
	}

}
