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

import com.intuiture.corp.json.HolidaysJson;
import com.intuiture.corp.service.HolidayService;
import com.intuiture.corp.util.TransformDomainToJson;

@Controller
@RequestMapping("/HolidayController")
public class HolidayController {
	@Autowired
	private HolidayService holidayService;

	@RequestMapping(value = "/saveHoliday", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveHoliday(HttpServletRequest request, HttpServletResponse response, @RequestBody HolidaysJson holidaysJson) {
		if (holidaysJson != null && holidaysJson.getStrHolidayDate() != null) {
			holidaysJson.setHolidayDate(TransformDomainToJson.convertDiffferentFormatString(holidaysJson.getStrHolidayDate()));
		}
		return holidayService.saveHoliday(holidaysJson);
	}

	@RequestMapping(value = "/getAllHolidaysList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<HolidaysJson> getAllHolidaysList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return holidayService.getAllHolidaysList(companyId);
	}

	@RequestMapping(value = "/deleteHoliday/{holidayId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteHoliday(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer holidayId) {
		return holidayService.deleteHoliday(holidayId);
	}
}
