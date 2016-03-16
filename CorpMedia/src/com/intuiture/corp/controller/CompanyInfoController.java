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

	@RequestMapping(value = "/setSelectedCompanyId/{companyId}", method = RequestMethod.GET)
	public ResponseEntity<CompanyInfoBean> setSelectedCompanyId(@PathVariable("companyId") Integer companyId) {
		companyInfoBean.setCompanyId(companyId);
		return new ResponseEntity<CompanyInfoBean>(new CompanyInfoBean(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getSelectedCompanyId", method = RequestMethod.GET)
	public ResponseEntity<CompanyInfoBean> getSelectedCompanyId() {
		return new ResponseEntity<CompanyInfoBean>(companyInfoBean, HttpStatus.OK);
	}

}
