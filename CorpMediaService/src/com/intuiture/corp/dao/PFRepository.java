package com.intuiture.corp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.PFInfo;

@Repository
public class PFRepository extends BaseRepository {
	private static final String FINDBY_CompId = "select pf from PFInfo pf where pf.companyId = ?";

	@SuppressWarnings("unchecked")
	public PFInfo getPFInfo_cmpId(Integer companyId) {
		PFInfo pfInfo = null;
		try {
			Query tpQuery = getSession().createQuery(FINDBY_CompId);
			tpQuery.setParameter(0, companyId);
			List<PFInfo> list = tpQuery.list();
			if (list != null && list.size() > 0) {
				pfInfo = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pfInfo;
	}

	public PFInfo findBy_PFId(Integer pfInfoId) {
		return (PFInfo) getSession().createCriteria(PFInfo.class).add(Restrictions.eq("pfInfoId", pfInfoId)).uniqueResult();
	}
}
