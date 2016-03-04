package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.CityCompensatoryAllowance;
@Repository
public class CityCompensatoryAllowanceRepository extends BaseRepository {
	
	public CityCompensatoryAllowance findbyId(Integer id) {
		return (CityCompensatoryAllowance) getSession().get(CityCompensatoryAllowance.class, id);
	}


}
