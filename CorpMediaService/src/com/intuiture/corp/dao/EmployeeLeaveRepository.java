package com.intuiture.corp.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.Employee_Leave;
import com.intuiture.corp.entity.Leave;
import com.intuiture.corp.json.EmployeeLeaveJson;

@Repository
public class EmployeeLeaveRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(EmployeeLeaveRepository.class);

	@SuppressWarnings("unchecked")
	public List<Employee_Leave> getEmployeeLeavesOfTheWeek(Integer employeeId, List<Date> weekDatesList) {
		List<Employee_Leave> employee_LeaveList = null;
		try {
			Criteria criteria = getSession().createCriteria(Employee_Leave.class);
			criteria.createAlias("leave", "leave");
			criteria.add(Restrictions.and(
					Restrictions.eq("employeeId", employeeId),
					Restrictions.and(Restrictions.ge("leave.leaveDate", weekDatesList.get(0)),
							Restrictions.le("leave.leaveDate", weekDatesList.get(6)))));
			criteria.addOrder(Order.asc("leave.leaveDate"));
			employee_LeaveList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at EmployeeLeaveRepository getEmployeeLeavesOfTheWeek()" + e.getMessage(), e);
		}
		return employee_LeaveList;
	}

	@SuppressWarnings("unchecked")
	public List<Employee_Leave> getEmployeeApplyLeave(Integer employeeId, EmployeeLeaveJson employeeLeaveJson) {
		List<Employee_Leave> employee_LeaveList = null;
		try {
			Criteria criteria = getSession().createCriteria(Employee_Leave.class);
			criteria.createAlias("leave", "leave");
			if (employeeLeaveJson.getLeaveStartDate() != null && employeeLeaveJson.getLeaveEndDate() != null) {
				criteria.add(Restrictions.and(
						Restrictions.eq("employeeId", employeeId),
						Restrictions.and(Restrictions.ge("leave.leaveDate", employeeLeaveJson.getLeaveStartDate()),
								Restrictions.le("leave.leaveDate", employeeLeaveJson.getLeaveEndDate()))));
			} else {
				criteria.add(Restrictions.and(Restrictions.eq("employeeId", employeeId),
						Restrictions.eq("leave.leaveDate", employeeLeaveJson.getLeaveStartDate())));
			}
			criteria.addOrder(Order.asc("leave.leaveDate"));
			employee_LeaveList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at EmployeeLeaveRepository getEmployeeLeavesOfTheWeek()" + e.getMessage(), e);
		}
		return employee_LeaveList;
	}

	@SuppressWarnings("unchecked")
	public List<Leave> getAllLeaves(List<Date> weekDatesList, EmployeeLeaveJson employeeLeaveJson) {
		List<Leave> leaveList = null;
		try {
			Criteria criteria = getSession().createCriteria(Leave.class);
			if (employeeLeaveJson != null) {
				if (employeeLeaveJson.getLeaveStartDate() != null && employeeLeaveJson.getLeaveEndDate() != null) {
					criteria.add(Restrictions.and(Restrictions.ge("leaveDate", employeeLeaveJson.getLeaveStartDate()),
							Restrictions.le("leaveDate", employeeLeaveJson.getLeaveEndDate())));
				} else {
					criteria.add(Restrictions.eq("leaveDate", employeeLeaveJson.getLeaveStartDate()));
				}
			} else {
				criteria.add(Restrictions.and(Restrictions.ge("leaveDate", weekDatesList.get(0)), Restrictions.le("leaveDate", weekDatesList.get(6))));
			}
			criteria.addOrder(Order.asc("leaveDate"));
			leaveList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at EmployeeLeaveRepository getAllLeaves()" + e.getMessage(), e);
		}
		return leaveList;
	}

	@SuppressWarnings("unchecked")
	public List<Employee_Leave> getEmployee_LeaveByEmpIdAndLeaveIds(Integer employeeId, List<Integer> leaveIds) {
		List<Employee_Leave> employee_LeaveList = null;
		try {
			Criteria criteria = getSession().createCriteria(Employee_Leave.class);
			criteria.add(Restrictions.and(Restrictions.eq("employeeId", employeeId), Restrictions.in("leaveId", leaveIds)));
			employee_LeaveList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at EmployeeLeaveRepository getEmployee_TimeSheetByEmpIdAndTimeSheetId()" + e.getMessage(), e);
		}
		return employee_LeaveList;
	}

	@SuppressWarnings("unchecked")
	public List<Employee_Leave> getAllLeavesByCompany(Integer companyId) {
		List<Employee_Leave> employee_LeaveList = null;
		try {
			Criteria criteria = getSession().createCriteria(Employee_Leave.class);
			criteria.createAlias("employee", "employee");
			criteria.add(Restrictions.and(Restrictions.eq("employee.companyId", companyId), Restrictions.isNull("statusId"),
					Restrictions.isNotNull("leaveTime")));
			employee_LeaveList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at EmployeeLeaveRepository getAllLeavesByCompany()" + e.getMessage(), e);
		}
		return employee_LeaveList;
	}

	@SuppressWarnings("unchecked")
	public List<Employee_Leave> getAllLeavesByEmployeeIdsAndTimeDuration(List<Integer> employeeIds, Date startDate, Date endDate) {
		List<Employee_Leave> employee_LeaveList = null;
		try {
			Criteria criteria = getSession().createCriteria(Employee_Leave.class);
			criteria.createAlias("leave", "leave");
			criteria.add(Restrictions.and(Restrictions.in("employeeId", employeeIds),
					Restrictions.and(Restrictions.ge("leave.leaveDate", startDate), Restrictions.le("leave.leaveDate", endDate))));
			criteria.addOrder(Order.asc("leave.leaveDate"));
			employee_LeaveList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at EmployeeLeaveRepository getAllLeavesByEmployeeIdsAndTimeDuration()" + e.getMessage(), e);
		}
		return employee_LeaveList;
	}

}
