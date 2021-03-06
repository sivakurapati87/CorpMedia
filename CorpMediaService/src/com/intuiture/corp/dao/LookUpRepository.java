package com.intuiture.corp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.LookUpDetails;
import com.intuiture.corp.util.Constants;

@Repository
public class LookUpRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(LookUpRepository.class);
	private final String LOOKUPDETAILSBYTYPELIST = "select l from LookUpDetails l where l.lookUpMaster.lookupType in (:lookupType)";

	@SuppressWarnings("unchecked")
	public List<LookUpDetails> getAllLookupDetailsByTypeList(List<String> typesList) {
		List<LookUpDetails> lookUpDetailList = null;
		try {
			Query query = getSession().createQuery(LOOKUPDETAILSBYTYPELIST);
			query.setParameterList("lookupType", typesList);
			lookUpDetailList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return lookUpDetailList;
	}

	@SuppressWarnings("unchecked")
	public List<LookUpDetails> getPayCycleList(List<Integer> range) {
		List<LookUpDetails> lookUpDetailList = null;
		try {
			Criteria criteria = getSession().createCriteria(LookUpDetails.class);
			criteria.add(Restrictions.in("indexOfTheMonth", range));
			criteria.addOrder(Order.asc("indexOfTheMonth"));
			lookUpDetailList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return lookUpDetailList;
	}
	@SuppressWarnings("unchecked")
	public List<LookUpDetails> getAllMonthsByMaster() {
		List<LookUpDetails> lookUpDetailList = null;
		try {
			Criteria criteria = getSession().createCriteria(LookUpDetails.class);
			criteria.createAlias("lookUpMaster", "lookUpMaster");
			criteria.add(Restrictions.eq("lookUpMaster.lookupType", Constants.MONTHS));
			lookUpDetailList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return lookUpDetailList;
	}
}
