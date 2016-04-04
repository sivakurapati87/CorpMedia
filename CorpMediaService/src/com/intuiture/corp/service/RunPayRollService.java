package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.dao.EmployeeLeaveRepository;
import com.intuiture.corp.dao.EmployeeTimeSheetRepository;
import com.intuiture.corp.entity.EmployeeSalaryInfo;
import com.intuiture.corp.entity.Employee_Leave;
import com.intuiture.corp.entity.Employee_TimeSheet;
import com.intuiture.corp.entity.SalaryComponent;
import com.intuiture.corp.json.EmployeeSalaryInfoJson;
import com.intuiture.corp.json.PayrollCycleSettingsJson;
import com.intuiture.corp.json.SalaryComponentJson;
import com.intuiture.corp.util.Constants;
import com.intuiture.corp.util.ConvertNumberToWord;
import com.intuiture.corp.util.EnumUtils;
import com.intuiture.corp.util.MethodUtil;
import com.intuiture.corp.util.TransformDomainToJson;

@Service
@Transactional
public class RunPayRollService {

	private static Logger LOG = Logger.getLogger(RunPayRollService.class);
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private EmployeeTimeSheetRepository employeeTimeSheetRepository;
	@Autowired
	private EmployeeLeaveRepository employeeLeaveRepository;

