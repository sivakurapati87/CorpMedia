package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

@Repository
public class TimeSheetApproverRepository extends BaseRepository {
//	private final static Logger LOG = Logger.getLogger(TimeSheetApproverRepository.class);

//	public TimeSheetApprovers findById(Integer id) {
//		return (TimeSheetApprovers) getSession().get(TimeSheetApprovers.class, id);
//	}

//	@SuppressWarnings("unchecked")
//	public List<TimeSheetApprovers> getAllTimeSheetApprovers(Integer companyId) {
//		List<TimeSheetApprovers> timeSheetApproverList = null;
//		try {
//			Criteria criteria = getSession().createCriteria(TimeSheetApprovers.class);
//			criteria.add(Restrictions.eq("companyId", companyId));
//			timeSheetApproverList = criteria.list();
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error(e.getMessage(), e);
//		}
//		return timeSheetApproverList;
//	}
}
