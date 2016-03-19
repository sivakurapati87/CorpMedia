package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.EmployeeLeaveRepository;
import com.intuiture.corp.entity.Employee_Leave;
import com.intuiture.corp.entity.Leave;
import com.intuiture.corp.json.EmployeeLeaveJson;
import com.intuiture.corp.util.Constants;
import com.intuiture.corp.util.MethodUtil;
import com.intuiture.corp.util.TransformDomainToJson;

@Service
@Transactional
public class EmployeeLeaveService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private EmployeeLeaveRepository employeeLeaveRepository;

	public Boolean saveOrUpdateEmployeeLeaves(EmployeeLeaveJson employeeLeaveJson, List<Date> weekDatesList) {
		try {
			if (employeeLeaveJson != null) {
				List<Employee_Leave> employee_LeaveList = employeeLeaveRepository.getEmployeeLeavesOfTheWeek(employeeLeaveJson.getEmployeeId(), null,
						employeeLeaveJson);
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
				if (employee_LeaveList != null && employee_LeaveList.size() > 0) {
					for (Employee_Leave employee_Leave : employee_LeaveList) {
						employee_Leave.setLeaveTypeId(employeeLeaveJson.getLeaveTypeId());
						employee_Leave.setNote(employeeLeaveJson.getNote());
						employee_Leave.setLeaveTime(Constants.LEAVETIME);
						employee_Leave.setProjectId(employeeLeaveJson.getProjectId());
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
			List<Employee_Leave> employee_LeaveList = employeeLeaveRepository.getEmployeeLeavesOfTheWeek(employeeId, weekDatesList, null);
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
}
