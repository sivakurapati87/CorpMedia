package com.intuiture.corp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CategoriesRepository;
import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.Categories;
import com.intuiture.corp.json.CategoriesJson;
import com.intuiture.corp.util.TransformJsonToDomain;

@Service
@Transactional
public class CategoriesService {
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	
	public Boolean saveCategories(CategoriesJson categoriesJson) {
		Categories categories = null;

		
		try {
			if (categoriesJson.getCategoriesId() != null) {
				categories = categoriesRepository.findbyId(categoriesJson.getCategoriesId());
			} else {
				categories = new Categories();
			}
			TransformJsonToDomain.getCategories(categories, categoriesJson);
			if (categoriesJson.getCategoriesId() != null) {
				commonRepository.update(categories);
			} else {
				commonRepository.persist(categories);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	

}