	@SuppressWarnings("unchecked")
	public List<EmployeeSalaryInfoJson> viewEmployeesPayRollByCompanyId(PayrollCycleSettingsJson payrollCycleSettingsJson) {
		List<EmployeeSalaryInfoJson> employeeSalaryInfoJsonList = null;
		try {
			List<EmployeeSalaryInfo> employeeSalaryInfoList = (List<EmployeeSalaryInfo>) commonRepository.getAllRecordsByCompanyId(
					payrollCycleSettingsJson.getCompanyId(), EmployeeSalaryInfo.class);
			SalaryComponent salaryComponent = (SalaryComponent) commonRepository.getRecordByCompanyId(payrollCycleSettingsJson.getCompanyId(),
					SalaryComponent.class);
			if (employeeSalaryInfoList != null && employeeSalaryInfoList.size() > 0) {
				List<Integer> employeeIds = new ArrayList<Integer>();
				for (EmployeeSalaryInfo employeeSalaryInfo : employeeSalaryInfoList) {
					employeeIds.add(employeeSalaryInfo.getEmployeeId());
				}
				Date startDate = MethodUtil.convertStringToDate(payrollCycleSettingsJson.getStrPayCycleStartDate());
				Date endDate = MethodUtil.convertStringToDate(payrollCycleSettingsJson.getStrPayCycleEndDate());
				// Getting employees time sheet and leaves
				Map<Integer, List<Employee_TimeSheet>> employee_TimeSheetMap = getAllTimeSheetsByEmployeeIdsAndTimeDuration(employeeIds, startDate,
						endDate);
				Map<Integer, List<Employee_Leave>> employee_LeaveMap = getAllLeavesByEmployeeIdsAndTimeDuration(employeeIds, startDate, endDate);

				employeeSalaryInfoJsonList = new ArrayList<EmployeeSalaryInfoJson>();
				for (EmployeeSalaryInfo employeeSalaryInfo : employeeSalaryInfoList) {

					EmployeeSalaryInfoJson employeeSalaryInfoJson = TransformDomainToJson.getEmployeeSalaryInfoJson(employeeSalaryInfo);

					SalaryComponentJson salaryComponentJson = TransformDomainToJson.getSalaryComponentJson(salaryComponent);

					salaryComponentJson.setProfessionalAllowance(MethodUtil.getMonthlyAmount(salaryComponentJson.getProfessionalAllowance()));
					salaryComponentJson.setMedicalReimbursement(MethodUtil.getMonthlyAmount(salaryComponentJson.getMedicalReimbursement()));
					salaryComponentJson.setTransportAllowance(MethodUtil.getMonthlyAmount(salaryComponentJson.getTransportAllowance()));

					if (salaryComponent.getBasic() != null) {
						salaryComponentJson.setBasic(MethodUtil.getMonthlyAmount(
								MethodUtil.convertDoubleToLong(salaryComponent.getBasic() * employeeSalaryInfoJson.getAnnualSalary())).doubleValue());
						if (salaryComponent.getHra() != null) {
							salaryComponentJson.setHra(salaryComponent.getHra() * salaryComponentJson.getBasic());
						}
					}
					if (salaryComponent.getPf() != null) {
						salaryComponentJson.setPf(MethodUtil.getMonthlyAmount(
								MethodUtil.convertDoubleToLong(salaryComponent.getPf() * employeeSalaryInfoJson.getAnnualSalary())).doubleValue());
					}

					Long totalEarningsWithOutSpecialAll = MethodUtil.convertDoubleToLong(salaryComponentJson.getBasic()
							+ salaryComponentJson.getHra() + salaryComponentJson.getMedicalReimbursement()
							+ salaryComponentJson.getTransportAllowance());

					Long totalDeductions = MethodUtil.convertDoubleToLong(salaryComponentJson.getPf()
							+ salaryComponentJson.getProfessionalAllowance());

					Long specialAllowance = MethodUtil.getMonthlyAmount(employeeSalaryInfoJson.getAnnualSalary())
							- (totalEarningsWithOutSpecialAll + totalDeductions);

					salaryComponentJson.setSpecialAllowance(specialAllowance);

					Long totalEarnings = totalEarningsWithOutSpecialAll + specialAllowance;
					salaryComponentJson.setGrossEarningInMoney(MethodUtil.convertLongToMoney(totalEarnings));
					salaryComponentJson.setGrossDeductionsInMoney(MethodUtil.convertLongToMoney(totalDeductions));
					salaryComponentJson.setNetAmountInMoney(MethodUtil.convertLongToMoney(totalEarnings - totalDeductions));
					salaryComponentJson.setNetPayInWords(ConvertNumberToWord.convertNumberToWords(totalEarnings - totalDeductions));
					employeeSalaryInfoJson.setSalaryComponentJson(salaryComponentJson);

					if (employee_TimeSheetMap != null && employee_TimeSheetMap.get(employeeSalaryInfo.getEmployeeId()) != null) {
						salaryComponentJson.setNoOfTimeSheet(employee_TimeSheetMap.get(employeeSalaryInfo.getEmployeeId()).size());
					} else {
						salaryComponentJson.setNoOfTimeSheet(0);
					}
					if (employee_LeaveMap != null && employee_LeaveMap.get(employeeSalaryInfo.getEmployeeId()) != null) {
						salaryComponentJson.setLeavesApplied(employee_LeaveMap.get(employeeSalaryInfo.getEmployeeId()).size());
						Map<String, Integer> pendingAndRejectedLeavesMap = findNoOfPendingLeaves(employee_LeaveMap.get(employeeSalaryInfo
								.getEmployeeId()));
						salaryComponentJson.setPendingLeaveToGrant(pendingAndRejectedLeavesMap.get(Constants.PENDING));
						salaryComponentJson.setNoOfRejectedLeaves(pendingAndRejectedLeavesMap.get(Constants.REJECTED));

					} else {
						salaryComponentJson.setLeavesApplied(0);
					}

					employeeSalaryInfoJsonList.add(employeeSalaryInfoJson);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error in viewEmployeesPayRollByCompanyId() in RunPayRollService-->" + e.getMessage(), e);
		}
		return employeeSalaryInfoJsonList;
	}

	public Map<String, Integer> findNoOfPendingLeaves(List<Employee_Leave> employee_LeaveList) {
		Map<String, Integer> pendingAndRejectedLeavesMap = null;
		if (employee_LeaveList != null && employee_LeaveList.size() > 0) {
			pendingAndRejectedLeavesMap = new HashMap<String, Integer>();
			for (Employee_Leave employee_Leave : employee_LeaveList) {
				if (employee_Leave.getStatusId() == null) {
					if (pendingAndRejectedLeavesMap.get(Constants.PENDING) != null) {
						pendingAndRejectedLeavesMap.put(Constants.PENDING, pendingAndRejectedLeavesMap.get(Constants.PENDING) + 1);
					} else {
						pendingAndRejectedLeavesMap.put(Constants.PENDING, 1);
					}
				} else if (employee_Leave.getStatusId().equals(EnumUtils.REJECT.getValue())) {
					if (pendingAndRejectedLeavesMap.get(Constants.REJECTED) != null) {
						pendingAndRejectedLeavesMap.put(Constants.REJECTED, pendingAndRejectedLeavesMap.get(Constants.REJECTED) + 1);
					} else {
						pendingAndRejectedLeavesMap.put(Constants.REJECTED, 1);
					}
				}
			}
		}

		return pendingAndRejectedLeavesMap;
	}

	/**
	 * This method is to get the employeeId with their time sheets list
	 * represented map
	 * 
	 * @param employeeIds
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Map<Integer, List<Employee_TimeSheet>> getAllTimeSheetsByEmployeeIdsAndTimeDuration(List<Integer> employeeIds, Date startDate, Date endDate) {
		Map<Integer, List<Employee_TimeSheet>> employee_TimeSheetMap = null;
		try {
			// getting all employee Time sheet By employeeIds, start and end
			// dates
			List<Employee_TimeSheet> employee_TimeSheetList = employeeTimeSheetRepository.getAllTimeSheetsByEmployeeIdsAndTimeDuration(employeeIds,
					startDate, endDate);
			if (employee_TimeSheetList != null && employee_TimeSheetList.size() > 0) {
				employee_TimeSheetMap = new HashMap<Integer, List<Employee_TimeSheet>>();
				// putting employee Id with their time sheet in to the map
				for (Employee_TimeSheet empTimeSheet : employee_TimeSheetList) {
					if (employee_TimeSheetMap.get(empTimeSheet.getEmployeeId()) != null) {
						employee_TimeSheetMap.get(empTimeSheet.getEmployeeId()).add(empTimeSheet);
					} else {
						List<Employee_TimeSheet> list = new ArrayList<Employee_TimeSheet>();
						list.add(empTimeSheet);
						employee_TimeSheetMap.put(empTimeSheet.getEmployeeId(), list);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee_TimeSheetMap;
	}

	/**
	 * This method is to get the employeeId with their time leaves list
	 * represented map
	 * 
	 * @param employeeIds
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Map<Integer, List<Employee_Leave>> getAllLeavesByEmployeeIdsAndTimeDuration(List<Integer> employeeIds, Date startDate, Date endDate) {
		Map<Integer, List<Employee_Leave>> employee_LeaveMap = null;
		try {
			// getting all employee leaves By employeeIds, start and end dates
			List<Employee_Leave> employee_LeaveList = employeeLeaveRepository.getAllLeavesByEmployeeIdsAndTimeDuration(employeeIds, startDate,
					endDate);
			if (employee_LeaveList != null && employee_LeaveList.size() > 0) {
				employee_LeaveMap = new HashMap<Integer, List<Employee_Leave>>();
				// putting employee Id with their leaves in to the map
				for (Employee_Leave employee_Leave : employee_LeaveList) {
					if (employee_LeaveMap.get(employee_Leave.getEmployeeId()) != null) {
						employee_LeaveMap.get(employee_Leave.getEmployeeId()).add(employee_Leave);
					} else {
						List<Employee_Leave> list = new ArrayList<Employee_Leave>();
						list.add(employee_Leave);
						employee_LeaveMap.put(employee_Leave.getEmployeeId(), list);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee_LeaveMap;
	}
}
