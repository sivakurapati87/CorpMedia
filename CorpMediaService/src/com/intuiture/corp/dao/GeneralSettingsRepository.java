package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

@Repository
public class GeneralSettingsRepository extends BaseRepository {
//	private final static Logger LOG = Logger.getLogger(GeneralSettingsRepository.class);

//	public GeneralSettings findbyId(Integer id) {
//		return (GeneralSettings) getSession().get(GeneralSettings.class, id);
//	}
//
//	public GeneralSettings getGeneralSettingsByCompanyId(Integer companyId) {
//		GeneralSettings generalSettings = null;
//		try {
//			Criteria criteria = getSession().createCriteria(GeneralSettings.class);
//			criteria.add(Restrictions.eq("companyId", companyId));
//			generalSettings = (GeneralSettings) criteria.uniqueResult();
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error(e.getMessage(), e);
//		}
//		return generalSettings;
//	}
}
