package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.ClientWorkHoursJson;
import com.intuiture.corp.service.ClientWorkHoursService;
import com.intuiture.corp.util.TransformDomainToJson;

@Controller
@RequestMapping("/ClientWorkHoursController")
public class ClientWorkHoursController {
	@Autowired
	private ClientWorkHoursService clientWorkHoursService;

	/*
	 * @RequestMapping(value = "/saveClients", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public Boolean saveClients(HttpServletRequest request,
	 * HttpServletResponse response, @RequestBody ClientsJson clientsJson) {
	 * return true; //clientsService.saveClients(clientsJson); }
	 */

	@RequestMapping(value = "/saveClientWorkHours", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveClientworkHours(HttpServletRequest request, HttpServletResponse response, @RequestBody ClientWorkHoursJson clientWorkHoursJson) {
		if (clientWorkHoursJson != null && clientWorkHoursJson.getStrFrom() != null) {
			clientWorkHoursJson.setFrom(TransformDomainToJson.convertDiffferentFormatString(clientWorkHoursJson.getStrFrom()));
		}
		if (clientWorkHoursJson != null && clientWorkHoursJson.getStrTo() != null) {
			clientWorkHoursJson.setTo(TransformDomainToJson.convertDiffferentFormatString(clientWorkHoursJson.getStrTo()));
		}
		return clientWorkHoursService.saveClientworkHours(clientWorkHoursJson);
		// return false;

	}

}
