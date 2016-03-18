package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.AddLeaveTypeRepository;
import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.AddLeaveType;
import com.intuiture.corp.entity.CompanyLeaveType;
import com.intuiture.corp.json.CompanyLeaveTypeJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class CompanyLeaveTypeService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private AddLeaveTypeRepository addLeaveTypeRepository;

	public Boolean saveCompanyLeaveType(CompanyLeaveTypeJson companyLeaveTypeJson) {
		CompanyLeaveType companyLeaveType = null;
		try {
			if (companyLeaveTypeJson.getCompanyLeaveTypeId() != null) {
				companyLeaveType = (CompanyLeaveType) commonRepository.findById(companyLeaveTypeJson.getCompanyLeaveTypeId(), CompanyLeaveType.class);
			} else {
				companyLeaveType = new CompanyLeaveType();
			}
			TransformJsonToDomain.getCompanyLeaveType(companyLeaveType, companyLeaveTypeJson);
			if (companyLeaveTypeJson.getCompanyLeaveTypeId() != null) {
				commonRepository.update(companyLeaveType);
			} else {
				commonRepository.persist(companyLeaveType);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<CompanyLeaveTypeJson> getAllCompanyLeaveTypeList(Integer companyId) {
		List<CompanyLeaveTypeJson> companyLeaveTypeJsonList = null;
		try {
			List<CompanyLeaveType> companyLeaveTypeList = (List<CompanyLeaveType>) commonRepository.getAllRecordsByCompanyId(companyId,
					CompanyLeaveType.class);
			if (companyLeaveTypeList != null && companyLeaveTypeList.size() > 0) {
				companyLeaveTypeJsonList = new ArrayList<CompanyLeaveTypeJson>();
				for (CompanyLeaveType companyLeaveType : companyLeaveTypeList) {
					companyLeaveTypeJsonList.add(TransformDomainToJson.getCompanyLeaveTypeJson(companyLeaveType));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyLeaveTypeJsonList;
	}

	public List<CompanyLeaveTypeJson> getAllLeaveTypeListByCmpIdAndGenderId(Integer companyId, Integer genderId) {
		List<CompanyLeaveTypeJson> companyLeaveTypeJsonList = null;
		try {
			List<AddLeaveType> leaveTypeList = addLeaveTypeRepository.getAllLeaveTypeListByCmpIdAndGenderId(companyId, genderId);
			if (leaveTypeList != null && leaveTypeList.size() > 0) {
				companyLeaveTypeJsonList = new ArrayList<CompanyLeaveTypeJson>();
				for (AddLeaveType leaveType : leaveTypeList) {
					if (leaveType.getCompanyLeaveType() != null)
						companyLeaveTypeJsonList.add(TransformDomainToJson.getCompanyLeaveTypeJson(leaveType.getCompanyLeaveType()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyLeaveTypeJsonList;
	}

	public Boolean deleteCompanyLeaveType(Integer companyLeaveTypeId) {
		try {
			CompanyLeaveType companyLeaveType = (CompanyLeaveType) commonRepository.findById(companyLeaveTypeId, CompanyLeaveType.class);
			if (companyLeaveType != null) {
				companyLeaveType.setIsDeleted(Boolean.TRUE);
				commonRepository.update(companyLeaveType);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
