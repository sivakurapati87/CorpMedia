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

import com.intuiture.corp.json.ESIInfoJson;
import com.intuiture.corp.service.ESIService;
import com.intuiture.corp.util.CorpoMediaUtil;

@Controller
@RequestMapping("/ESIController")
public class ESIController {
	
	@Autowired
	private ESIService esiService;
	
	
	
	@RequestMapping(value = "/findAllCompanyESI/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public ESIInfoJson findAllCompanyESI(HttpServletRequest request, HttpServletResponse response, @PathVariable("companyId") Integer companyId) {
		ESIInfoJson esiInfoJson = esiService.getESIInfo_cmpId(companyId);
		return esiInfoJson;
	}
	
	
	@RequestMapping(value = "/saveOrUpdateESIInfo", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveOrUpdateESIInfo(HttpServletRequest request, HttpServletResponse response, @RequestBody ESIInfoJson esiInfoJson) {
		if (esiInfoJson != null && esiInfoJson.getStrRegistrationDate() != null&&esiInfoJson.getStrRegistrationDate().trim().length()>10) {
			esiInfoJson.setRegistrationDate(CorpoMediaUtil.convertDiffferentFormatString(esiInfoJson.getStrRegistrationDate()));
		}
		return esiService.saveOrUpdateESIInfo(esiInfoJson);
	}

}
