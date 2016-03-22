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

import com.intuiture.corp.json.DesignationJson;
import com.intuiture.corp.service.DesignationService;


@Controller
@RequestMapping("/DesignationController")
public class DesignationController {
	@Autowired
	private DesignationService designationService;
	
	
	@RequestMapping(value = "/saveDesignation", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveDesignation(HttpServletRequest request, HttpServletResponse response, @RequestBody DesignationJson designationJson) {
		return  designationService.saveDesignation(designationJson);
	}
	
	
	@RequestMapping(value = "/getAllDesignationsList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<DesignationJson> getAllDesignationsList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return designationService.getAllDesignationsList(companyId);
	}

	@RequestMapping(value = "/deleteCompanyDesignation/{designationId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteCompanyDesignation(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer designationId) {
		return designationService.deleteCompanyDesignation(designationId);
	}
}
