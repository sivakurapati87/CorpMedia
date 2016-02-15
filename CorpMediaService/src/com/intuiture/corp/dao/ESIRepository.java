package com.intuiture.corp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.ESIInfo;

@Repository
public class ESIRepository extends BaseRepository {
	private static final String FINDBY_CompId = "select esi from ESIInfo esi where esi.companyId = ?";

	@SuppressWarnings("unchecked")
	public ESIInfo getESIInfo_cmpId(Integer companyId) {
		ESIInfo esiInfo = null;
		try {
			Query tpQuery = getSession().createQuery(FINDBY_CompId);
			tpQuery.setParameter(0, companyId);
			List<ESIInfo> list = tpQuery.list();
			if (list != null && list.size() > 0) {
				esiInfo = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return esiInfo;
	}

	public ESIInfo findBy_ESIId(Integer esiInfoId) {
		return (ESIInfo) getSession().createCriteria(ESIInfo.class).add(Restrictions.eq("esiInfoId", esiInfoId)).uniqueResult();
	}

}
