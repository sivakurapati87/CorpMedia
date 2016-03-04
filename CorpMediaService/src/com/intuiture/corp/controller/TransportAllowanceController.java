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

import com.intuiture.corp.json.TransportAllowanceJson;
import com.intuiture.corp.service.TransportAllowanceService;

@Controller
@RequestMapping("/TransportAllowanceController")
public class TransportAllowanceController {

	@Autowired
	private TransportAllowanceService transportAllowanceService;
	
	@RequestMapping(value = "/saveTransportAllowance", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveTransportAllowance(HttpServletRequest request, HttpServletResponse response, @RequestBody TransportAllowanceJson transportAllowanceJson) {
		return transportAllowanceService.saveTransportAllowance(transportAllowanceJson);
	}
	
	@RequestMapping(value = "/getTransportAllowanceList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public TransportAllowanceJson getTransportAllowanceList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return transportAllowanceService.getTransportAllowanceList(companyId);
	}
}
