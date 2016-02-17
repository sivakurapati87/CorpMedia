package com.intuiture.corp.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.GeneralSettings;

@Repository
public class GeneralSettingsRepository extends BaseRepository {
	private final static Logger LOG = Logger.getLogger(GeneralSettingsRepository.class);

	public GeneralSettings findbyId(Integer id) {
		return (GeneralSettings) getSession().get(GeneralSettings.class, id);
	}
}
