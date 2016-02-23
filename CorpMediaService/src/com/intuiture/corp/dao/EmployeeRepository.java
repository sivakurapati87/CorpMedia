package com.intuiture.corp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.EmployeeFamilyInfo;

@Repository
public class EmployeeRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(EmployeeRepository.class);

//	@SuppressWarnings("unchecked")
//	public List<EmployeeFamilyInfo> findByEmployeeId(Integer employeeId) {
//		List<EmployeeFamilyInfo> employeeFamilyInfoList = null;
//		try {
//			Criteria criteria = getSession().createCriteria(EmployeeFamilyInfo.class);
//			criteria.add(Restrictions.eq("employeeId", employeeId));
//			employeeFamilyInfoList = criteria.list();
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error("Error at EmployeeRepository findByEmployeeId()" + e.getMessage(), e);
//		}
//		return employeeFamilyInfoList;
//	}

}
