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

import com.intuiture.corp.json.CompanyRolesJson;
import com.intuiture.corp.service.CompanyRolesService;

@Controller
@RequestMapping("/CompanyRolesController")
public class CompanyRolesController {
	@Autowired
	private CompanyRolesService companyRolesService;

	@RequestMapping(value = "/saveOrUpdateRole", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateRole(HttpServletRequest request, HttpServletResponse response, @RequestBody CompanyRolesJson companyRolesJson) {
		return companyRolesService.saveOrUpdateRole(companyRolesJson);
	}

	@RequestMapping(value = "/getAllRoles/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<CompanyRolesJson> getAllCompanyRoles(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return companyRolesService.getAllRoles(companyId);
	}
}
