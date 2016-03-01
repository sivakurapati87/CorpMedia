package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.DailyAllowance;
@Repository
public class DailyAllowanceRepository extends BaseRepository {
	
	public DailyAllowance findbyId(Integer id) {
		return (DailyAllowance) getSession().get(DailyAllowance.class, id);
	}


}
