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
import com.intuiture.corp.dao.EmployeeLeaveRepository;
import com.intuiture.corp.dao.EmployeeTimeSheetRepository;
import com.intuiture.corp.entity.Employee_Leave;
import com.intuiture.corp.entity.Employee_TimeSheet;
import com.intuiture.corp.entity.Leave;
import com.intuiture.corp.json.EmployeeLeaveJson;
import com.intuiture.corp.util.Constants;
import com.intuiture.corp.util.EnumUtils;
import com.intuiture.corp.util.MethodUtil;
import com.intuiture.corp.util.TransformDomainToJson;

@Service
@Transactional
public class EmployeeLeaveService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private EmployeeLeaveRepository employeeLeaveRepository;
	@Autowired
	private EmployeeTimeSheetRepository employeeTimeSheetRepository;
	@Autowired
	private EmployeeTimeSheetService employeeTimeSheetService;

	public Boolean saveOrUpdateEmployeeLeaves(EmployeeLeaveJson employeeLeaveJson, List<Date> weekDatesList) {
		try {
			if (employeeLeaveJson != null) {
				List<Employee_Leave> employee_LeaveList = employeeLeaveRepository.getEmployeeLeavesOfTheWeek(employeeLeaveJson.getEmployeeId(),
						weekDatesList);
				List<Employee_TimeSheet> employee_TimeSheetList = employeeTimeSheetService.getEmployeeTimesheetByweekListAndEmployeeId(
						employeeLeaveJson.getEmployeeId(), weekDatesList);
				// If employee leaves are empty
				if (employee_LeaveList == null || !(employee_LeaveList.size() > 0)) {
					List<Leave> leaveList = employeeLeaveRepository.getAllLeaves(null, employeeLeaveJson);
					if (leaveList == null || !(leaveList.size() > 0)) {
						leaveList = new ArrayList<Leave>();
						for (Date date : weekDatesList) {
							Leave leave = new Leave();
							leave.setIsDeleted(Boolean.FALSE);
							leave.setLeaveDate(date);
							commonRepository.persist(leave);
							leaveList.add(leave);
						}
					}
					employee_LeaveList = new ArrayList<Employee_Leave>();
					for (Leave leave : leaveList) {
						Employee_Leave employee_Leave = new Employee_Leave();
						employee_Leave.setEmployeeId(employeeLeaveJson.getEmployeeId());
						employee_Leave.setLeaveId(leave.getLeaveId());
						commonRepository.persist(employee_Leave);
						employee_LeaveList.add(employee_Leave);
					}
				}
				// employee_LeaveList =
				// employeeLeaveRepository.getEmployeeApplyLeave(employeeLeaveJson.getEmployeeId(),
				// employeeLeaveJson);
				MethodUtil.getAppliedLeaveDates(employeeLeaveJson, employee_LeaveList);
				if (employee_TimeSheetList != null && employee_TimeSheetList.size() > 0) {
					MethodUtil.getAppliedTimesheetDates(employeeLeaveJson, employee_TimeSheetList);
					for (Employee_TimeSheet timeSheet : employee_TimeSheetList) {
						timeSheet.setSpendedTime(null);
					}
				}
				if (employee_LeaveList != null && employee_LeaveList.size() > 0) {
					for (Employee_Leave employee_Leave : employee_LeaveList) {
						employee_Leave.setLeaveTypeId(employeeLeaveJson.getLeaveTypeId());
						employee_Leave.setNote(employeeLeaveJson.getNote());
						employee_Leave.setLeaveTime(Constants.LEAVETIME);
						employee_Leave.setProjectId(employeeLeaveJson.getProjectId());
						employee_Leave.setAppliedOn(MethodUtil.convertStringToDate(MethodUtil.convertDateToString(new Date())));
					}
				}

			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Boolean approveOrRejectAppliedLeaves(EmployeeLeaveJson employeeLeaveJson) {
		try {
			if (employeeLeaveJson != null) {
				List<Employee_Leave> employee_LeaveList = employeeLeaveRepository.getEmployee_LeaveByEmpIdAndLeaveIds(
						employeeLeaveJson.getEmployeeId(), MethodUtil.getListByString(employeeLeaveJson.getStrLeaveIds()));
				if (employee_LeaveList != null && employee_LeaveList.size() > 0) {
					for (Employee_Leave employee_Leave : employee_LeaveList) {
						if (employeeLeaveJson.getApproveOrReject().equalsIgnoreCase(EnumUtils.APPROVE.getState())) {
							employee_Leave.setStatusId(EnumUtils.APPROVE.getValue());
						} else {
							employee_Leave.setStatusId(EnumUtils.REJECT.getValue());
						}
						employee_Leave.setApprovedOrRejectedById(employeeLeaveJson.getApprovedOrRejectedById());
						employee_Leave.setComment(employeeLeaveJson.getComment());
					}
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public List<EmployeeLeaveJson> getEmployeeLeavesOfTheWeek(Integer employeeId, List<Date> weekDatesList) {
		List<EmployeeLeaveJson> employeeLeaveJsonList = null;
		try {
			List<Employee_Leave> employee_LeaveList = employeeLeaveRepository.getEmployeeLeavesOfTheWeek(employeeId, weekDatesList);
			// If employee leaves are empty
			if (employee_LeaveList == null || !(employee_LeaveList.size() > 0)) {
				List<Leave> leaveList = employeeLeaveRepository.getAllLeaves(weekDatesList, null);
				if (leaveList == null || !(leaveList.size() > 0)) {
					leaveList = new ArrayList<Leave>();
					for (Date date : weekDatesList) {
						Leave leave = new Leave();
						leave.setIsDeleted(Boolean.FALSE);
						leave.setLeaveDate(date);
						commonRepository.persist(leave);
						leaveList.add(leave);
					}
				}
				employee_LeaveList = new ArrayList<Employee_Leave>();
				for (Leave leave : leaveList) {
					Employee_Leave employee_Leave = new Employee_Leave();
					employee_Leave.setEmployeeId(employeeId);
					employee_Leave.setLeaveId(leave.getLeaveId());
					commonRepository.persist(employee_Leave);
					employee_LeaveList.add(employee_Leave);
				}
			}
			if (employee_LeaveList != null && employee_LeaveList.size() > 0) {
				employeeLeaveJsonList = new ArrayList<EmployeeLeaveJson>();
				for (Employee_Leave employee_Leave : employee_LeaveList) {
					employeeLeaveJsonList.add(TransformDomainToJson.getEmployeeLeaveJson(employee_Leave));
				}

				// This section is to find out the sum of the weekly spended
				// hours
				List<String> timestampsList = new ArrayList<String>();
				for (EmployeeLeaveJson json : employeeLeaveJsonList) {
					if (json.getLeaveTime() != null) {
						timestampsList.add(json.getLeaveTime());
					}
				}
				EmployeeLeaveJson employeeLeaveJson = new EmployeeLeaveJson();
				String[] s = new String[timestampsList.size()];
				employeeLeaveJson.setStrTotalLeaveTime(MethodUtil.sumTimes(timestampsList.toArray(s)));
				employeeLeaveJsonList.add(employeeLeaveJson);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeLeaveJsonList;
	}

	public List<EmployeeLeaveJson> getAllAppliedLeavesByCompany(Integer companyId) {
		List<EmployeeLeaveJson> employeeLeaveJsonList = null;
		try {
			List<Employee_Leave> employee_LeaveList = employeeLeaveRepository.getAllLeavesByCompany(companyId);
			if (employee_LeaveList != null && employee_LeaveList.size() > 0) {
				employeeLeaveJsonList = new ArrayList<EmployeeLeaveJson>();
				// Putting the list of leaves in a temporary list
				List<EmployeeLeaveJson> employeeLeaveJsonTempList = new ArrayList<EmployeeLeaveJson>();
				for (Employee_Leave emplLeave : employee_LeaveList) {
					employeeLeaveJsonTempList.add(TransformDomainToJson.getEmployeeLeaveJson(emplLeave));
				}
				// This map is to find out the list of leaves based on the
				// applied on date and leave type
				Map<String, EmployeeLeaveJson> appliedOn_Map = new HashMap<String, EmployeeLeaveJson>();
				for (EmployeeLeaveJson json : employeeLeaveJsonTempList) {
					String key = json.getEmployeeId() + "_" + json.getAppliedOn() + "_" + json.getLeaveType() + "_" + json.getNote();
					if (appliedOn_Map.get(key) != null) {
						// Concatenating the leaveIds
						String strLeaveIds = appliedOn_Map.get(key).getStrLeaveIds();
						strLeaveIds += "," + json.getLeaveId();
						// Concatenating the leaveDates
						String strLeaveDates = appliedOn_Map.get(key).getStrLeaveDates();
						strLeaveDates += "," + json.getStrLeaveDate();
						appliedOn_Map.get(key).setStrLeaveIds(strLeaveIds);
						appliedOn_Map.get(key).setStrLeaveDates(strLeaveDates);
					} else {
						appliedOn_Map.put(key, json);
					}
				}
				for (String key : appliedOn_Map.keySet()) {
					employeeLeaveJsonList.add(appliedOn_Map.get(key));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeLeaveJsonList;
	}
}
