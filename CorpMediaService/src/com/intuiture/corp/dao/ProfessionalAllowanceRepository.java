package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.ProfessionalAllowance;
@Repository
public class ProfessionalAllowanceRepository extends BaseRepository {
	
	public ProfessionalAllowance findbyId(Integer id) {
		return (ProfessionalAllowance) getSession().get(ProfessionalAllowance.class, id);
	}


}
