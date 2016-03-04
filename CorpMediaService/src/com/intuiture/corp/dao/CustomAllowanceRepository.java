package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.CustomAllowance;

@Repository
public class CustomAllowanceRepository extends BaseRepository {
	
	public CustomAllowance findbyId(Integer id) {
		return (CustomAllowance) getSession().get(CustomAllowance.class, id);
	}

	
	

}
