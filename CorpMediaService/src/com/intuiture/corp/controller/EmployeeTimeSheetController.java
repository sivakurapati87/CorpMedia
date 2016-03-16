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

import com.intuiture.corp.json.EmployeeJson;
import com.intuiture.corp.json.EmployeeTimeSheetJson;
import com.intuiture.corp.service.EmployeeTimeSheetService;
import com.intuiture.corp.util.TransformDomainToJson;

@Controller
@RequestMapping("/EmployeeTimeSheetController")
public class EmployeeTimeSheetController {
	@Autowired
	private EmployeeTimeSheetService employeeTimeSheetService;

	@RequestMapping(value = "/saveOrUpdateEmployee", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployee(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeJson employeeJson) {
		if (employeeJson != null && employeeJson.getStrDateOfJoining() != null) {
			employeeJson.setDateOfJoining(TransformDomainToJson.convertDiffferentFormatString(employeeJson.getStrDateOfJoining()));
		}
		return employeeTimeSheetService.saveOrUpdateEmployee(employeeJson);
	}

	@RequestMapping(value = "/getEmployeeTimesheetOfTheWeek", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeTimeSheetJson> getEmployeeTimesheetOfTheWeek(HttpServletRequest request, HttpServletResponse response, @RequestParam("employeeId") Integer employeeId, @RequestParam("startingWeekDate") String startingWeekDate) {
		return employeeTimeSheetService.getEmployeeTimesheetOfTheWeek(employeeId, TransformDomainToJson.getWeeklyDatesList(startingWeekDate));
	}

}
