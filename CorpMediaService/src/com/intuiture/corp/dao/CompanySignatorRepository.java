package com.intuiture.corp.dao;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.CompanySignator;

@Repository
public class CompanySignatorRepository extends BaseRepository {

	public CompanySignator findById(Integer signatorId) {
		return (CompanySignator) getSession().createCriteria(CompanySignator.class).add(Restrictions.eq("companySignatorId", signatorId)).uniqueResult();
	}

}
