package com.intuiture.corp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.EmployeeTimeSheetJson;
import com.intuiture.corp.service.EmployeeTimeSheetService;
import com.intuiture.corp.util.MethodUtil;

@Controller
@RequestMapping("/EmployeeTimeSheetController")
public class EmployeeTimeSheetController {
	@Autowired
	private EmployeeTimeSheetService employeeTimeSheetService;

	@RequestMapping(value = "/saveOrUpdateEmployeeTimesheetList", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeTimesheetList(HttpServletRequest request, HttpServletResponse response,
			@RequestBody List<EmployeeTimeSheetJson> employeeTimeSheetJsonList) {
		return employeeTimeSheetService.saveOrUpdateEmployeeTimesheetList(employeeTimeSheetJsonList);
	}

	@RequestMapping(value = "/getEmployeeTimesheetOfTheWeek", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeTimeSheetJson> getEmployeeTimesheetOfTheWeek(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("employeeId") Integer employeeId, @RequestParam("startingWeekDate") String startingWeekDate) {
		return employeeTimeSheetService.getEmployeeTimesheetOfTheWeek(employeeId, MethodUtil.getWeeklyDatesList(startingWeekDate));
	}

	@RequestMapping(value = "/getAllAppliedTimesheetList", method = RequestMethod.GET)
	@ResponseBody
	public Map<Integer, List<EmployeeTimeSheetJson>> getAllAppliedTimesheetList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("companyId") Integer companyId) {
		return employeeTimeSheetService.getAllAppliedTimesheetList(companyId);
	}
	@RequestMapping(value = "/approveOrRejectEmpTimeSheet", method = RequestMethod.POST)
	@ResponseBody
	public Boolean approveOrRejectEmpTimeSheet(HttpServletRequest request, HttpServletResponse response,
			@RequestBody List<EmployeeTimeSheetJson> employeeTimeSheetJsonList) {
		return employeeTimeSheetService.approveOrRejectEmpTimeSheet(employeeTimeSheetJsonList);
	}


}
