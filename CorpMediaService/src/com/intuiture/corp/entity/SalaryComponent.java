package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salarycomponent")
public class SalaryComponent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer salaryComponentId;
	private Boolean isDeleted;
	private Date createdOn;
	private Date updatedOn;
	private Integer companyId;
	private Double basic;
	private Double hra;
	private Double pf;
	private Integer medicalReimbursementId;
	private Integer transportAllowanceId;
	private Integer professionalAllowanceId;
	private Integer travelReimbursementId;
	private Integer foodCouponsId;
	private Integer cityCompensatoryAllowanceId;
	private Integer dailyAllowanceId;
	private Integer gratuityContributionId;
	@ManyToOne
	@JoinColumn(name = "medicalReimbursementId", insertable = false, updatable = false)
	private MedicalReimbursement medicalReimbursement;
	@ManyToOne
	@JoinColumn(name = "transportAllowanceId", insertable = false, updatable = false)
	private TransportAllowance transportAllowance;
	@ManyToOne
	@JoinColumn(name = "professionalAllowanceId", insertable = false, updatable = false)
	private ProfessionalAllowance professionalAllowance;
	@ManyToOne
	@JoinColumn(name = "travelReimbursementId", insertable = false, updatable = false)
	private TravelReimbursement travelReimbursement;
	@ManyToOne
	@JoinColumn(name = "foodCouponsId", insertable = false, updatable = false)
	private FoodCoupons foodCoupons;
	@ManyToOne
	@JoinColumn(name = "cityCompensatoryAllowanceId", insertable = false, updatable = false)
	private CityCompensatoryAllowance cityCompensatoryAllowance;
	@ManyToOne
	@JoinColumn(name = "dailyAllowanceId", insertable = false, updatable = false)
	private DailyAllowance dailyAllowance;

	@ManyToOne
	@JoinColumn(name = "gratuityContributionId", insertable = false, updatable = false)
	private GratuityContribution gratuityContribution;

	public Integer getSalaryComponentId() {
		return salaryComponentId;
	}

	public void setSalaryComponentId(Integer salaryComponentId) {
		this.salaryComponentId = salaryComponentId;
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

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public Double getHra() {
		return hra;
	}

	public void setHra(Double hra) {
		this.hra = hra;
	}

	public Double getPf() {
		return pf;
	}

	public void setPf(Double pf) {
		this.pf = pf;
	}

	public Integer getMedicalReimbursementId() {
		return medicalReimbursementId;
	}

	public void setMedicalReimbursementId(Integer medicalReimbursementId) {
		this.medicalReimbursementId = medicalReimbursementId;
	}

	public Integer getTransportAllowanceId() {
		return transportAllowanceId;
	}

	public void setTransportAllowanceId(Integer transportAllowanceId) {
		this.transportAllowanceId = transportAllowanceId;
	}

	public Integer getProfessionalAllowanceId() {
		return professionalAllowanceId;
	}

	public void setProfessionalAllowanceId(Integer professionalAllowanceId) {
		this.professionalAllowanceId = professionalAllowanceId;
	}

	public Integer getTravelReimbursementId() {
		return travelReimbursementId;
	}

	public void setTravelReimbursementId(Integer travelReimbursementId) {
		this.travelReimbursementId = travelReimbursementId;
	}

	public Integer getFoodCouponsId() {
		return foodCouponsId;
	}

	public void setFoodCouponsId(Integer foodCouponsId) {
		this.foodCouponsId = foodCouponsId;
	}

	public Integer getCityCompensatoryAllowanceId() {
		return cityCompensatoryAllowanceId;
	}

	public void setCityCompensatoryAllowanceId(Integer cityCompensatoryAllowanceId) {
		this.cityCompensatoryAllowanceId = cityCompensatoryAllowanceId;
	}

	public Integer getDailyAllowanceId() {
		return dailyAllowanceId;
	}

	public void setDailyAllowanceId(Integer dailyAllowanceId) {
		this.dailyAllowanceId = dailyAllowanceId;
	}

	public Integer getGratuityContributionId() {
		return gratuityContributionId;
	}

	public void setGratuityContributionId(Integer gratuityContributionId) {
		this.gratuityContributionId = gratuityContributionId;
	}

	public MedicalReimbursement getMedicalReimbursement() {
		return medicalReimbursement;
	}

	public void setMedicalReimbursement(MedicalReimbursement medicalReimbursement) {
		this.medicalReimbursement = medicalReimbursement;
	}

	public TransportAllowance getTransportAllowance() {
		return transportAllowance;
	}

	public void setTransportAllowance(TransportAllowance transportAllowance) {
		this.transportAllowance = transportAllowance;
	}

	public ProfessionalAllowance getProfessionalAllowance() {
		return professionalAllowance;
	}

	public void setProfessionalAllowance(ProfessionalAllowance professionalAllowance) {
		this.professionalAllowance = professionalAllowance;
	}

	public TravelReimbursement getTravelReimbursement() {
		return travelReimbursement;
	}

	public void setTravelReimbursement(TravelReimbursement travelReimbursement) {
		this.travelReimbursement = travelReimbursement;
	}

	public FoodCoupons getFoodCoupons() {
		return foodCoupons;
	}

	public void setFoodCoupons(FoodCoupons foodCoupons) {
		this.foodCoupons = foodCoupons;
	}

	public CityCompensatoryAllowance getCityCompensatoryAllowance() {
		return cityCompensatoryAllowance;
	}

	public void setCityCompensatoryAllowance(CityCompensatoryAllowance cityCompensatoryAllowance) {
		this.cityCompensatoryAllowance = cityCompensatoryAllowance;
	}

	public DailyAllowance getDailyAllowance() {
		return dailyAllowance;
	}

	public void setDailyAllowance(DailyAllowance dailyAllowance) {
		this.dailyAllowance = dailyAllowance;
	}

	public GratuityContribution getGratuityContribution() {
		return gratuityContribution;
	}

	public void setGratuityContribution(GratuityContribution gratuityContribution) {
		this.gratuityContribution = gratuityContribution;
	}

}
