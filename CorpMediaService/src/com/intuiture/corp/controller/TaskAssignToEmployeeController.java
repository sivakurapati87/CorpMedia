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

import com.intuiture.corp.json.TaskAssignToEmployeeJson;
import com.intuiture.corp.service.TaskAssignToEmployeeService;

@Controller
@RequestMapping("/TaskAssignToEmployeeController")
public class TaskAssignToEmployeeController {
	
	@Autowired
	private TaskAssignToEmployeeService taskAssignToEmployeeService;

	@RequestMapping(value = "/saveTaskAssignToEmployee", method = RequestMethod.POST)
	@ResponseBody
	public Boolean saveTaskAssignToEmployee(HttpServletRequest request, HttpServletResponse response, @RequestBody TaskAssignToEmployeeJson taskAssignToEmployeeJson) {
		return taskAssignToEmployeeService.saveTaskAssignToEmployee(taskAssignToEmployeeJson);
	}
	
	@RequestMapping(value = "/getAllTaskAssignToEmployeeList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<TaskAssignToEmployeeJson> getAllTaskAssignToEmployeeList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return taskAssignToEmployeeService.getAllTaskAssignToEmployeeList(companyId);
	}
	
	@RequestMapping(value = "/deleteTaskAssignToEmployee/{taskAssignToEmployeeId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteTaskAssignToEmployee(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer taskAssignToEmployeeId) {
		return taskAssignToEmployeeService.deleteTaskAssignToEmployee(taskAssignToEmployeeId);
	}

}
