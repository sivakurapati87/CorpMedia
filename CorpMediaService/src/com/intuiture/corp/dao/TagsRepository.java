package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.Tags;

@Repository
public class TagsRepository extends BaseRepository {
	
	public Tags findbyId(Integer id) {
		return (Tags) getSession().get(Tags.class, id);
	}

}
