package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.Deductions;

@Repository
public class DeductionsRepository extends BaseRepository {
	
	public Deductions findbyId(Integer id) {
		return (Deductions) getSession().get(Deductions.class, id);
	}

}
