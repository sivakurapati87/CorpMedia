package com.intuiture.corp.util;

import java.util.ResourceBundle;

public class Constants {
	public static final String TYPEOFBUSINESS = "TYPEOFBUS";
	public static final String BANKS = "BANKS";
	public static final String STATES = "STATES";
	public static final String DMW = "DWM";
	public static final String WORKERTYPE = "WORKERTYPE";
	public static final String TIMETYPE = "TIMETYPE";
	public static final String GENDER = "GENDER";
	public static final String MARITALSTATUS = "MARITALSTATUS";
	public static final String BLOODGROUP = "BLOODGROUP";
	public static final String RELATION = "RELATION";
	public static final String TRUEORFALSE = "TRUEORFALSE";
	public static final String MONTH = "MONTH";
	public static final String DAY = "DAY";
	public static final String PAYDAYINAMONTH = "PAYDAYINAMONTH";
	public static final String CURRENCY = "CURRENCY";
	public static final String STATUS = "STATUS";

	public static final String LEAVETYPE = "LEAVETYPE";
	public static final String MQHS = "MQHS";

	public static final String REASONTYPE = "REASONTYPE";


	public static final ResourceBundle RB = ResourceBundle.getBundle("config");
	public static final String SERVICEURL = RB.getString("RESTWebServiceUrl");

	public static class LookUp {
		public static final String GETLOOKUPDETAILSBYTYPELIST = SERVICEURL + "/LookUpController/getAllLookupDetailsByTypeList";
	}

}
