package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.CompanyLocationJson;
import com.intuiture.corp.service.CompanyLocationService;

@Controller
@RequestMapping("/CompanyLocationController")
public class CompanyLocationController {
	@Autowired
	private CompanyLocationService companyLocationService;

	@RequestMapping(value = "/saveLocation", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveLocation(HttpServletRequest request, HttpServletResponse response, @RequestBody CompanyLocationJson companyLocationJson) {
		return companyLocationService.saveLocation(companyLocationJson);
	}
}
