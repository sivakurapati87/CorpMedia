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

	@RequestMapping(value = "/saveOrUpdateEmployeeLeaves", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeLeaves(HttpServletRequest request, HttpServletResponse response,
			@RequestBody EmployeeLeaveJson employeeLeaveJson) {
		if (employeeLeaveJson != null) {
			if (employeeLeaveJson != null && employeeLeaveJson.getStrLeaveStartDate() != null) {
				employeeLeaveJson.setLeaveStartDate(MethodUtil.convertDiffferentFormatString(employeeLeaveJson.getStrLeaveStartDate()));
			}
			if (employeeLeaveJson != null && employeeLeaveJson.getStrLeaveEndDate() != null) {
				employeeLeaveJson.setLeaveEndDate(MethodUtil.convertDiffferentFormatString(employeeLeaveJson.getStrLeaveEndDate()));
			}
			return employeeLeaveService.saveOrUpdateEmployeeLeaves(employeeLeaveJson,
					MethodUtil.getWeeklyDatesByAnyStartDate(employeeLeaveJson.getLeaveStartDate()));
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/getEmployeeLeavesOfTheWeek", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeLeaveJson> getEmployeeLeavesOfTheWeek(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("employeeId") Integer employeeId, @RequestParam("startingWeekDate") String startingWeekDate) {
		return employeeLeaveService.getEmployeeLeavesOfTheWeek(employeeId, MethodUtil.getWeeklyDatesList(startingWeekDate));
	}

	@RequestMapping(value = "/getAllAppliedLeavesByCompany", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeLeaveJson> getAllAppliedLeavesByCompany(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("companyId") Integer companyId) {
		return employeeLeaveService.getAllAppliedLeavesByCompany(companyId);
	}

	@RequestMapping(value = "/approveOrRejectAppliedLeaves", method = RequestMethod.POST)
	@ResponseBody
	public Boolean approveOrRejectAppliedLeaves(HttpServletRequest request, HttpServletResponse response,
			@RequestBody EmployeeLeaveJson employeeLeaveJson) {
		if (employeeLeaveJson != null) {
			return employeeLeaveService.approveOrRejectAppliedLeaves(employeeLeaveJson);
		} else {
			return false;
		}
	}
}
