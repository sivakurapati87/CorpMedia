package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.BonusesJson;
import com.intuiture.corp.service.BonusesService;

@Controller
@RequestMapping("/BonusesController")
public class BonusesController {
	
	@Autowired
	private BonusesService bonusesService;
	
	@RequestMapping(value = "/saveBonuses", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveBonuses(HttpServletRequest request, HttpServletResponse response, @RequestBody BonusesJson bonusesJson) {
		return bonusesService.saveBonuses(bonusesJson);
	}

}
