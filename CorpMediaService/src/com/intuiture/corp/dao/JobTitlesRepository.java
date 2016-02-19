package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.JobTitles;

@Repository
public class JobTitlesRepository extends BaseRepository {
	
	
	public JobTitles findbyId(Integer id) {
		return (JobTitles) getSession().get(JobTitles.class, id);
	}

}
