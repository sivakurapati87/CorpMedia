package com.intuiture.corp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "companyinfo")
public class CompanyInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyInfoId;
	private Integer companyId;
	private String companyLogo;
	private String hoPhoto;
	private String registrationNumber;
	private Boolean isRegisteredWithRoc;
	private Boolean isPSU;
	// private Integer companyTypeId;
	private Date d_o_incorporation;
	private String address1;
	private String address2;
	private String area;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private String email;
	private String mobile;
	private String phone;
	private Boolean isListed;
	private String industry;
	private String boardNumber;
	private String faxNumber;
	// private String email1;
	private String website;
	private String twitterLink;
	private String facebookLink;
	private String naukri;
	private String panNumber;
	private String companyType;
	private Date dateOfLastAGM;
	private Date dateOfBalanceSheet;
	@OneToOne
	@JoinColumn(name = "companyId", insertable = false, updatable = false)
	private Company company;

	// @ManyToOne
	// @JoinColumn(name = "companyTypeId", insertable = false, updatable =
	// false)
	// private LookUpDetails companyType;

	public Integer getCompanyInfoId() {
		return companyInfoId;
	}

	public void setCompanyInfoId(Integer companyInfoId) {
		this.companyInfoId = companyInfoId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getHoPhoto() {
		return hoPhoto;
	}

	public void setHoPhoto(String hoPhoto) {
		this.hoPhoto = hoPhoto;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Boolean getIsRegisteredWithRoc() {
		return isRegisteredWithRoc;
	}

	public void setIsRegisteredWithRoc(Boolean isRegisteredWithRoc) {
		this.isRegisteredWithRoc = isRegisteredWithRoc;
	}

	public Boolean getIsPSU() {
		return isPSU;
	}

	public void setIsPSU(Boolean isPSU) {
		this.isPSU = isPSU;
	}

	public Date getD_o_incorporation() {
		return d_o_incorporation;
	}

	public void setD_o_incorporation(Date d_o_incorporation) {
		this.d_o_incorporation = d_o_incorporation;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getIsListed() {
		return isListed;
	}

	public void setIsListed(Boolean isListed) {
		this.isListed = isListed;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(String boardNumber) {
		this.boardNumber = boardNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getTwitterLink() {
		return twitterLink;
	}

	public void setTwitterLink(String twitterLink) {
		this.twitterLink = twitterLink;
	}

	public String getFacebookLink() {
		return facebookLink;
	}

	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}

	public String getNaukri() {
		return naukri;
	}

	public void setNaukri(String naukri) {
		this.naukri = naukri;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getDateOfLastAGM() {
		return dateOfLastAGM;
	}

	public void setDateOfLastAGM(Date dateOfLastAGM) {
		this.dateOfLastAGM = dateOfLastAGM;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateOfBalanceSheet() {
		return dateOfBalanceSheet;
	}

	public void setDateOfBalanceSheet(Date dateOfBalanceSheet) {
		this.dateOfBalanceSheet = dateOfBalanceSheet;
	}

}
