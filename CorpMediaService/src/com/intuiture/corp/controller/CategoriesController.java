package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

}
