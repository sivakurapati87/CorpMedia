package com.intuiture.corp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.LookUpDetailJson;
import com.intuiture.corp.service.LookUpService;

@Controller
@RequestMapping("/LookUpController")
public class LookUpController {
	@Autowired
	private LookUpService lookUpService;

	// @RequestMapping(value = "/getAllLookupDetailsByType/{type}", method =
	// RequestMethod.GET)
	// public @ResponseBody List<LookUpDetailJson>
	// getAllLookupDetailsByType(HttpServletRequest request,
	// @PathVariable("type") String type, HttpServletResponse response) {
	// List<LookUpDetailJson> jsonList =
	// lookUpService.getAllLookupDetailsByType(type);
	// return jsonList;
	// }

	@RequestMapping(value = "/getAllLookupDetailsByTypeList", method = RequestMethod.POST)
	public @ResponseBody Map<String, List<LookUpDetailJson>> getAllLookupDetailsByTypeList(HttpServletRequest request, @RequestBody List<String> typesList, HttpServletResponse response) {
		Map<String, List<LookUpDetailJson>> jsonMap = lookUpService.getAllLookupDetailsByTypeList(typesList);
		return jsonMap;
	}

	// @RequestMapping(value = "/getLookUpDetailsByParent/{parent}", method =
	// RequestMethod.GET)
	// public @ResponseBody List<LookUpDetailJson>
	// getLookUpDetailsByParent(HttpServletRequest request, HttpServletResponse
	// response, @PathVariable("parent") Integer parent) {
	// List<LookUpDetailJson> jsonList =
	// lookUpService.getLookUpDetailsByParent(parent);
	// return jsonList;
	// }
	//
	// @RequestMapping(value = "/lookupDetailsByPrevDetailId", method =
	// RequestMethod.GET)
	// public @ResponseBody List<LookUpDetailJson>
	// lookupDetailsByPrevDetailId(HttpServletRequest request,
	// HttpServletResponse response, @RequestParam("type") String type,
	// @RequestParam("detailId") Integer detailId) {
	// List<LookUpDetailJson> jsonList =
	// lookUpService.lookupDetailsByPrevDetailId(type, detailId);
	// return jsonList;
	// }
	//

}
