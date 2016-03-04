package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.TravelReimbursement;
@Repository
public class TravelReimbursementRepository extends BaseRepository {
	
	public TravelReimbursement findbyId(Integer id) {
		return (TravelReimbursement) getSession().get(TravelReimbursement.class, id);
	}


}
