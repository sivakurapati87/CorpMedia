package com.intuiture.corp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.CompanyRoles;

@Repository
public class CompanyRolesRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(CompanyRolesRepository.class);

	public CompanyRoles findById(Integer id) {
		return (CompanyRoles) getSession().get(CompanyRoles.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<CompanyRoles> getAllRoles(Integer companyId) {
		List<CompanyRoles> companyRolesList = null;
		try {
			Criteria criteria = getSession().createCriteria(CompanyRoles.class);
			criteria.add(Restrictions.eq("companyId", companyId));
			companyRolesList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return companyRolesList;
	}
}
