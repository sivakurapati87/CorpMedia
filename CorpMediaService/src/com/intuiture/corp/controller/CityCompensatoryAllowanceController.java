package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.CityCompensatoryAllowanceJson;
import com.intuiture.corp.service.CityCompensatoryAllowanceService;

@Controller
@RequestMapping("/CityCompensatoryAllowanceController")
public class CityCompensatoryAllowanceController {
	
	@Autowired
	private CityCompensatoryAllowanceService cityCompensatoryAllowanceService;
	
	@RequestMapping(value = "/saveCityCompensatoryAllowance", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveCityCompensatoryAllowance(HttpServletRequest request, HttpServletResponse response, @RequestBody CityCompensatoryAllowanceJson cityCompensatoryAllowanceJson) {
		return cityCompensatoryAllowanceService.saveCityCompensatoryAllowance(cityCompensatoryAllowanceJson);
	}
	
	@RequestMapping(value = "/getCityCompensatoryAllowanceList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public CityCompensatoryAllowanceJson getCityCompensatoryAllowanceList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return cityCompensatoryAllowanceService.getCityCompensatoryAllowanceList(companyId);
	}

}
