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

import com.intuiture.corp.json.TravelReimbursementJson;
import com.intuiture.corp.service.TravelReimbursementService;

@Controller
@RequestMapping("/TravelReimbursementController")
public class TravelReimbursementController {
	
	@Autowired
	private TravelReimbursementService travelReimbursementService;
	
	@RequestMapping(value = "/saveTravelReimbursement", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveTravelReimbursement(HttpServletRequest request, HttpServletResponse response, @RequestBody TravelReimbursementJson travelReimbursementJson) {
		return travelReimbursementService.saveTravelReimbursement(travelReimbursementJson);
	}
	
	@RequestMapping(value = "/getTravelReimbursementList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public TravelReimbursementJson getTravelReimbursementList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return travelReimbursementService.getTravelReimbursementList(companyId);
	}

}
