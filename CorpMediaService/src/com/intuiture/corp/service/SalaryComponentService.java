package com.intuiture.corp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.CityCompensatoryAllowance;
import com.intuiture.corp.entity.DailyAllowance;
import com.intuiture.corp.entity.FoodCoupons;
import com.intuiture.corp.entity.GratuityContribution;
import com.intuiture.corp.entity.MedicalReimbursement;
import com.intuiture.corp.entity.ProfessionalAllowance;
import com.intuiture.corp.entity.SalaryComponent;
import com.intuiture.corp.entity.TransportAllowance;
import com.intuiture.corp.entity.TravelReimbursement;
import com.intuiture.corp.json.SalaryComponentJson;
import com.intuiture.corp.util.Constants;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class SalaryComponentService {

	@Autowired
	private CommonRepository commonRepository;

	public Boolean modifySalaryComponent(SalaryComponentJson salaryComponentJson) {
		SalaryComponent salaryComponent = null;

		try {
			if (salaryComponentJson.getSalaryComponentId() != null) {
				salaryComponent = (SalaryComponent) commonRepository.findById(salaryComponentJson.getSalaryComponentId(), SalaryComponent.class);
			} else {
				salaryComponent = new SalaryComponent();
			}
			TransformJsonToDomain.getSalaryComponent(salaryComponent, salaryComponentJson);
			if (salaryComponentJson.getSalaryComponentId() != null) {
				commonRepository.update(salaryComponent);
			} else {
				commonRepository.persist(salaryComponent);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public SalaryComponentJson getSalaryComponentJson(Integer companyId) {
		SalaryComponentJson salaryComponentJson = null;
		try {
			SalaryComponent salaryComponent = (SalaryComponent) commonRepository.getRecordByCompanyId(companyId, SalaryComponent.class);

			if (salaryComponent == null) {
				salaryComponent = new SalaryComponent();
				MedicalReimbursement medicalReimbursement = (MedicalReimbursement) commonRepository.getRecordByCompanyId(companyId, MedicalReimbursement.class);
				TransportAllowance transportAllowance = (TransportAllowance) commonRepository.getRecordByCompanyId(companyId, TransportAllowance.class);
				ProfessionalAllowance professionalAllowance = (ProfessionalAllowance) commonRepository.getRecordByCompanyId(companyId, ProfessionalAllowance.class);
				TravelReimbursement travelReimbursement = (TravelReimbursement) commonRepository.getRecordByCompanyId(companyId, TravelReimbursement.class);
				FoodCoupons foodCoupons = (FoodCoupons) commonRepository.getRecordByCompanyId(companyId, FoodCoupons.class);
				CityCompensatoryAllowance cityCompensatoryAllowance = (CityCompensatoryAllowance) commonRepository.getRecordByCompanyId(companyId, CityCompensatoryAllowance.class);
				DailyAllowance dailyAllowance = (DailyAllowance) commonRepository.getRecordByCompanyId(companyId, DailyAllowance.class);
				GratuityContribution gratuityContribution = (GratuityContribution) commonRepository.getRecordByCompanyId(companyId, GratuityContribution.class);
				salaryComponent.setMedicalReimbursementId(medicalReimbursement.getMedicalReimbursementId());
				salaryComponent.setTransportAllowanceId(transportAllowance.getTransportAllowanceId());
				salaryComponent.setProfessionalAllowanceId(professionalAllowance.getProfessionalAllowanceId());
				salaryComponent.setTravelReimbursementId(travelReimbursement.getTravelReimbursementId());
				salaryComponent.setFoodCouponsId(foodCoupons.getFoodCouponsId());
				salaryComponent.setCityCompensatoryAllowanceId(cityCompensatoryAllowance.getCityCompensatoryAllowanceId());
				salaryComponent.setDailyAllowanceId(dailyAllowance.getDailyAllowanceId());
				salaryComponent.setGratuityContributionId(gratuityContribution.getGratuityContributionId());
				salaryComponent.setBasic(Constants.BASIC);
				salaryComponent.setHra(Constants.HRA);
				salaryComponent.setPf(Constants.PF);
				salaryComponent.setCompanyId(companyId);
				salaryComponent.setIsDeleted(Boolean.FALSE);
				salaryComponent.setCreatedOn(new Date());
				commonRepository.persist(salaryComponent);
				salaryComponent = (SalaryComponent) commonRepository.getRecordByCompanyId(companyId, SalaryComponent.class);
			}
			salaryComponentJson = TransformDomainToJson.getSalaryComponentJson(salaryComponent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salaryComponentJson;
	}
}
