package com.intuiture.corp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intuiture.corp.service.RecordInsertionService;

@Controller
@RequestMapping("/RecordInsertionController")
public class RecordInsertionController {
	@Autowired
	private RecordInsertionService recordInsertionService;

	@RequestMapping("/insertData")
	public void insertData() {
		recordInsertionService.insertData();
	}
}
