package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.EmployeeTimeSheetRepository;
import com.intuiture.corp.entity.Employee;
import com.intuiture.corp.entity.Employee_TimeSheet;
import com.intuiture.corp.entity.TimeSheet;
import com.intuiture.corp.json.EmployeeJson;
import com.intuiture.corp.json.EmployeeTimeSheetJson;
import com.intuiture.corp.util.TransformDomainToJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class EmployeeTimeSheetService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private EmployeeTimeSheetRepository employeeTimeSheetRepository;

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

	public List<EmployeeTimeSheetJson> getEmployeeTimesheetOfTheWeek(Integer employeeId, List<Date> weekDatesList) {
		List<EmployeeTimeSheetJson> employeeTimeSheetJsonList = null;
		try {
			List<Employee_TimeSheet> employee_TimeSheetList = employeeTimeSheetRepository.getEmployeeTimesheetOfTheWeek(employeeId, weekDatesList);

			if (employee_TimeSheetList == null || !(employee_TimeSheetList.size() > 0)) {
				List<TimeSheet> timeSheetList = employeeTimeSheetRepository.getAllTimeSheets(weekDatesList);
				if (timeSheetList == null || !(timeSheetList.size() > 0)) {
					timeSheetList = new ArrayList<TimeSheet>();
					for (Date date : weekDatesList) {
						TimeSheet timeSheet = new TimeSheet();
						timeSheet.setIsDeleted(Boolean.FALSE);
						timeSheet.setTimeSheetDate(date);
						commonRepository.persist(timeSheet);
						timeSheetList.add(timeSheet);
					}
				}
				employee_TimeSheetList = new ArrayList<Employee_TimeSheet>();
				for (TimeSheet timeSheet : timeSheetList) {
					Employee_TimeSheet employee_TimeSheet = new Employee_TimeSheet();
					employee_TimeSheet.setEmployeeId(employeeId);
					employee_TimeSheet.setTimesheetId(timeSheet.getTimesheetId());
					commonRepository.persist(employee_TimeSheet);
					employee_TimeSheetList.add(employee_TimeSheet);
				}
			}
			if (employee_TimeSheetList != null && employee_TimeSheetList.size() > 0) {
				employeeTimeSheetJsonList = new ArrayList<EmployeeTimeSheetJson>();
				for (Employee_TimeSheet employee_TimeSheet : employee_TimeSheetList) {
					employeeTimeSheetJsonList.add(TransformDomainToJson.getEmployeeTimeSheetJson(employee_TimeSheet));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeTimeSheetJsonList;
	}
}