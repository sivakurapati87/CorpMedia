package com.intuiture.corp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.ClientsJson;
import com.intuiture.corp.service.ClientsService;

@Controller
@RequestMapping("/ClientsController")
public class ClientsController {
	
	@Autowired
	private ClientsService clientsService;
	
	@RequestMapping(value = "/saveClients", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveClients(HttpServletRequest request, HttpServletResponse response, @RequestBody ClientsJson clientsJson) {
		return clientsService.saveClients(clientsJson);
	}
	
	@RequestMapping(value = "/getAllClientsList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<ClientsJson> getAllClientsList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return clientsService.getAllClientsList(companyId);
	}
	
	@RequestMapping(value = "/deleteClients/{clientsId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteClients(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer clientsId) {
		return clientsService.deleteClients(clientsId);
	}

}
