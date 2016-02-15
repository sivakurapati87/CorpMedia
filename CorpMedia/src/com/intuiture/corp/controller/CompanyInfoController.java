package com.intuiture.corp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intuiture.corp.bean.CompanyInfoBean;

@Controller
@RequestMapping("/CompanyInfoController")
public class CompanyInfoController {// Serves Data.
	private CompanyInfoBean companyInfoBean = new CompanyInfoBean();

	@RequestMapping(value = "/setSelectedCompany/{selectedCompName}", method = RequestMethod.GET)
	public ResponseEntity<CompanyInfoBean> setSelectedCompany(@PathVariable("selectedCompName") String selectedCompName) {
		companyInfoBean.setSelectedCompName(selectedCompName);
		return new ResponseEntity<CompanyInfoBean>(new CompanyInfoBean(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getSelectedCompany", method = RequestMethod.GET)
	public ResponseEntity<CompanyInfoBean> getSelectedCompany() {
		return new ResponseEntity<CompanyInfoBean>(companyInfoBean, HttpStatus.OK);
	}

}
