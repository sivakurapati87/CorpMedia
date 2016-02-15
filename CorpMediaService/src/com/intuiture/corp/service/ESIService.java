package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CompanyRepository;
import com.intuiture.corp.dao.ESIRepository;
import com.intuiture.corp.entity.CompanySignator;
import com.intuiture.corp.entity.ESIInfo;
import com.intuiture.corp.json.CompanySignatorJson;
import com.intuiture.corp.json.ESIInfoJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class ESIService {
	private static Logger LOG = Logger.getLogger(ESIService.class);
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private ESIRepository esiRepository;

	public ESIInfoJson getESIInfo_cmpId(Integer companyId) {
		ESIInfoJson esiInfoJson = null;
		try {
			ESIInfo esiInfo = esiRepository.getESIInfo_cmpId(companyId);

			List<CompanySignator> companySignators = companyRepository.getCompanySignatorsByCompanyId(new ArrayList<Integer>(companyId));
			esiInfoJson = TransformDomainToJson.getesiInfoJson(esiInfo);
			if (companySignators != null && companySignators.size() > 0) {
				List<CompanySignatorJson> signatorJsonList = new ArrayList<CompanySignatorJson>();
				for (CompanySignator signator : companySignators) {
					if (esiInfoJson.getCompanySignatorId() != null && esiInfoJson.getCompanySignatorId().equals(signator.getCompanySignatorId())) {
						esiInfoJson.setSignator(TransformDomainToJson.getCompanySignatorJson(signator));
					}
					signatorJsonList.add(TransformDomainToJson.getCompanySignatorJson(signator));
				}
				esiInfoJson.setCompanySignatorJsonList(signatorJsonList);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("error at getESIInfo_cmpId in ESIService:" + e.getMessage(), e);
		}
		return esiInfoJson;
	}

	public Boolean saveOrUpdateESIInfo(ESIInfoJson esiInfoJson) {
		ESIInfo esiInfo = null;
		try {
			if (esiInfoJson.getEsiInfoId() != null) {
				esiInfo = esiRepository.findBy_ESIId(esiInfoJson.getEsiInfoId());
			} else {
				esiInfo = new ESIInfo();
			}
			TransformJsonToDomain.getESIInfoByJson(esiInfoJson, esiInfo);
			if (esiInfoJson.getEsiInfoId() != null) {
				commonRepository.update(esiInfo);
			} else {
				commonRepository.persist(esiInfo);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
