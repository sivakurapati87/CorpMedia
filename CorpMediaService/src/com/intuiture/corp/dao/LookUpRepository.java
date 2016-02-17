package com.intuiture.corp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.LookUpDetails;

@Repository
public class LookUpRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(LookUpRepository.class);
	private final String LOOKUPDETAILSBYTYPELIST = "select l from LookUpDetails l where l.lookUpMaster.lookupType in (:lookupType)";

	@SuppressWarnings("unchecked")
	public List<LookUpDetails> getAllLookupDetailsByTypeList(List<String> typesList) {
		List<LookUpDetails> lookUpDetailList = null;
		try {
			// TypedQuery<LookUpDetails> tpQuery =
			// gete().createNamedQuery(LOOKUPDETAILSBYTYPELIST,
			// LookUpDetails.class);
			Query query = getSession().createQuery(LOOKUPDETAILSBYTYPELIST);
			query.setParameterList("lookupType", typesList);
			lookUpDetailList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return lookUpDetailList;
	}
}
