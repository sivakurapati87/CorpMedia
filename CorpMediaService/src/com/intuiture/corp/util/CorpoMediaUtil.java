package com.intuiture.corp.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class CorpoMediaUtil {
	private static Logger LOG = Logger.getLogger(CorpoMediaUtil.class);
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static Date convertStringToDate(String strDate) {
		Date date = null;
		try {
			if (strDate != null && !strDate.trim().equalsIgnoreCase("null")
					&& strDate.trim().length() > 0) {
				date = sdf.parse(strDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(
					"Error at convertStringToDate() in TransformDomainToJson:"
							+ e.getMessage(), e);
		}
		return date;
	}

	/**
	 * This method is to convert Date to String
	 * 
	 * @param date
	 * @return
	 */
	public static String convertDateToString(Date date) {
		String strDate = null;
		try {
			if (date != null) {
				strDate = sdf.format(date);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(
					"Error at convertDateToString() in TransformDomainToJson:"
							+ e.getMessage(), e);
		}
		return strDate;
	}

	public static Date convertDiffferentFormatString(String str) {
		Date date = null;
		try {
			if (str != null && str.length() > 9) {
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				String s1 = str.subSequence(0, 10).toString();
				date = dateformat.parse(s1);
				date = convertStringToDate(convertDateToString(date));
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.DATE, 1);
				date = cal.getTime();

			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(
					"Error at convertDateToString() in TransformDomainToJson:"
							+ e.getMessage(), e);
		}
		return date;
	}

	/**
	 * This method is to convert Date to String
	 * 
	 * @param date
	 * @return
	 */
	public static Boolean getBooleanValues(String value) {
		Boolean boolValue = null;
		try {
			if (value != null) {
				if (value.contains("Unlisted")) {
					boolValue = false;
				} else if (value.contains("listed") || value.contains("ROC")
						|| value.contains("Director")
						|| value.contains("Secretary")) {
					boolValue = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(
					"Error at convertDateToString() in TransformDomainToJson:"
							+ e.getMessage(), e);
		}
		return boolValue;
	}

	/**
	 * This method is to convert Date to String
	 * 
	 * @param date
	 * @return
	 */
	public static Boolean isDirector(String value) {
		Boolean boolValue = null;
		try {
			if (value != null) {
				if (value.contains("Director")) {
					boolValue = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(
					"Error at convertDateToString() in TransformDomainToJson:"
							+ e.getMessage(), e);
		}
		return boolValue;
	}

	/**
	 * This method is to convert Date to String
	 * 
	 * @param date
	 * @return
	 */
	public static Boolean isSecretory(String value) {
		Boolean boolValue = null;
		try {
			if (value != null) {
				if (value.contains("Secretary")) {
					boolValue = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(
					"Error at convertDateToString() in TransformDomainToJson:"
							+ e.getMessage(), e);
		}
		return boolValue;
	}

	public static String getStrBooleanValue(Boolean boolvalue) {
		String strBooleanValue = null;
		try {

			if (boolvalue != null) {
				if (boolvalue) {
					strBooleanValue = "Yes";
				} else {
					strBooleanValue = "No";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getStrBooleanValue() in TransformDomainToJson:"
					+ e.getMessage(), e);
		}
		return strBooleanValue;
	}
}
