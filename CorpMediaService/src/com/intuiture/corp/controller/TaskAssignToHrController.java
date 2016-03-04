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

import com.intuiture.corp.json.TaskAssignToHrJson;
import com.intuiture.corp.service.TaskAssignToHrService;

@Controller
@RequestMapping("/TaskAssignToHrController")
public class TaskAssignToHrController {
	
	@Autowired
	private TaskAssignToHrService taskAssignToHrService;

	@RequestMapping(value = "/saveTaskAssignToHr", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveTaskAssignToHr(HttpServletRequest request, HttpServletResponse response, @RequestBody TaskAssignToHrJson taskAssignToHrJson) {
		return taskAssignToHrService.saveTaskAssignToHr(taskAssignToHrJson);
	}
	
	@RequestMapping(value = "/getAllTaskAssignToHrList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<TaskAssignToHrJson> getAllTaskAssignToHrList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return taskAssignToHrService.getAllTaskAssignToHrList(companyId);
	}
	
	@RequestMapping(value = "/deleteTaskAssignToHr/{taskAssignToHrId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteTaskAssignToHr(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer taskAssignToHrId) {
		return taskAssignToHrService.deleteTaskAssignToHr(taskAssignToHrId);
	}

	
	

}
