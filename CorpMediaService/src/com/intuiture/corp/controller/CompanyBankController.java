package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.CompanyBankJson;
import com.intuiture.corp.service.CompanyBankService;

@Controller
@RequestMapping("/BankController")
public class CompanyBankController {
	@Autowired
	private CompanyBankService bankService;

	@RequestMapping(value = "/saveBank", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveBank(HttpServletRequest request, HttpServletResponse response, @RequestBody CompanyBankJson companyBankJson) {
		return bankService.saveBank(companyBankJson);
	}
}
