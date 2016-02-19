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

import com.intuiture.corp.json.CompanyBankJson;
import com.intuiture.corp.service.CompanyBankService;

@Controller
@RequestMapping("/CompanyBankController")
public class CompanyBankController {
	@Autowired
	private CompanyBankService companyBankService;

	@RequestMapping(value = "/saveBank", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveBank(HttpServletRequest request, HttpServletResponse response, @RequestBody CompanyBankJson companyBankJson) {
		return companyBankService.saveBank(companyBankJson);
	}

	@RequestMapping(value = "/getAllSignatoriesList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<CompanyBankJson> getAllSignatoriesList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return companyBankService.getAllSignatoriesList(companyId);
	}

	@RequestMapping(value = "/deleteBank/{companyBankId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteBank(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyBankId) {
		return companyBankService.deleteBank(companyBankId);
	}
}
