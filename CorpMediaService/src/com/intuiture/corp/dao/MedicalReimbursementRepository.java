package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.MedicalReimbursement;

@Repository
public class MedicalReimbursementRepository extends BaseRepository {
	public MedicalReimbursement findbyId(Integer id) {
		return (MedicalReimbursement) getSession().get(MedicalReimbursement.class, id);
	}

}
