package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.Bonuses;

@Repository
public class BonusesRepository extends BaseRepository {
	
	public Bonuses findbyId(Integer id) {
		return (Bonuses) getSession().get(Bonuses.class, id);
	}

}
