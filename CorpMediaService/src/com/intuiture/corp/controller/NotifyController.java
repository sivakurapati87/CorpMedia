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

import com.intuiture.corp.json.LeavesNotifyJson;
import com.intuiture.corp.service.NotifyService;

@Controller
@RequestMapping("/NotifyController")
public class NotifyController {
	@Autowired
	private NotifyService notifyService;

	@RequestMapping(value = "/addNotify", method = RequestMethod.POST)
	@ResponseBody
	public Boolean addNotify(HttpServletRequest request, HttpServletResponse response, @RequestBody LeavesNotifyJson leavesNotifyJson) {
		return notifyService.addNotify(leavesNotifyJson);
	}

	@RequestMapping(value = "/getAllNotifiersList/{companyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<LeavesNotifyJson> getAllNotifiersList(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer companyId) {
		return notifyService.getAllNotifiersList(companyId);
	}

	@RequestMapping(value = "/deleteNotify/{leavesNotifyId}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean deleteNotify(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer leavesNotifyId) {
		return notifyService.deleteNotify(leavesNotifyId);
	}
}
