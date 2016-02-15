package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.PFInfoJson;
import com.intuiture.corp.service.PFService;
import com.intuiture.corp.util.CorpoMediaUtil;

@Controller
@RequestMapping("/PFController")
public class PFController {
	@Autowired
	private PFService pfService;

	@RequestMapping(value = "/findAllCompanyPF/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public PFInfoJson findAllCompanyPF(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Integer companyId) {
		PFInfoJson pfInfoJson = pfService.getPFInfo_cmpId(companyId);
		return pfInfoJson;
	}

	@RequestMapping(value = "/saveOrUpdatePFInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdatePFInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody PFInfoJson pfInfoJson) {
		if (pfInfoJson != null && pfInfoJson.getStrRegistrationDate() != null&&pfInfoJson.getStrRegistrationDate().trim().length()>10) {
			pfInfoJson.setRegistrationDate(CorpoMediaUtil.convertDiffferentFormatString(pfInfoJson.getStrRegistrationDate()));
		}
		return pfService.saveOrUpdatePFInfo(pfInfoJson);
	}
}
