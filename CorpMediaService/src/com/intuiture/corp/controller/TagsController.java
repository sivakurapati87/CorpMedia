package com.intuiture.corp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.TagsJson;
import com.intuiture.corp.service.TagsService;

@Controller
@RequestMapping("/TagsController")
public class TagsController {
	
	@Autowired
	private TagsService tagsService;
	
	@RequestMapping(value = "/saveTags", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveTags(HttpServletRequest request, HttpServletResponse response, @RequestBody TagsJson tagsJson) {
		return tagsService.saveTags(tagsJson);
	}

}
