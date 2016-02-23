package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.Reimbursement;

@Repository
public class ReimbursementRepository extends BaseRepository {
	
	public Reimbursement findbyId(Integer id) {
		return (Reimbursement) getSession().get(Reimbursement.class, id);
	}

}
