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

import com.intuiture.corp.json.CompanySignatorJson;
import com.intuiture.corp.service.CompanySignatorService;

@Controller
@RequestMapping("/CompanySignatorController")
public class CompanySignatorController {
	@Autowired
	private CompanySignatorService companySignatorService;

	@RequestMapping(value = "/saveSignatory", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveSignatory(HttpServletRequest request, HttpServletResponse response, @RequestBody CompanySignatorJson companySignatorJson) {
		return companySignatorService.saveSignatory(companySignatorJson);
	}

	@RequestMapping(value = "/getAllSignatoriesList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<CompanySignatorJson> getAllSignatoriesList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return companySignatorService.getAllSignatoriesList(companyId);
	}

	@RequestMapping(value = "/deleteSignator/{companySignatorId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteSignator(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companySignatorId) {
		return companySignatorService.deleteSignator(companySignatorId);
	}
}
