package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CompanyRepository;
import com.intuiture.corp.dao.PFRepository;
import com.intuiture.corp.entity.CompanySignator;
import com.intuiture.corp.entity.PFInfo;
import com.intuiture.corp.json.CompanySignatorJson;
import com.intuiture.corp.json.PFInfoJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class PFService {
	private static Logger LOG = Logger.getLogger(PFService.class);
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private PFRepository pfRepository;

	public PFInfoJson getPFInfo_cmpId(Integer companyId) {
		PFInfoJson pfInfoJson = null;
		try {

			PFInfo pfInfo = pfRepository.getPFInfo_cmpId(companyId);

			List<CompanySignator> companySignators = companyRepository.getCompanySignatorsByCompanyId(new ArrayList<Integer>(Arrays.asList(companyId)));
			pfInfoJson = TransformDomainToJson.getpfInfoJson(pfInfo);
			if (companySignators != null && companySignators.size() > 0) {
				List<CompanySignatorJson> signatorJsonList = new ArrayList<CompanySignatorJson>();
				for (CompanySignator signator : companySignators) {
					if (pfInfoJson.getCompanySignatorId() != null && pfInfoJson.getCompanySignatorId().equals(signator.getCompanySignatorId())) {
						pfInfoJson.setSignator(TransformDomainToJson.getCompanySignatorJson(signator));
					}
					signatorJsonList.add(TransformDomainToJson.getCompanySignatorJson(signator));
				}
				pfInfoJson.setCompanySignatorJsonList(signatorJsonList);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("error at getPFInfo_cmpId in PFService:" + e.getMessage(), e);
		}
		return pfInfoJson;
	}

	public Boolean saveOrUpdatePFInfo(PFInfoJson pfInfoJson) {
		PFInfo pfInfo = null;
		try {
			if (pfInfoJson.getPfInfoId() != null) {
				pfInfo = pfRepository.findBy_PFId(pfInfoJson.getPfInfoId());
			} else {
				pfInfo = new PFInfo();
			}
			TransformJsonToDomain.getPFInfoByJson(pfInfoJson, pfInfo);
			if (pfInfoJson.getPfInfoId() != null) {
				commonRepository.update(pfInfo);
			} else {
				commonRepository.persist(pfInfo);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
