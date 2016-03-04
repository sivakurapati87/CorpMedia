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

import com.intuiture.corp.json.ProfessionalAllowanceJson;
import com.intuiture.corp.service.ProfessionalAllowanceService;

@Controller
@RequestMapping("/ProfessionalAllowanceController")
public class ProfessionalAllowanceController {
	
	@Autowired
	private ProfessionalAllowanceService professionalAllowanceService;
	
	@RequestMapping(value = "/saveProfessionalAllowance", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveProfessionalAllowance(HttpServletRequest request, HttpServletResponse response, @RequestBody ProfessionalAllowanceJson professionalAllowanceJson) {
		return professionalAllowanceService.saveProfessionalAllowance(professionalAllowanceJson);
	}
	
	@RequestMapping(value = "/getProfessionalAllowanceList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public ProfessionalAllowanceJson getProfessionalAllowanceList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return professionalAllowanceService.getProfessionalAllowanceList(companyId);
	}

}
