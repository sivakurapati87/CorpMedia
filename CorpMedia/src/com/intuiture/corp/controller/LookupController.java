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
		String[] lookUpTypes = { Constants.TYPEOFBUSINESS, Constants.BANKS, Constants.STATES };
		List<String> typesList = Arrays.asList(lookUpTypes);
		Map<String, List<LookUpDetailJson>> lookUpMap = CommonUtil.getLookupDetailsListByTypeList(Constants.LookUp.GETLOOKUPDETAILSBYTYPELIST, typesList);
		lookupBean.setBanksList(lookUpMap.get(Constants.BANKS));
		lookupBean.setTypeOfBusinessList(lookUpMap.get(Constants.TYPEOFBUSINESS));
		lookupBean.setStatesList(lookUpMap.get(Constants.STATES));
		return lookupBean;
	}
}
