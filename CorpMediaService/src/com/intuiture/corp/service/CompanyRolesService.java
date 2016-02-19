package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.CompanyRolesRepository;
import com.intuiture.corp.entity.CompanyRoles;
import com.intuiture.corp.json.CompanyRolesJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class CompanyRolesService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CompanyRolesRepository companyRolesRepository;

	public Boolean saveOrUpdateRole(CompanyRolesJson companyRolesJson) {
		CompanyRoles companyRoles = null;
		try {
			if (companyRolesJson.getRoleId() != null) {
				companyRoles = companyRolesRepository.findById(companyRolesJson.getRoleId());
			} else {
				companyRoles = new CompanyRoles();
			}
			TransformJsonToDomain.getCompanyRoles(companyRoles, companyRolesJson);
			if (companyRolesJson.getRoleId() != null) {
				commonRepository.update(companyRoles);
			} else {
				commonRepository.persist(companyRoles);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public List<CompanyRolesJson> getAllRoles(Integer companyId) {
		List<CompanyRolesJson> companyRolesJsonsList = null;
		try {
			List<CompanyRoles> companyRolesList = companyRolesRepository.getAllRoles(companyId);
			if (companyRolesList != null && companyRolesList.size() > 0) {
				companyRolesJsonsList = new ArrayList<CompanyRolesJson>();
				for (CompanyRoles companyRoles : companyRolesList) {
					companyRolesJsonsList.add(TransformDomainToJson.getCompanyRolesJson(companyRoles));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companyRolesJsonsList;
	}
}
