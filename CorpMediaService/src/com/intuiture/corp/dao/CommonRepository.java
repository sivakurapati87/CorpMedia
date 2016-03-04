package com.intuiture.corp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CommonRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(CommonRepository.class);

	/*
	 * This method is to save an object
	 */
	public synchronized void persist(Object object) {
		getSession().persist(object);
	}

	/*
	 * This method is to update an object
	 */
	public synchronized void update(Object object) {
		getSession().merge(object);
	}

	/**
	 * Get all records based on company Id
	 * 
	 * @param companyId
	 * @param classType
	 * @return
	 */
	public List<?> getAllRecordsByCompanyId(Integer companyId, Class<?> classType) {
		List<?> list = null;
		try {
			Criteria criteria = getSession().createCriteria(classType);
			criteria.add(Restrictions.and(Restrictions.eq("companyId", companyId), Restrictions.or(Restrictions.eq("isDeleted", Boolean.FALSE), Restrictions.isNull("isDeleted"))));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return list;
	}

	/**
	 * Get an object based on id
	 * 
	 * @param id
	 * @return
	 */
	public Object findById(Integer id, Class<?> classType) {
		return getSession().get(classType, id);
	}

	/**
	 * This method is to get an object based on companyId
	 * 
	 * @param companyId
	 * @return
	 */
	public Object getRecordByCompanyId(Integer companyId, Class<?> classType) {
		Object object = null;
		try {
			Criteria criteria = getSession().createCriteria(classType);
			criteria.add(Restrictions.eq("companyId", companyId));
			object = criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return object;
	}

	/**
	 * This method is to get all the records based on employee Id
	 * 
	 * @param employeeId
	 * @param clazz
	 * @return
	 */
	public List<?> findByEmployeeId(Integer employeeId, Class<?> clazz) {
		List<?> list = null;
		try {
			Criteria criteria = getSession().createCriteria(clazz);
			criteria.add(Restrictions.eq("employeeId", employeeId));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at EmployeeRepository findByEmployeeId()" + e.getMessage(), e);
		}
		return list;
	}

	/**
	 * This method is to get all the records based on employee Id
	 * 
	 * @param employeeId
	 * @param clazz
	 * @return
	 */
	public List<?> getAllRecordsByList(String fieldName, List<?> ids, Class<?> clazz) {
		List<?> list = null;
		try {
			Criteria criteria = getSession().createCriteria(clazz);
			criteria.add(Restrictions.in(fieldName, ids));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at EmployeeRepository findByEmployeeId()" + e.getMessage(), e);
		}
		return list;
	}
}
