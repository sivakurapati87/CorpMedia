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

import com.intuiture.corp.json.DeptWorkHoursJson;
import com.intuiture.corp.service.DeptWorkHoursService;
import com.intuiture.corp.util.MethodUtil;

@Controller
@RequestMapping("/DeptWorkHoursController")
public class DeptWorkHoursController {
	@Autowired
	private DeptWorkHoursService deptWorkHoursService;

	@RequestMapping(value = "/saveDeptWorkHours", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveDeptWorkHours(HttpServletRequest request, HttpServletResponse response, @RequestBody DeptWorkHoursJson deptWorkHoursJson) {
		if (deptWorkHoursJson != null && deptWorkHoursJson.getStrFrom() != null) {
			deptWorkHoursJson.setFrom(MethodUtil.convertDiffferentFormatString(deptWorkHoursJson.getStrFrom()));
		}
		if (deptWorkHoursJson != null && deptWorkHoursJson.getStrTo() != null) {
			deptWorkHoursJson.setTo(MethodUtil.convertDiffferentFormatString(deptWorkHoursJson.getStrTo()));
		}
		return deptWorkHoursService.saveDeptWorkHours(deptWorkHoursJson);
	}

	@RequestMapping(value = "/getAllDeptWorkHoursList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<DeptWorkHoursJson> getAllDeptWorkHoursList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {

		return deptWorkHoursService.getAllDeptWorkHoursList(companyId);

	}

	@RequestMapping(value = "/deleteDeptWorkHours/{deptWorkHourId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteDeptWorkHours(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer deptWorkHourId) {
		return deptWorkHoursService.deleteDeptWorkHours(deptWorkHourId);
	}

}
