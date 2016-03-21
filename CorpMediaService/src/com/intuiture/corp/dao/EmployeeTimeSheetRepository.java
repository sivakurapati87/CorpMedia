package com.intuiture.corp.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.Employee_TimeSheet;
import com.intuiture.corp.entity.TimeSheet;

@Repository
public class EmployeeTimeSheetRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(EmployeeTimeSheetRepository.class);

	@SuppressWarnings("unchecked")
	public List<Employee_TimeSheet> getEmployeeTimesheetOfTheWeek(Integer employeeId, List<Date> weekDatesList) {
		List<Employee_TimeSheet> employee_TimeSheetList = null;
		try {
			Criteria criteria = getSession().createCriteria(Employee_TimeSheet.class);
			criteria.createAlias("timesheet", "timesheet");
			criteria.add(Restrictions.and(
					Restrictions.eq("employeeId", employeeId),
					Restrictions.and(Restrictions.ge("timesheet.timeSheetDate", weekDatesList.get(0)),
							Restrictions.le("timesheet.timeSheetDate", weekDatesList.get(6)))));
			criteria.addOrder(Order.asc("timesheet.timeSheetDate"));
			employee_TimeSheetList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at EmployeeTimeSheetRepository getEmployeeTimesheetOfTheWeek()" + e.getMessage(), e);
		}
		return employee_TimeSheetList;
	}

	@SuppressWarnings("unchecked")
	public List<TimeSheet> getAllTimeSheets(List<Date> weekDatesList) {
		List<TimeSheet> timeSheetList = null;
		try {
			Criteria criteria = getSession().createCriteria(TimeSheet.class);
			criteria.add(Restrictions.and(Restrictions.ge("timeSheetDate", weekDatesList.get(0)),
					Restrictions.le("timeSheetDate", weekDatesList.get(6))));
			criteria.addOrder(Order.asc("timeSheetDate"));
			timeSheetList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at EmployeeTimeSheetRepository getAllTimeSheets()" + e.getMessage(), e);
		}
		return timeSheetList;
	}

	public Employee_TimeSheet getEmployee_TimeSheetByEmpIdAndTimeSheetId(Integer employeeId, Integer timesheetId) {
		Employee_TimeSheet employee_TimeSheet = null;
		try {
			Criteria criteria = getSession().createCriteria(Employee_TimeSheet.class);
			criteria.add(Restrictions.and(Restrictions.eq("employeeId", employeeId), Restrictions.eq("timesheetId", timesheetId)));
			employee_TimeSheet = (Employee_TimeSheet) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at EmployeeTimeSheetRepository getEmployee_TimeSheetByEmpIdAndTimeSheetId()" + e.getMessage(), e);
		}
		return employee_TimeSheet;
	}

}
