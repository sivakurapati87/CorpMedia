package com.intuiture.corp.dao;

import org.springframework.stereotype.Repository;

import com.intuiture.corp.entity.Categories;

@Repository
public class CategoriesRepository extends BaseRepository {
	
	public Categories findbyId(Integer id) {
		return (Categories) getSession().get(Categories.class, id);
	}
	

}
