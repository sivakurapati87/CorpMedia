package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.DeductionsJson;
import com.intuiture.corp.service.DeductionsService;

@Controller
@RequestMapping("/DeductionsController")
public class DeductionsController {
	
	@Autowired
	private DeductionsService deductionsService;
	
	@RequestMapping(value = "/saveDeductions", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveDeductions(HttpServletRequest request, HttpServletResponse response, @RequestBody DeductionsJson deductionsJson) {
		return deductionsService.saveDeductions(deductionsJson);
	}

}