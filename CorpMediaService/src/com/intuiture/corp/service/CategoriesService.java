package com.intuiture.corp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.corp.dao.CategoriesRepository;
import com.intuiture.corp.dao.CommonRepository;
import com.intuiture.corp.entity.Categories;
import com.intuiture.corp.json.CategoriesJson;
import com.intuiture.corp.util.TransformDomainToJson;
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
	
	
	@SuppressWarnings("unchecked")
	public List<CategoriesJson> getAllCategoriesList(Integer companyId) {
		List<CategoriesJson> categoriesJsonList = null;
		try {
			List<Categories> categoriesList = (List<Categories>) commonRepository.getAllRecordsByCompanyId(companyId, Categories.class);
			if (categoriesList != null && categoriesList.size() > 0) {
				categoriesJsonList = new ArrayList<CategoriesJson>();
				for (Categories categories : categoriesList) {
					categoriesJsonList.add(TransformDomainToJson.getCategoriesJson(categories));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoriesJsonList;
	}
	
	
	public Boolean deleteCategories(Integer categoriesId) {
		try {
			Categories categories = (Categories) commonRepository.findById(categoriesId, Categories.class);
			if (categories != null) {
				categories.setIsDeleted(Boolean.TRUE);
				commonRepository.update(categories);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	

}
