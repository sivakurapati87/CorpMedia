package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.DepartmentRepository;
import com.intuiture.corp.entity.Department;
import com.intuiture.corp.json.DepartmentJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class DepartmentService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	public Boolean saveDepartment(DepartmentJson departmentJson) {
		Department department = null;
		try {
			if (departmentJson.getDepartmentId() != null) {
				department = (Department) commonRepository.findById(departmentJson.getDepartmentId(), Department.class);
			} else {
				department = new Department();
			}
			TransformJsonToDomain.getDepartment(department, departmentJson);
			if (departmentJson.getDepartmentId() != null) {
				commonRepository.update(department);
			} else {
				commonRepository.persist(department);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<DepartmentJson> getAllDepartmentsList(Integer companyId) {
		List<DepartmentJson> departmentJsonList = null;
		try {
			List<Department> companyLocationsList = (List<Department>) commonRepository.getAllRecordsByCompanyId(companyId, Department.class);
			if (companyLocationsList != null && companyLocationsList.size() > 0) {
				departmentJsonList = new ArrayList<DepartmentJson>();
				for (Department department : companyLocationsList) {
					departmentJsonList.add(TransformDomainToJson.getDepartmentJson(department));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departmentJsonList;
	}

	public Boolean deleteCompanyDepartment(Integer companyLocationId) {
		try {
			Department department = (Department) commonRepository.findById(companyLocationId, Department.class);
			if (department != null) {
				department.setIsDeleted(Boolean.TRUE);
				commonRepository.update(department);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
