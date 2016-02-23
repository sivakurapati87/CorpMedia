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

import com.intuiture.corp.json.EmployeeEducationalInfoJson;
import com.intuiture.corp.json.EmployeeExperienceInfoJson;
import com.intuiture.corp.json.EmployeeFamilyInfoJson;
import com.intuiture.corp.json.EmployeeJson;
import com.intuiture.corp.json.EmployeePersonalInfoJson;
import com.intuiture.corp.json.EmployeeProfessionalInfoJson;
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

	@RequestMapping(value = "/saveOrUpdateEmployeePersonalInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeePersonalInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeePersonalInfoJson employeePersonalInfoJson) {
		if (employeePersonalInfoJson != null && employeePersonalInfoJson.getStrDateOfBirth() != null) {
			employeePersonalInfoJson.setDateOfBirth(TransformDomainToJson.convertDiffferentFormatString(employeePersonalInfoJson.getStrDateOfBirth()));
		}
		return employeeService.saveOrUpdateEmployeePersonalInfo(employeePersonalInfoJson);
	}

	@RequestMapping(value = "/saveOrUpdateEmployeeFamilyInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeFamilyInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeFamilyInfoJson employeeFamilyInfoJson) {
		return employeeService.saveOrUpdateEmployeeFamilyInfo(employeeFamilyInfoJson);
	}

	@RequestMapping(value = "/getAllEmployeeFamilyList/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeFamilyInfoJson> getAllEmployeeFamilyList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeId) {
		return employeeService.getAllEmployeeFamilyList(employeeId);
	}

	@RequestMapping(value = "/deleteEmployeeFamilyInfo/{departmentId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteEmployeeFamilyInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeFamilyInfoId) {
		return employeeService.deleteEmployeeFamilyInfo(employeeFamilyInfoId);
	}

	@RequestMapping(value = "/getEmployeePersonalInfo/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public EmployeePersonalInfoJson getEmployeePersonalInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeId) {
		return employeeService.getEmployeePersonalInfo(employeeId);
	}

	@RequestMapping(value = "/saveOrUpdateEmployeeProfessionalInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeProfessionalInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeProfessionalInfoJson employeeProfessionalInfoJson) {
		return employeeService.saveOrUpdateEmployeeProfessionalInfo(employeeProfessionalInfoJson);
	}

	@RequestMapping(value = "/saveOrUpdateEmployeeExperienceInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeExperienceInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeExperienceInfoJson employeeExperienceInfoJson) {
		if (employeeExperienceInfoJson != null && employeeExperienceInfoJson.getStrFromDate() != null && employeeExperienceInfoJson.getStrToDate() != null) {
			employeeExperienceInfoJson.setFromDate(TransformDomainToJson.convertDiffferentFormatString(employeeExperienceInfoJson.getStrFromDate()));
			employeeExperienceInfoJson.setToDate(TransformDomainToJson.convertDiffferentFormatString(employeeExperienceInfoJson.getStrToDate()));
		}
		return employeeService.saveOrUpdateEmployeeExperienceInfo(employeeExperienceInfoJson);
	}

	@RequestMapping(value = "/saveOrUpdateEmployeeEducationalInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeEducationalInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeEducationalInfoJson employeeEducationalInfoJson) {
		if (employeeEducationalInfoJson != null && employeeEducationalInfoJson.getStrFromDate() != null && employeeEducationalInfoJson.getStrToDate() != null) {
			employeeEducationalInfoJson.setFromDate(TransformDomainToJson.convertDiffferentFormatString(employeeEducationalInfoJson.getStrFromDate()));
			employeeEducationalInfoJson.setToDate(TransformDomainToJson.convertDiffferentFormatString(employeeEducationalInfoJson.getStrToDate()));
		}
		return employeeService.saveOrUpdateEmployeeEducationalInfo(employeeEducationalInfoJson);
	}

	@RequestMapping(value = "/getEmployeeProfessionalInfo/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public EmployeeProfessionalInfoJson getEmployeeProfessionalInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeId) {
		return employeeService.getEmployeeProfessionalInfo(employeeId);
	}

	@RequestMapping(value = "/getEmployeeExperienceInfo/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeExperienceInfoJson> getEmployeeExperienceInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeId) {
		return employeeService.getEmployeeExperienceInfo(employeeId);
	}

	@RequestMapping(value = "/getEmployeeEducationalInfo/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeEducationalInfoJson> getEmployeeEducationalInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeId) {
		return employeeService.getEmployeeEducationalInfo(employeeId);
	}
	@RequestMapping(value = "/deleteEmployeeExperienceInfo/{departmentId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteEmployeeExperienceInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeExperienceId) {
		return employeeService.deleteEmployeeExperienceInfo(employeeExperienceId);
	}

}
