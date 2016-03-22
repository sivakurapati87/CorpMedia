package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.EmployeeTimeSheetRepository;
import com.intuiture.corp.entity.Employee_TimeSheet;
import com.intuiture.corp.entity.TimeSheet;
import com.intuiture.corp.json.EmployeeTimeSheetJson;
import com.intuiture.corp.util.EnumUtils;
import com.intuiture.corp.util.MethodUtil;
import com.intuiture.corp.util.TransformDomainToJson;

@Service
@Transactional
public class EmployeeTimeSheetService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private EmployeeTimeSheetRepository employeeTimeSheetRepository;

	public Boolean saveOrUpdateEmployeeTimesheetList(List<EmployeeTimeSheetJson> employeeTimeSheetJsonList) {
		try {
			if (employeeTimeSheetJsonList != null && employeeTimeSheetJsonList.size() > 0) {
				for (EmployeeTimeSheetJson json : employeeTimeSheetJsonList) {
					if (json.getEmployeeId() != null && json.getTimesheetId() != null) {
						// Getting the unique record
						Employee_TimeSheet employee_TimeSheet = employeeTimeSheetRepository.getEmployee_TimeSheetByEmpIdAndTimeSheetId(
								json.getEmployeeId(), json.getTimesheetId());
						employee_TimeSheet.setProjectId(json.getProjectId());
						if (employee_TimeSheet != null) {
							employee_TimeSheet.setSpendedTime(json.getSpendedTime());
						}
					}
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Boolean approveOrRejectEmpTimeSheet(List<EmployeeTimeSheetJson> employeeTimeSheetJsonList) {
		try {
			if (employeeTimeSheetJsonList != null && employeeTimeSheetJsonList.size() > 0) {
				List<Integer> timesheetIdsList = new ArrayList<Integer>();
				for (EmployeeTimeSheetJson json : employeeTimeSheetJsonList) {
					timesheetIdsList.add(json.getTimesheetId());
				}
				List<Employee_TimeSheet> employee_TimeSheetList = employeeTimeSheetRepository.getEmployee_TimeSheetByEmpIdAndTimeSheetIds(
						employeeTimeSheetJsonList.get(0).getEmployeeId(), timesheetIdsList);
				if (employee_TimeSheetList != null && employee_TimeSheetList.size() > 0) {
					for (Employee_TimeSheet employee_TimeSheet : employee_TimeSheetList) {
						employee_TimeSheet.setComment(employeeTimeSheetJsonList.get(0).getComment());
						if (employeeTimeSheetJsonList.get(0).getApproveOrReject().equalsIgnoreCase(EnumUtils.APPROVE.getState())) {
							employee_TimeSheet.setStatusId(EnumUtils.APPROVE.getValue());
						} else {
							employee_TimeSheet.setStatusId(EnumUtils.REJECT.getValue());
						}
						employee_TimeSheet.setApprovedOrRejectDate(MethodUtil.convertStringToDate(MethodUtil.convertDateToString(new Date())));
					}
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

				// This section is to find out the sum of the weekly spended
				// hours
				List<String> timestampsList = new ArrayList<String>();
				for (EmployeeTimeSheetJson json : employeeTimeSheetJsonList) {
					if (json.getSpendedTime() != null) {
						timestampsList.add(json.getSpendedTime());
					}
				}
				EmployeeTimeSheetJson employeeTimeSheetJson = new EmployeeTimeSheetJson();
				String[] s = new String[timestampsList.size()];
				employeeTimeSheetJson.setTotalTimeSpent(MethodUtil.sumTimes(timestampsList.toArray(s)));
				employeeTimeSheetJsonList.add(employeeTimeSheetJson);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeTimeSheetJsonList;
	}

	public Map<Integer, List<EmployeeTimeSheetJson>> getAllAppliedTimesheetList(Integer companyId) {
		Map<Integer, List<EmployeeTimeSheetJson>> empTimesheetMap = null;
		try {
			List<Employee_TimeSheet> employee_TimeSheetList = employeeTimeSheetRepository.getAllAppliedTimesheetList(companyId);
			if (employee_TimeSheetList != null && employee_TimeSheetList.size() > 0) {
				empTimesheetMap = new HashMap<Integer, List<EmployeeTimeSheetJson>>();
				for (Employee_TimeSheet employee_TimeSheet : employee_TimeSheetList) {
					EmployeeTimeSheetJson json = TransformDomainToJson.getEmployeeTimeSheetJson(employee_TimeSheet);
					if (empTimesheetMap.get(employee_TimeSheet.getEmployeeId()) != null) {
						empTimesheetMap.get(employee_TimeSheet.getEmployeeId()).add(json);
					} else {
						List<EmployeeTimeSheetJson> employeeTimeSheetJsonList = new ArrayList<EmployeeTimeSheetJson>();
						employeeTimeSheetJsonList.add(json);
						empTimesheetMap.put(json.getEmployeeId(), employeeTimeSheetJsonList);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empTimesheetMap;
	}
}
