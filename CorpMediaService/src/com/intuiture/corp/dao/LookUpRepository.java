package com.intuiture.corp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.LookUpDetails;

@Repository
public class LookUpRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(LookUpRepository.class);
	// private final String LOOKUPDETAILSBYTYPE =
	// "LookUpDetails.lookupDetailsByType";
	private final String LOOKUPDETAILSBYTYPELIST = "select l from LookUpDetails l where l.lookUpMaster.lookupType in (:lookupType)";

	// private final String LOOKUPDETAILSBYPARENT =
	// "LookUpDetails.lookupDetailsByParent";
	// private final String LOOKUPDETAILSBYPREVDETAILID =
	// "LookUpDetails.lookupDetailsByPrevDetailId";
	// private final String LOOKUPDETAILSBYDETAILIDS =
	// "LookUpDetails.lookupDetailsByDetailIds";
	// private final String DECLOOKUPDETAILSBYDETAILIDS =
	// "LookUpDetails.decLookupDetailsByPrevDetailId";

	// public List<LookUpDetails> getAllLookupDetailsByType(String type) {
	// List<LookUpDetails> lookUpDetailList = null;
	// try {
	// TypedQuery<LookUpDetails> tpQuery =
	// getEntityManager().createNamedQuery(LOOKUPDETAILSBYTYPE,
	// LookUpDetails.class);
	// tpQuery.setParameter(1, type);
	// lookUpDetailList = tpQuery.getResultList();
	// } catch (Exception e) {
	// e.printStackTrace();
	// LOG.error(e.getMessage());
	// }
	// return lookUpDetailList;
	// }
	//
	// public List<LookUpDetails> lookupDetailsByPrevDetailId(String type,
	// Integer detailId) {
	// List<LookUpDetails> lookUpDetailList = null;
	// try {
	// TypedQuery<LookUpDetails> tpQuery =
	// getEntityManager().createNamedQuery(LOOKUPDETAILSBYPREVDETAILID,
	// LookUpDetails.class);
	// tpQuery.setParameter(1, type);
	// tpQuery.setParameter(2, detailId);
	// lookUpDetailList = tpQuery.getResultList();
	// } catch (Exception e) {
	// e.printStackTrace();
	// LOG.error(e.getMessage());
	// }
	// return lookUpDetailList;
	// }
	//
	// public List<LookUpDetails> decLookupDetailsByPrevDetailId(String type,
	// Integer detailId) {
	// List<LookUpDetails> lookUpDetailList = null;
	// try {
	// TypedQuery<LookUpDetails> tpQuery =
	// getEntityManager().createNamedQuery(DECLOOKUPDETAILSBYDETAILIDS,
	// LookUpDetails.class);
	// tpQuery.setParameter(1, type);
	// tpQuery.setParameter(2, detailId);
	// lookUpDetailList = tpQuery.getResultList();
	// } catch (Exception e) {
	// e.printStackTrace();
	// LOG.error(e.getMessage());
	// }
	// return lookUpDetailList;
	// }

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

	// public List<LookUpDetails> getLookUpDetailsByParent(Integer parent) {
	// List<LookUpDetails> lookUpDetailList = null;
	// TypedQuery<LookUpDetails> tpQuery =
	// getEntityManager().createNamedQuery(LOOKUPDETAILSBYPARENT,
	// LookUpDetails.class);
	// tpQuery.setParameter(1, parent);
	// lookUpDetailList = tpQuery.getResultList();
	// return lookUpDetailList;
	// }
	//
	// public List<LookUpDetails> getLookUpDetailsByDetailIds(List<Integer>
	// detailIds) {
	// TypedQuery<LookUpDetails> typedQuery =
	// getEntityManager().createNamedQuery(LOOKUPDETAILSBYDETAILIDS,
	// LookUpDetails.class);
	// typedQuery.setParameter(1, detailIds);
	// List<LookUpDetails> lookUpDetailList = typedQuery.getResultList();
	// return lookUpDetailList;
	// }
	//
	// public void persist(LookUpDetails details) {
	// getEntityManager().persist(details);
	// }
	//

}
