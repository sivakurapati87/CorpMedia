package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.AllowancesJson;
import com.intuiture.corp.service.AllowancesService;

@Controller
@RequestMapping("/AllowancesController")
public class AllowancesController {
	
	@Autowired
	private AllowancesService allowancesService;
	
	@RequestMapping(value = "/saveAllowances", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveAllowances(HttpServletRequest request, HttpServletResponse response, @RequestBody AllowancesJson allowancesJson) {
		return allowancesService.saveAllowances(allowancesJson);
	}

}
