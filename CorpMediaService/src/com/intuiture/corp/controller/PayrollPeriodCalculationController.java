package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.PayrollPeriodCalculationJson;
import com.intuiture.corp.service.PayrollPeriodCalculationService;

@Controller
@RequestMapping("/PayrollPeriodCalculationController")
public class PayrollPeriodCalculationController {
	
	@Autowired
	private PayrollPeriodCalculationService payrollPeriodCalculationService;
	
	@RequestMapping(value = "/savePayrollPeriodCalculation", method = RequestMethod.POST)
	@ResponseBody
	public Boolean savePayrollPeriodCalculation(HttpServletRequest request, HttpServletResponse response, @RequestBody PayrollPeriodCalculationJson payrollPeriodCalculationJson) {
		return payrollPeriodCalculationService.savePayrollPeriodCalculation(payrollPeriodCalculationJson);
	}

}
