package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.BillingRatesJson;
import com.intuiture.corp.service.BillingRatesService;

@Controller
@RequestMapping("/BillingRatesController")
public class BillingRatesController {
	

	@Autowired
	private BillingRatesService billingRatesService;
	
	@RequestMapping(value = "/saveBillingRates", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveBillingRates(HttpServletRequest request, HttpServletResponse response, @RequestBody BillingRatesJson billingRatesJson) {
		return billingRatesService.saveBillingRates(billingRatesJson);
	}


}
