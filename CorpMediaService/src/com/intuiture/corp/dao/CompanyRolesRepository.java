package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

@Repository
public class CompanyRolesRepository extends BaseRepository {
//	private final static Logger LOG = Logger.getLogger(CompanyRolesRepository.class);
//
//	public CompanyRoles findById(Integer id) {
//		return (CompanyRoles) getSession().get(CompanyRoles.class, id);
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<CompanyRoles> getAllRoles(Integer companyId) {
//		List<CompanyRoles> companyRolesList = null;
//		try {
//			Criteria criteria = getSession().createCriteria(CompanyRoles.class);
//			criteria.add(Restrictions.eq("companyId", companyId));
//			companyRolesList = criteria.list();
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error(e.getMessage(), e);
//		}
//		return companyRolesList;
//	}
}
