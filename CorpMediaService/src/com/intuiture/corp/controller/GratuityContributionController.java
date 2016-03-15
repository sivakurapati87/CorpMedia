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

import com.intuiture.corp.json.GratuityContributionJson;
import com.intuiture.corp.service.GratuityContributionService;

@Controller
@RequestMapping("/GratuityContributionController")
public class GratuityContributionController {

	@Autowired
	private GratuityContributionService gratuityContributionService;

	@RequestMapping(value = "/saveGratuityContribution", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveGratuityContribution(HttpServletRequest request, HttpServletResponse response, @RequestBody GratuityContributionJson gratuityContributionJson) {
		return gratuityContributionService.saveGratuityContribution(gratuityContributionJson);
	}

	@RequestMapping(value = "/getGratuityContributionJson/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public GratuityContributionJson getGratuityContributionJson(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return gratuityContributionService.getGratuityContributionJson(companyId);
	}
}
