package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CompanyLocationRepository;
import com.intuiture.corp.entity.AddLeaveType;
import com.intuiture.corp.entity.CompanyLeavePlans;
import com.intuiture.corp.json.AddLeaveTypeJson;
import com.intuiture.corp.json.CompanyLeavePlansJson;
import com.intuiture.corp.util.Constants;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class CompanyLeavePlanService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CompanyLocationRepository companyLocationRepository;

	public Boolean saveCompanyLeavePlans(CompanyLeavePlansJson companyLeavePlansJson) {
		CompanyLeavePlans companyLeavePlans = null;
		try {
			if (companyLeavePlansJson.getCompanyLeavePlansId() != null) {
				companyLeavePlans = (CompanyLeavePlans) commonRepository.findById(companyLeavePlansJson.getCompanyLeavePlansId(), CompanyLeavePlans.class);
			} else {
				companyLeavePlans = new CompanyLeavePlans();
			}
			TransformJsonToDomain.getCompanyLeavePlans(companyLeavePlans, companyLeavePlansJson);
			if (companyLeavePlansJson.getCompanyLeavePlansId() != null) {
				commonRepository.update(companyLeavePlans);
			} else {
				commonRepository.persist(companyLeavePlans);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<CompanyLeavePlansJson> getAllCompanyLeavePlansList(Integer companyId) {
		List<CompanyLeavePlansJson> companyLeavePlansJsonList = null;
		try {
			List<CompanyLeavePlans> companyLeavePlansList = (List<CompanyLeavePlans>) commonRepository.getAllRecordsByCompanyId(companyId, CompanyLeavePlans.class);
			if (companyLeavePlansList != null && companyLeavePlansList.size() > 0) {
				companyLeavePlansJsonList = new ArrayList<CompanyLeavePlansJson>();
				List<Integer> companyLeavePlanIds = new ArrayList<Integer>();
				for (CompanyLeavePlans companyLeavePlan : companyLeavePlansList) {
					companyLeavePlanIds.add(companyLeavePlan.getCompanyLeavePlansId());
				}
				List<AddLeaveType> addLeaveTypeList = (List<AddLeaveType>) commonRepository.getAllRecordsByList(Constants.companyLeavePlanId, companyLeavePlanIds, AddLeaveType.class);
				Map<Integer, List<AddLeaveTypeJson>> map = new HashMap<Integer, List<AddLeaveTypeJson>>();
				if (addLeaveTypeList != null && addLeaveTypeList.size() > 0) {
					for (AddLeaveType addLeaveType : addLeaveTypeList) {
						if (map.get(addLeaveType.getCompanyLeavePlanId()) != null) {
							map.get(addLeaveType.getCompanyLeavePlanId()).add(TransformDomainToJson.getAddLeaveTypeJson(addLeaveType));
						} else {
							List<AddLeaveTypeJson> list = new ArrayList<AddLeaveTypeJson>();
							list.add(TransformDomainToJson.getAddLeaveTypeJson(addLeaveType));
							map.put(addLeaveType.getCompanyLeavePlanId(), list);
						}
					}
				}
				for (CompanyLeavePlans companyLeavePlan : companyLeavePlansList) {
					CompanyLeavePlansJson json = TransformDomainToJson.getCompanyLeavePlansJson(companyLeavePlan);
					json.setLeaveTypeJsonList(map.get(json.getCompanyLeavePlansId()));
					companyLeavePlansJsonList.add(json);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyLeavePlansJsonList;
	}

	public Boolean deleteCompanyLeavePlans(Integer companyLeavePlanId) {
		try {
			CompanyLeavePlans companyLeavePlans = (CompanyLeavePlans) commonRepository.findById(companyLeavePlanId, CompanyLeavePlans.class);
			if (companyLeavePlans != null) {
				companyLeavePlans.setIsDeleted(Boolean.TRUE);
				commonRepository.update(companyLeavePlans);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
