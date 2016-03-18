package com.intuiture.corp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.EmployeeLeaveJson;
import com.intuiture.corp.service.EmployeeLeaveService;
import com.intuiture.corp.util.MethodUtil;

@Controller
@RequestMapping("/EmployeeLeaveController")
public class EmployeeLeaveController {
	@Autowired
	private EmployeeLeaveService employeeLeaveService;

	@RequestMapping(value = "/saveOrUpdateEmployeeLeavesList", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeTimesheetList(HttpServletRequest request, HttpServletResponse response, @RequestBody List<EmployeeLeaveJson> employeeLeaveJsonList) {
		return employeeLeaveService.saveOrUpdateEmployeeLeavesList(employeeLeaveJsonList);
	}

	@RequestMapping(value = "/getEmployeeLeavesOfTheWeek", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeLeaveJson> getEmployeeLeavesOfTheWeek(HttpServletRequest request, HttpServletResponse response, @RequestParam("employeeId") Integer employeeId, @RequestParam("startingWeekDate") String startingWeekDate) {
		return employeeLeaveService.getEmployeeLeavesOfTheWeek(employeeId, MethodUtil.getWeeklyDatesList(startingWeekDate));
	}

}
