package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.GratuityContributionRepository;
import com.intuiture.corp.entity.CityCompensatoryAllowance;
import com.intuiture.corp.entity.GratuityContribution;
import com.intuiture.corp.json.CityCompensatoryAllowanceJson;
import com.intuiture.corp.json.GratuityContributionJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class GratuityContributionService {

	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private GratuityContributionRepository gratuityContributionRepository;

	public Boolean saveGratuityContribution(GratuityContributionJson gratuityContributionJson) {
		GratuityContribution gratuityContribution = null;

		try {
			if (gratuityContributionJson.getGratuityContributionId() != null) {
				gratuityContribution = (GratuityContribution) commonRepository.findById(gratuityContributionJson.getGratuityContributionId(), GratuityContribution.class);
			} else {
				gratuityContribution = new GratuityContribution();
			}
			TransformJsonToDomain.getGratuityContribution(gratuityContribution, gratuityContributionJson);
			if (gratuityContributionJson.getGratuityContributionId() != null) {
				commonRepository.update(gratuityContribution);
			} else {
				commonRepository.persist(gratuityContribution);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public GratuityContributionJson getGratuityContributionJson(Integer companyId) {
		GratuityContributionJson gratuityContributionJson = null;
		try {
			GratuityContribution gratuityContribution = (GratuityContribution) commonRepository.getRecordByCompanyId(companyId, GratuityContribution.class);
			if (gratuityContribution != null) {
				gratuityContributionJson = TransformDomainToJson.getGratuityContributionJson(gratuityContribution);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gratuityContributionJson;
	}
}
