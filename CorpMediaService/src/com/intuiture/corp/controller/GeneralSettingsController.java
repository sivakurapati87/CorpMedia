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

import com.intuiture.corp.json.GeneralSettingsJson;
import com.intuiture.corp.service.GeneralSettingsService;

@Controller
@RequestMapping("/GeneralSettingsController")
public class GeneralSettingsController {
	@Autowired
	private GeneralSettingsService generalSettingsService;

	@RequestMapping(value = "/saveGeneralSettings", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveGeneralSettings(HttpServletRequest request, HttpServletResponse response, @RequestBody GeneralSettingsJson generalSettingsJson) {
		return generalSettingsService.saveGeneralSettings(generalSettingsJson);
	}

	@RequestMapping(value = "/getCompanyGeneralSetting/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public GeneralSettingsJson getCompanyGeneralSetting(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return generalSettingsService.getCompanyGeneralSetting(companyId);
	}
}
