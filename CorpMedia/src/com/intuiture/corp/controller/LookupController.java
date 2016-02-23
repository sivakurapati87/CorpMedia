package com.intuiture.corp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.corp.bean.LookupBean;
import com.intuiture.corp.json.LookUpDetailJson;
import com.intuiture.corp.util.CommonUtil;
import com.intuiture.corp.util.Constants;

@Controller
@RequestMapping("/LookUpController")
public class LookupController {

	@RequestMapping(value = "/lookupInit")
	@ResponseBody
	public LookupBean lookupInit() {
		LookupBean lookupBean = new LookupBean();
		String[] lookUpTypes = { Constants.TYPEOFBUSINESS, Constants.BANKS, Constants.STATES, Constants.DMW, Constants.WORKERTYPE, Constants.TIMETYPE, Constants.GENDER, Constants.MARITALSTATUS, Constants.BLOODGROUP, Constants.RELATION };
		List<String> typesList = Arrays.asList(lookUpTypes);
		Map<String, List<LookUpDetailJson>> lookUpMap = CommonUtil.getLookupDetailsListByTypeList(Constants.LookUp.GETLOOKUPDETAILSBYTYPELIST, typesList);
		lookupBean.setBanksList(lookUpMap.get(Constants.BANKS));
		lookupBean.setTypeOfBusinessList(lookUpMap.get(Constants.TYPEOFBUSINESS));
		lookupBean.setStatesList(lookUpMap.get(Constants.STATES));
		lookupBean.setDaysWeeksMonthsList(lookUpMap.get(Constants.DMW));
		lookupBean.setWorkerTypeList(lookUpMap.get(Constants.WORKERTYPE));
		lookupBean.setTimeTypeList(lookUpMap.get(Constants.TIMETYPE));
		lookupBean.setGenderList(lookUpMap.get(Constants.GENDER));
		lookupBean.setMaritalStatusList(lookUpMap.get(Constants.MARITALSTATUS));
		lookupBean.setBloodGroupList(lookUpMap.get(Constants.BLOODGROUP));
		lookupBean.setRelationsList(lookUpMap.get(Constants.RELATION));
		return lookupBean;
	}
}
