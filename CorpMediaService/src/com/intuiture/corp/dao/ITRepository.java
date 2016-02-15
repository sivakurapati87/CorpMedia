package com.intuiture.corp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.ITInfo;

@Repository
public class ITRepository extends BaseRepository {
	private static final String FINDBY_CompId = "select it from ITInfo it where it.companyId = ?";

	@SuppressWarnings("unchecked")
	public ITInfo getITInfo_cmpId(Integer companyId) {
		ITInfo itInfo = null;
		try {
			Query tpQuery = getSession().createQuery(FINDBY_CompId);
			tpQuery.setParameter(0, companyId);
			List<ITInfo> list = tpQuery.list();
			if (list != null && list.size() > 0) {
				itInfo = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itInfo;
	}

	public ITInfo findBy_ITId(Integer itInfoId) {
		return (ITInfo) getSession().createCriteria(ITInfo.class).add(Restrictions.eq("itInfoId", itInfoId)).uniqueResult();
	}

}
