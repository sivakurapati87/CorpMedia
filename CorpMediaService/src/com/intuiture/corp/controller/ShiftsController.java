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

import com.intuiture.corp.json.ShiftsJson;
import com.intuiture.corp.service.ShiftsService;

@Controller
@RequestMapping("/ShiftsController")
public class ShiftsController {
	@Autowired
	private ShiftsService shiftsService;

	@RequestMapping(value = "/saveShift", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveShift(HttpServletRequest request, HttpServletResponse response, @RequestBody ShiftsJson shiftsJson) {
		return shiftsService.saveShift(shiftsJson);
	}

	@RequestMapping(value = "/getAllShiftsList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<ShiftsJson> getAllShiftsList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		 List<ShiftsJson> list1=shiftsService.getAllShiftsList(companyId);
		return list1;
	}

	 @RequestMapping(value = "/deleteShift/{shiftsId}", method = RequestMethod.GET)
	 @ResponseBody
	 public Boolean deleteShift(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer shiftsId) {
	 return shiftsService.deleteShift(shiftsId);
	 }

}
