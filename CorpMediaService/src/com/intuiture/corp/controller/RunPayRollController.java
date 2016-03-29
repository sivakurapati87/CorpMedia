package com.intuiture.corp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.EmployeeSalaryInfoJson;
import com.intuiture.corp.json.PayrollCycleSettingsJson;
import com.intuiture.corp.service.RunPayRollService;

@Controller
@RequestMapping("/RunPayRollController")
public class RunPayRollController {

	@Autowired
	private RunPayRollService rollService;

	@RequestMapping(value = "/viewEmployeesPayRollByCompanyId", method = RequestMethod.POST)
	@ResponseBody
	public List<EmployeeSalaryInfoJson> viewEmployeesPayRollByCompanyId(HttpServletRequest request, HttpServletResponse response,
			@RequestBody PayrollCycleSettingsJson payrollCycleSettingsJson) {
		return rollService.viewEmployeesPayRollByCompanyId(payrollCycleSettingsJson);
	}

}
