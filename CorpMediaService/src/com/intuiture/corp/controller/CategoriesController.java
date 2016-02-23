package com.intuiture.corp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.CategoriesJson;
import com.intuiture.corp.service.CategoriesService;

@Controller
@RequestMapping("/CategoriesController")
public class CategoriesController {
	
	@Autowired
	private CategoriesService categoriesService;
	
	@RequestMapping(value = "/saveCategories", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveCategories(HttpServletRequest request, HttpServletResponse response, @RequestBody CategoriesJson categoriesJson) {
		return categoriesService.saveCategories(categoriesJson);
	}
	
	
	@RequestMapping(value = "/getAllCategoriesList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<CategoriesJson> getAllCategoriesList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return categoriesService.getAllCategoriesList(companyId);
	}
	
	@RequestMapping(value = "/deleteCategories/{categoriesId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteCategories(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer categoriesId) {
		return categoriesService.deleteCategories(categoriesId);
	}

}
