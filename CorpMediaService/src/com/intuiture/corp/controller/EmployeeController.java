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
import com.intuiture.corp.json.EmployeeOneTimeComponentJson;
import com.intuiture.corp.json.EmployeePersonalInfoJson;
import com.intuiture.corp.json.EmployeeProfessionalInfoJson;
import com.intuiture.corp.json.EmployeeProjectJson;
import com.intuiture.corp.json.EmployeeSalaryInfoJson;
import com.intuiture.corp.service.EmployeeService;
import com.intuiture.corp.util.MethodUtil;

@Controller
@RequestMapping("/EmployeeController")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/getAllEmployeesByCompanyId/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeJson> getAllEmployeesByCompanyId(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return employeeService.getAllEmployeesByCompanyId(companyId);
	}

	@RequestMapping(value = "/getAllEmployeeFamilyList/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeFamilyInfoJson> getAllEmployeeFamilyList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeId) {
		return employeeService.getAllEmployeeFamilyList(employeeId);
	}

	@RequestMapping(value = "/getEmployeePersonalInfo/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public EmployeePersonalInfoJson getEmployeePersonalInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeId) {
		return employeeService.getEmployeePersonalInfo(employeeId);
	}

	@RequestMapping(value = "/getEmployeeSalaryInfo/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public EmployeeSalaryInfoJson getEmployeeSalaryInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeId) {
		return employeeService.getEmployeeSalaryInfo(employeeId);
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

	@RequestMapping(value = "/getEmployeeOneTimeComponent/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeOneTimeComponentJson> getEmployeeOneTimeComponent(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeId) {
		return employeeService.getEmployeeOneTimeComponent(employeeId);
	}

	@RequestMapping(value = "/getEmployeeProjects/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeProjectJson> getEmployeeProjects(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeId) {
		return employeeService.getEmployeeProjects(employeeId);
	}

	@RequestMapping(value = "/saveOrUpdateEmployeeProfessionalInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeProfessionalInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeProfessionalInfoJson employeeProfessionalInfoJson) {
		return employeeService.saveOrUpdateEmployeeProfessionalInfo(employeeProfessionalInfoJson);
	}

	@RequestMapping(value = "/saveOrUpdateEmployeeSalaryInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeSalaryInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeSalaryInfoJson employeeSalaryInfoJson) {
		if (employeeSalaryInfoJson != null && employeeSalaryInfoJson.getStrEffectiveFrom() != null) {
			employeeSalaryInfoJson.setEffectiveFrom(MethodUtil.convertDiffferentFormatString(employeeSalaryInfoJson.getStrEffectiveFrom()));
		}
		return employeeService.saveOrUpdateEmployeeSalaryInfo(employeeSalaryInfoJson);
	}

	@RequestMapping(value = "/saveOrUpdateEmployeeOneTimeComponent", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeOneTimeComponent(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeOneTimeComponentJson employeeOneTimeComponentJson) {
		if (employeeOneTimeComponentJson != null && employeeOneTimeComponentJson.getStrMonthPayable() != null) {
			employeeOneTimeComponentJson.setMonthPayable(MethodUtil.convertDiffferentFormatString(employeeOneTimeComponentJson.getStrMonthPayable()));
		}
		return employeeService.saveOrUpdateEmployeeOneTimeComponent(employeeOneTimeComponentJson);
	}

	@RequestMapping(value = "/saveOrUpdateEmployeeExperienceInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeExperienceInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeExperienceInfoJson employeeExperienceInfoJson) {
		if (employeeExperienceInfoJson != null && employeeExperienceInfoJson.getStrFromDate() != null && employeeExperienceInfoJson.getStrToDate() != null) {
			employeeExperienceInfoJson.setFromDate(MethodUtil.convertDiffferentFormatString(employeeExperienceInfoJson.getStrFromDate()));
			employeeExperienceInfoJson.setToDate(MethodUtil.convertDiffferentFormatString(employeeExperienceInfoJson.getStrToDate()));
		}
		return employeeService.saveOrUpdateEmployeeExperienceInfo(employeeExperienceInfoJson);
	}

	@RequestMapping(value = "/saveOrUpdateEmployeeEducationalInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeEducationalInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeEducationalInfoJson employeeEducationalInfoJson) {
		if (employeeEducationalInfoJson != null && employeeEducationalInfoJson.getStrFromDate() != null && employeeEducationalInfoJson.getStrToDate() != null) {
			employeeEducationalInfoJson.setFromDate(MethodUtil.convertDiffferentFormatString(employeeEducationalInfoJson.getStrFromDate()));
			employeeEducationalInfoJson.setToDate(MethodUtil.convertDiffferentFormatString(employeeEducationalInfoJson.getStrToDate()));
		}
		return employeeService.saveOrUpdateEmployeeEducationalInfo(employeeEducationalInfoJson);
	}

	@RequestMapping(value = "/saveOrUpdateEmployee", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployee(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeJson employeeJson) {
		if (employeeJson != null && employeeJson.getStrDateOfJoining() != null) {
			employeeJson.setDateOfJoining(MethodUtil.convertDiffferentFormatString(employeeJson.getStrDateOfJoining()));
		}
		return employeeService.saveOrUpdateEmployee(employeeJson);
	}

	@RequestMapping(value = "/saveOrUpdateEmployeePersonalInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeePersonalInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeePersonalInfoJson employeePersonalInfoJson) {
		if (employeePersonalInfoJson != null && employeePersonalInfoJson.getStrDateOfBirth() != null) {
			employeePersonalInfoJson.setDateOfBirth(MethodUtil.convertDiffferentFormatString(employeePersonalInfoJson.getStrDateOfBirth()));
		}
		return employeeService.saveOrUpdateEmployeePersonalInfo(employeePersonalInfoJson);
	}

	@RequestMapping(value = "/saveOrUpdateEmployeeFamilyInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeFamilyInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeFamilyInfoJson employeeFamilyInfoJson) {
		return employeeService.saveOrUpdateEmployeeFamilyInfo(employeeFamilyInfoJson);
	}

	@RequestMapping(value = "/saveOrUpdateEmployeeProject", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateEmployeeProject(HttpServletRequest request, HttpServletResponse response, @RequestBody EmployeeProjectJson employeeProjectJson) {
		return employeeService.saveOrUpdateEmployeeProject(employeeProjectJson);
	}

	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteEmployee(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}

	@RequestMapping(value = "/deleteEmployeeFamilyInfo/{departmentId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteEmployeeFamilyInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeFamilyInfoId) {
		return employeeService.deleteEmployeeFamilyInfo(employeeFamilyInfoId);
	}

	@RequestMapping(value = "/deleteEmployeeExperienceInfo/{departmentId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteEmployeeExperienceInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeExperienceId) {
		return employeeService.deleteEmployeeExperienceInfo(employeeExperienceId);
	}

	@RequestMapping(value = "/deleteEmployeeOneTimeComponent/{employeeOneTimeComponentId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteEmployeeOneTimeComponent(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeOneTimeComponentId) {
		return employeeService.deleteEmployeeOneTimeComponent(employeeOneTimeComponentId);
	}

	@RequestMapping(value = "/deleteEmployeeProject/{employeeProjectId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteEmployeeProject(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer employeeProjectId) {
		return employeeService.deleteEmployeeProject(employeeProjectId);
	}

}
