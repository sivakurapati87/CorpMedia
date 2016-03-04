package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.TransportAllowance;

@Repository
public class TransportAllowanceRepository extends BaseRepository {
	
	public TransportAllowance findbyId(Integer id) {
		return (TransportAllowance) getSession().get(TransportAllowance.class, id);
	}

}
