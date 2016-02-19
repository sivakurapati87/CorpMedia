package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.TimeSheetApproverRepository;
import com.intuiture.corp.entity.Employee;
import com.intuiture.corp.json.EmployeeJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private TimeSheetApproverRepository timeSheetApproverRepository;

	public Boolean saveOrUpdateEmployee(EmployeeJson employeeJson) {
		Employee employee = null;
		try {
			if (employeeJson != null) {
				if (employeeJson.getEmployeeId() != null) {
					employee = (Employee) commonRepository.findById(employeeJson.getEmployeeId(), Employee.class);
				} else {
					employee = new Employee();
				}
				TransformJsonToDomain.getEmployee(employee, employeeJson);
				if (employeeJson.getEmployeeId() != null) {
					commonRepository.update(employee);
				} else {
					commonRepository.persist(employee);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeJson> getAllEmployeesByCompanyId(Integer companyId) {
		List<EmployeeJson> employeeJsonList = null;
		try {
			List<Employee> employeesList = (List<Employee>) commonRepository.getAllRecordsByCompanyId(companyId, Employee.class);
			if (employeesList != null && employeesList.size() > 0) {
				employeeJsonList = new ArrayList<EmployeeJson>();
				for (Employee employee : employeesList) {
					employeeJsonList.add(TransformDomainToJson.getEmployeeJson(employee));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeJsonList;
	}
}
