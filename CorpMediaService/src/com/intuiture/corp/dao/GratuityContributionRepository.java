package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.GratuityContribution;
@Repository
public class GratuityContributionRepository extends BaseRepository {
	
	public GratuityContribution findbyId(Integer id) {
		return (GratuityContribution) getSession().get(GratuityContribution.class, id);
	}

}
