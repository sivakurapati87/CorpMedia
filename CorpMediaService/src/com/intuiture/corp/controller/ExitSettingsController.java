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

import com.intuiture.corp.json.ExitSettingsJson;
import com.intuiture.corp.service.ExitSettingsService;

@Controller
@RequestMapping("/ExitSettingsController")
public class ExitSettingsController {
	
	@Autowired
	private ExitSettingsService exitSettingsService;
	
	@RequestMapping(value = "/saveExitSettings", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveExitSettings(HttpServletRequest request, HttpServletResponse response, @RequestBody ExitSettingsJson exitSettingsJson) {
		return exitSettingsService.saveExitSettings(exitSettingsJson);
	}
	
	@RequestMapping(value = "/getAllExitSettingsList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<ExitSettingsJson> getAllExitSettingsList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return exitSettingsService.getAllExitSettingsList(companyId);
	}
	
	@RequestMapping(value = "/deleteExitSettings/{exitSettingsId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteExitSettings(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer exitSettingsId) {
		return exitSettingsService.deleteExitSettings(exitSettingsId);
	}

}
