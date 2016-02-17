package com.intuiture.corp.util;

import java.util.ResourceBundle;

public class Constants {
	public static final String TYPEOFBUSINESS = "TYPEOFBUS";
	public static final String BANKS = "BANKS";
	public static final String STATES = "STATES";
	public static final ResourceBundle RB = ResourceBundle.getBundle("config");
	public static final String SERVICEURL = RB.getString("RESTWebServiceUrl");

	public static class LookUp {
		public static final String GETLOOKUPDETAILSBYTYPELIST = SERVICEURL + "/LookUpController/getAllLookupDetailsByTypeList";
	}

}
