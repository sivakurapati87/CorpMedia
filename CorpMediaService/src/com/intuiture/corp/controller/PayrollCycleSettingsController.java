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

import com.intuiture.corp.json.PayrollCycleSettingsJson;
import com.intuiture.corp.service.PayrollCycleSettingsService;

@Controller
@RequestMapping("/PayrollCycleSettingsController")
public class PayrollCycleSettingsController {

	@Autowired
	private PayrollCycleSettingsService payrollCycleSettingsService;

	@RequestMapping(value = "/savePayrollCycleSettings", method = RequestMethod.POST)
	@ResponseBody
	public Boolean savePayrollCycleSettings(HttpServletRequest request, HttpServletResponse response, @RequestBody PayrollCycleSettingsJson payrollCycleSettingsJson) {
		return payrollCycleSettingsService.savePayrollCycleSettings(payrollCycleSettingsJson);
	}

	@RequestMapping(value = "/getPayrollCycleSettingsJson/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public PayrollCycleSettingsJson getPayrollCycleSettingsJson(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return payrollCycleSettingsService.getPayrollCycleSettingsJson(companyId);
	}

}
