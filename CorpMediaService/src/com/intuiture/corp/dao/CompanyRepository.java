package com.intuiture.corp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.Company;
import com.intuiture.corp.entity.CompanySignator;

@Repository
public class CompanyRepository extends BaseRepository {
	private static final String FINDBY_CompName = "select c from Company c where c.companyName = ?";
	private static final String CMP_SIGNATORS_BY_CMPID = "select c from CompanySignator c where c.companyId in (:ids)";

	@SuppressWarnings("unchecked")
	public List<Company> getCompanyInfo(String compName) {
		List<Company> companieList = null;
		try {
			Query tpQuery = getSession().createQuery(FINDBY_CompName);
			tpQuery.setParameter(0, compName);
			companieList = tpQuery.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companieList;
	}

	@SuppressWarnings("unchecked")
	public List<Company> getAllRecords() {
		List<Company> companieList = null;
		try {
			Criteria criteria = getSession().createCriteria(Company.class);
			companieList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companieList;
	}

	@SuppressWarnings("unchecked")
	public List<CompanySignator> getCompanySignatorsByCompanyId(List<Integer> companyIds) {
		List<CompanySignator> companySignatorList = null;
		try {
			Query tpQuery = getSession().createQuery(CMP_SIGNATORS_BY_CMPID);
			tpQuery.setParameterList("ids", companyIds);
			companySignatorList = tpQuery.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companySignatorList;
	}

	@SuppressWarnings("unchecked")
	public List<Company> findCompanyByName(String compName) {
		List<Company> companieList = null;
		try {
			Criteria criteria = getSession().createCriteria(Company.class);
			criteria.add(Restrictions.like("companyName", compName, MatchMode.ANYWHERE));
			companieList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return companieList;
	}
}
