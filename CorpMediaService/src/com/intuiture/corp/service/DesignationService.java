package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.Designation;
import com.intuiture.corp.json.DesignationJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;




@Service
@Transactional
public class DesignationService {
	@Autowired
	private CommonRepository commonRepository;
	
	public Boolean saveDesignation(DesignationJson designationJson) {
		Designation designation = null;
		try {
			if (designationJson.getDesignationId() != null) {
				designation = (Designation) commonRepository.findById(designationJson.getDesignationId(),Designation.class);
			} else {
				designation = new Designation();
			}
			TransformJsonToDomain.getDesignation(designation, designationJson);
			if (designationJson.getDesignationId() != null) {
				commonRepository.update(designation);
			} else {
				commonRepository.persist(designation);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<DesignationJson> getAllDesignationsList(Integer companyId) {
		List<DesignationJson> designationJsonList = null;
		try {
			List<Designation> designationList = (List<Designation>) commonRepository.getAllRecordsByCompanyId(companyId, Designation.class);
			if (designationList != null && designationList.size() > 0) {
				designationJsonList= new ArrayList<DesignationJson>();
				for (Designation designation : designationList) {
					designationJsonList.add(TransformDomainToJson.getDesignationJson(designation));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return designationJsonList;
	}

	public Boolean deleteCompanyDesignation(Integer designationId) {
		try {
			Designation designation = (Designation) commonRepository.findById(designationId, Designation.class);
			if (designation != null) {
				designation.setIsDeleted(Boolean.TRUE);
				commonRepository.update(designation);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
