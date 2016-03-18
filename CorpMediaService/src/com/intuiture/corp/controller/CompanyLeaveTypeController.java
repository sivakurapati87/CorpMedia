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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.CompanyLeaveTypeJson;
import com.intuiture.corp.service.CompanyLeaveTypeService;

@Controller
@RequestMapping("/CompanyLeaveTypeController")
public class CompanyLeaveTypeController {

	@Autowired
	private CompanyLeaveTypeService companyLeaveTypeService;

	@RequestMapping(value = "/saveCompanyLeaveType", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveCompanyLeaveType(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CompanyLeaveTypeJson companyLeaveTypeJson) {
		return companyLeaveTypeService.saveCompanyLeaveType(companyLeaveTypeJson);
	}

	@RequestMapping(value = "/getAllCompanyLeaveTypeList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<CompanyLeaveTypeJson> getAllCompanyLeaveTypeList(HttpServletRequest request, HttpServletResponse response,
			@PathVariable Integer companyId) {
		return companyLeaveTypeService.getAllCompanyLeaveTypeList(companyId);
	}

	@RequestMapping(value = "/getAllLeaveTypeListByCmpIdAndGenderId", method = RequestMethod.GET)
	@ResponseBody
	public List<CompanyLeaveTypeJson> getAllLeaveTypeListByCmpIdAndGenderId(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("companyId") Integer companyId, @RequestParam("genderId") Integer genderId) {
		return companyLeaveTypeService.getAllLeaveTypeListByCmpIdAndGenderId(companyId, genderId);
	}

	@RequestMapping(value = "/deleteCompanyLeaveType/{companyLeaveTypeId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteCompanyLeaveType(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyLeaveTypeId) {
		return companyLeaveTypeService.deleteCompanyLeaveType(companyLeaveTypeId);
	}
}
