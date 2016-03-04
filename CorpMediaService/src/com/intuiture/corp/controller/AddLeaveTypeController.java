package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.AddLeaveTypeJson;
import com.intuiture.corp.service.AddLeaveTypeService;

@Controller
@RequestMapping("/AddLeaveTypeController")
public class AddLeaveTypeController {

	@Autowired
	private AddLeaveTypeService addLeaveTypeService;

	@RequestMapping(value = "/addLeaveType", method = RequestMethod.POST)
	@ResponseBody
	public Boolean addLeaveType(HttpServletRequest request, HttpServletResponse response, @RequestBody AddLeaveTypeJson addLeaveTypeJson) {
		return addLeaveTypeService.addLeaveType(addLeaveTypeJson);
	}

//	@RequestMapping(value = "/getAllJobTitlesList/{companyId}", method = RequestMethod.GET)
//	@ResponseBody
//	public List<JobTitlesJson> getAllJobTitlesList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
//		return addLeaveTypeService.getAllJobTitlesList(companyId);
//	}
//
//	@RequestMapping(value = "/deleteJobTitle/{departmentId}", method = RequestMethod.GET)
//	@ResponseBody
//	public Boolean deleteJobTitle(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer departmentId) {
//		return addLeaveTypeService.deleteJobTitle(departmentId);
//	}
}
