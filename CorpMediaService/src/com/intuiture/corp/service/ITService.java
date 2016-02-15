package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CompanyRepository;
import com.intuiture.corp.dao.ITRepository;
import com.intuiture.corp.entity.CompanySignator;
import com.intuiture.corp.entity.ITInfo;
import com.intuiture.corp.json.CompanySignatorJson;
import com.intuiture.corp.json.ITInfoJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class ITService {

	private static Logger LOG = Logger.getLogger(ITService.class);
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private ITRepository itRepository;

	public ITInfoJson getITInfo_cmpId(Integer companyId) {
		ITInfoJson itInfoJson = null;
		try {
			ITInfo itInfo = itRepository.getITInfo_cmpId(companyId);

			List<CompanySignator> companySignators = companyRepository.getCompanySignatorsByCompanyId(new ArrayList<Integer>(companyId));
			itInfoJson = TransformDomainToJson.getitInfoJson(itInfo);
			if (companySignators != null && companySignators.size() > 0) {
				List<CompanySignatorJson> signatorJsonList = new ArrayList<CompanySignatorJson>();
				for (CompanySignator signator : companySignators) {
					if (itInfoJson.getCompanySignatorId() != null && itInfoJson.getCompanySignatorId().equals(signator.getCompanySignatorId())) {
						itInfoJson.setSignator(TransformDomainToJson.getCompanySignatorJson(signator));
					}
					signatorJsonList.add(TransformDomainToJson.getCompanySignatorJson(signator));
				}
				itInfoJson.setCompanySignatorJsonList(signatorJsonList);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("error at getITInfo_cmpId in PFService:" + e.getMessage(), e);
		}
		return itInfoJson;
	}

	public Boolean saveOrUpdateITInfo(ITInfoJson itInfoJson) {
		ITInfo itInfo = null;
		try {
			if (itInfoJson.getItInfoId() != null) {
				itInfo = itRepository.findBy_ITId(itInfoJson.getItInfoId());
			} else {
				itInfo = new ITInfo();
			}
			TransformJsonToDomain.getITInfoByJson(itInfoJson, itInfo);
			if (itInfoJson.getItInfoId() != null) {
				commonRepository.update(itInfo);
			} else {
				commonRepository.persist(itInfo);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
