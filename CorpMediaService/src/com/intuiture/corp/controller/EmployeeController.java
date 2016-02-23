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

import com.intuiture.corp.json.EmployeeJson;
import com.intuiture.corp.service.EmployeeService;
import com.intuiture.corp.util.TransformDomainToJson;

@Controller
@RequestMapping("/EmployeeController")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/saveOrUpdateEmployee", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployee(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeJson employeeJson) {
		if (employeeJson != null && employeeJson.getStrDateOfJoining() != null) {
			employeeJson.setDateOfJoining(TransformDomainToJson.convertDiffferentFormatString(employeeJson.getStrDateOfJoining()));
		}
		return employeeService.saveOrUpdateEmployee(employeeJson);
	}

	@RequestMapping(value = "/getAllEmployeesByCompanyId/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeJson> getAllEmployeesByCompanyId(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return employeeService.getAllEmployeesByCompanyId(companyId);
	}
}