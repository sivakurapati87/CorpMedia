package com.intuiture.corp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.json.TimeSheetApprovalChainJson;

@Controller
@RequestMapping("/TimeSheetApprovalChainController")
public class TimeSheetApprovalChainController {
	@RequestMapping(value = "/addApproverLevel", method = RequestMethod.POST)
	@ResponseBody
	public List<TimeSheetApprovalChainJson> addApprover(@RequestBody List<TimeSheetApprovalChainJson> timeSheetApprovalChainJsonlist) {
		if (timeSheetApprovalChainJsonlist == null) {
			timeSheetApprovalChainJsonlist = new ArrayList<TimeSheetApprovalChainJson>();
		}
		if (timeSheetApprovalChainJsonlist != null && timeSheetApprovalChainJsonlist.size() != 1) {
			timeSheetApprovalChainJsonlist.add(new TimeSheetApprovalChainJson());
		}
	
		return timeSheetApprovalChainJsonlist;
	}
}
