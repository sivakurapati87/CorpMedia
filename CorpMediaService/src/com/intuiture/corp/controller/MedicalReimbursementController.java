package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.MedicalReimbursementJson;
import com.intuiture.corp.service.MedicalReimbursementService;

@Controller
@RequestMapping("/MedicalReimbursementController")
public class MedicalReimbursementController {
	@Autowired
	private MedicalReimbursementService medicalReimbursementService;
	
	@RequestMapping(value = "/saveMedicalReimbursement", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveMedicalReimbursement(HttpServletRequest request, HttpServletResponse response, @RequestBody MedicalReimbursementJson medicalReimbursementJson) {
		return medicalReimbursementService.saveMedicalReimbursement(medicalReimbursementJson);
	}

}
