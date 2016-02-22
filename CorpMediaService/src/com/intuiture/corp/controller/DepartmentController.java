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

import com.intuiture.corp.json.DepartmentJson;
import com.intuiture.corp.service.DepartmentService;

@Controller
@RequestMapping("/DepartmentController")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveDepartment(HttpServletRequest request, HttpServletResponse response, @RequestBody DepartmentJson departmentJson) {
		return departmentService.saveDepartment(departmentJson);
	}

	@RequestMapping(value = "/getAllDepartmentsList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<DepartmentJson> getAllDepartmentsList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return departmentService.getAllDepartmentsList(companyId);
	}

	@RequestMapping(value = "/deleteCompanyDepartment/{departmentId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteCompanyDepartment(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer departmentId) {
		return departmentService.deleteCompanyDepartment(departmentId);
	}
}
