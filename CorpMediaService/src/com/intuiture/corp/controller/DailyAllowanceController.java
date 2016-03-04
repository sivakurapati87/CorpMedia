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

import com.intuiture.corp.json.DailyAllowanceJson;
import com.intuiture.corp.service.DailyAllowanceService;

@Controller
@RequestMapping("/DailyAllowanceController")
public class DailyAllowanceController {
	
	@Autowired
	private DailyAllowanceService dailyAllowanceService;
	
	@RequestMapping(value = "/saveDailyAllowance", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveDailyAllowance(HttpServletRequest request, HttpServletResponse response, @RequestBody DailyAllowanceJson dailyAllowanceJson) {
		return dailyAllowanceService.saveDailyAllowance(dailyAllowanceJson);
	}
	
	@RequestMapping(value = "/getDailyAllowanceList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public DailyAllowanceJson getDailyAllowanceList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return dailyAllowanceService.getDailyAllowanceList(companyId);
	}

}
