package com.intuiture.corp.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.Employee_Leave;
import com.intuiture.corp.entity.Employee_TimeSheet;
import com.intuiture.corp.entity.Leave;
import com.intuiture.corp.json.EmployeeLeaveJson;

@Repository
public class EmployeeLeaveRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(EmployeeLeaveRepository.class);

	@SuppressWarnings("unchecked")
	public List<Employee_Leave> getEmployeeLeavesOfTheWeek(Integer employeeId, List<Date> weekDatesList, EmployeeLeaveJson employeeLeaveJson) {
		List<Employee_Leave> employee_LeaveList = null;
		try {
			Criteria criteria = getSession().createCriteria(Employee_Leave.class);
			criteria.createAlias("leave", "leave");
			if (employeeLeaveJson != null) {
				criteria.add(Restrictions.and(
						Restrictions.eq("employeeId", employeeId),
						Restrictions.and(Restrictions.ge("leave.leaveDate", employeeLeaveJson.getLeaveStartDate()),
								Restrictions.le("leave.leaveDate", employeeLeaveJson.getLeaveEndDate()))));
			} else {
				criteria.add(Restrictions.and(
						Restrictions.eq("employeeId", employeeId),
						Restrictions.and(Restrictions.ge("leave.leaveDate", weekDatesList.get(0)),
								Restrictions.le("leave.leaveDate", weekDatesList.get(6)))));
			}
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
				criteria.add(Restrictions.and(Restrictions.ge("leaveDate", employeeLeaveJson.getLeaveStartDate()),
						Restrictions.le("leaveDate", employeeLeaveJson.getLeaveEndDate())));
			} else {
				criteria.add(Restrictions.and(Restrictions.ge("leaveDate", weekDatesList.get(0)), Restrictions.le("leaveDate", weekDatesList.get(6))));
			}
			leaveList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at EmployeeLeaveRepository getAllLeaves()" + e.getMessage(), e);
		}
		return leaveList;
	}

	public Employee_Leave getEmployee_LeaveByEmpIdAndTimeSheetId(Integer employeeId, Integer leaveId) {
		Employee_Leave employee_Leave = null;
		try {
			Criteria criteria = getSession().createCriteria(Employee_TimeSheet.class);
			criteria.add(Restrictions.and(Restrictions.eq("employeeId", employeeId), Restrictions.eq("leaveId", leaveId)));
			employee_Leave = (Employee_Leave) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at EmployeeLeaveRepository getEmployee_TimeSheetByEmpIdAndTimeSheetId()" + e.getMessage(), e);
		}
		return employee_Leave;
	}

}
