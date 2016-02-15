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

import com.intuiture.corp.json.ITInfoJson;
import com.intuiture.corp.service.ITService;

@Controller
@RequestMapping("/ITController")
public class ITController {

	@Autowired
	private ITService itService;
	
	@RequestMapping(value = "/findAllCompanyIT/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public ITInfoJson findAllCompanyPF(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Integer companyId) {
		ITInfoJson itInfoJson = itService.getITInfo_cmpId(companyId);
		return itInfoJson;
	}
	
	
	@RequestMapping(value = "/saveOrUpdateITInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateITInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody ITInfoJson itInfoJson) {
		
		return itService.saveOrUpdateITInfo(itInfoJson);
	}
}
