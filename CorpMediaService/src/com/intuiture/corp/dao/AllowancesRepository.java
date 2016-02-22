package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.Allowances;

@Repository
public class AllowancesRepository extends BaseRepository {
	
	public Allowances findbyId(Integer id) {
		return (Allowances) getSession().get(Allowances.class, id);
	}

}
