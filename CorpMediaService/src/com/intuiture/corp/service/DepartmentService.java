package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.DepartmentRepository;
import com.intuiture.corp.entity.Department;
import com.intuiture.corp.json.DepartmentJson;
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
				department = departmentRepository.findbyId(departmentJson.getDepartmentId());
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
}
