package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.ReimbursementJson;
import com.intuiture.corp.service.ReimbursementService;

@Controller
@RequestMapping("/ReimbursementController")
public class ReimbursementController {
	
	@Autowired
	private ReimbursementService reimbursementService;
	
	@RequestMapping(value = "/saveReimbursement", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveReimbursement(HttpServletRequest request, HttpServletResponse response, @RequestBody ReimbursementJson reimbursementJson) {
		return reimbursementService.saveReimbursement(reimbursementJson);
	}

}
