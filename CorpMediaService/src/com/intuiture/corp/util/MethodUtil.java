package com.intuiture.corp.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

import com.intuiture.corp.entity.Employee_Leave;
import com.intuiture.corp.entity.Employee_TimeSheet;
import com.intuiture.corp.json.EmployeeLeaveJson;

public class MethodUtil {
	private static Logger LOG = Logger.getLogger(MethodUtil.class);
	// private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private final static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};

	public static void makeDirectory(File myFolder) {
		if (!myFolder.exists()) {
			try {
				myFolder.mkdirs();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static List<Date> getWeeklyDatesList(String startingWeekDate) {
		Date startingWeekDay = convertStringToDate(startingWeekDate);
		return calculateWeeklyDatesList(startingWeekDay);
	}

	public static List<Date> calculateWeeklyDatesList(Date startDate) {
		List<Date> datesList = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		for (int i = 0; i < 7; i++) {
			cal.setTime(startDate);
			cal.add(Calendar.DATE, i);
			datesList.add(cal.getTime());
		}
		return datesList;
	}

	public static List<Date> getWeeklyDatesByAnyStartDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -(cal.get(Calendar.DAY_OF_WEEK) - 1));
		return calculateWeeklyDatesList(cal.getTime());
	}

	public static List<Date> findDatesList(Date startingDate, Date endingDate) {
		List<Date> datesList = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startingDate);
		datesList.add(cal.getTime());
		if (endingDate != null) {
			int i = 1;
			while (cal.getTime().compareTo(endingDate) < 0) {
				cal.add(Calendar.DATE, i);
				datesList.add(cal.getTime());
			}
		}
		return datesList;
	}

	public static String uploadAnImage(String imageBase64) {
		BufferedOutputStream buffStream = null;
		Random ran = new Random();
		String imageName = String.valueOf(100000 + ran.nextInt(900000)) + ".png";
		try {
			byte[] bytes = new BASE64Decoder().decodeBuffer(imageBase64.split(",")[1]);
			File folder = new File(Constants.FILEUPLOADEDPATH);
			makeDirectory(folder);
			File newFile = new File(Constants.FILEUPLOADEDPATH + "\\" + imageName);
			buffStream = new BufferedOutputStream(new FileOutputStream(newFile));
			buffStream.write(bytes);
			if (buffStream != null) {
				buffStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageName;
	}

	public static String getStrInputStream(String imageName) {
		String inputStreamToString = null;
		try {
			if (imageName != null) {
				File initialFile = new File(Constants.FILEUPLOADEDPATH + "\\" + imageName);
				InputStream inputStream = new FileInputStream(initialFile);
				inputStreamToString = new BASE64Encoder().encode(IOUtils.toByteArray(inputStream));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStreamToString;

	}

	public static List<Integer> splitStringInList(String idsInString) {
		Integer[] ids = splitString(idsInString);
		List<Integer> listOfIds = ids != null ? Arrays.asList(ids) : null;
		return listOfIds;
	}

	public static Integer convertStringToInteger(String str) {
		Integer convertedStr = null;
		if (str != null && str.length() > 0) {
			convertedStr = Integer.parseInt(str);
		}
		return convertedStr;
	}

	public static String convertIntegerToString(Integer value) {
		String str = null;
		if (value != null) {
			str = String.valueOf(value);
		}
		return str;
	}

	public static Integer[] splitString(String idsInString) {
		Integer[] ids = null;
		if (idsInString != null && idsInString.length() > 0) {
			String[] strIds = idsInString.split(",");
			ids = new Integer[strIds.length];
			for (int i = 0; i < strIds.length; i++) {
				ids[i] = Integer.parseInt(strIds[i]);
			}
		}
		return ids;
	}

	public static Date convertDiffferentFormatString(String str) {
		Date date = null;
		try {
			if (str != null && str.length() > 9) {
				// SimpleDateFormat dateformat = null;
				String s1 = null;
				if (str.length() == 11) {
					// dateformat = new SimpleDateFormat("dd-MMM-yyyy");
					s1 = str.subSequence(0, 11).toString();
				} else {
					// dateformat = new SimpleDateFormat("yyyy-MM-dd");
					s1 = str.subSequence(0, 10).toString();
				}

				date = sdf.get().parse(s1);
				date = convertStringToDate(convertDateToString(date));
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at convertDateToString() in TransformDomainToJson:" + e.getMessage(), e);
		}
		return date;
	}

	public static String convertDoubleToMoney(Double dbl) {
		String str = null;
		if (dbl != null) {
			Format format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
			str = format.format(new BigDecimal(dbl));
		}
		return str;
	}

	public static String concateStringValues(String[] strArray) {
		if (strArray != null && strArray.length > 0) {
			String strValue = null;
			for (String str : strArray) {
				if (strValue == null) {
					strValue = str;
				} else {
					strValue += "," + str;
				}
			}
			return strValue;
		}
		return null;
	}

	public static List<Integer> getListByString(String strvalue) {
		List<Integer> list = null;
		if (strvalue != null) {
			String[] strArray = strvalue.split(",");
			if (strArray != null && strArray.length > 0) {
				list = new ArrayList<Integer>();
				for (String str : strArray) {
					list.add(Integer.parseInt(str));
				}
			}
		}
		return list;
	}

	public static String getInputStream(String fileName, String filePath) {
		String inputStreamToString = null;
		try {
			File initialFile = new File(filePath + "\\" + fileName);
			InputStream inputStream = new FileInputStream(initialFile);
			inputStreamToString = IOUtils.toString(inputStream, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStreamToString;

	}

	public static String[] getListOfStringsByIntArray(Integer[] listOfIds, Map<Integer, String> idWithDescriptionMap) {
		String[] strAmenities = null;
		if (listOfIds != null && listOfIds.length > 0) {
			strAmenities = new String[listOfIds.length];
			for (int i = 0; i < listOfIds.length; i++) {
				strAmenities[i] = idWithDescriptionMap.get(listOfIds[i]);
			}
		}
		return strAmenities;

	}

	public static Date convertStringToDate(String strDate) {
		Date date = null;
		try {
			if (strDate != null && strDate.trim().length() > 0) {
				date = sdf.get().parse(strDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at convertStringToDate() in TransformDomainToJson:" + e.getMessage(), e);
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
				strDate = sdf.get().format(date);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at convertDateToString() in TransformDomainToJson:" + e.getMessage(), e);
		}
		return strDate;
	}

	public static String sumTimes(final String[] timestampList) {
		long milliseconds = 0;

		final DateFormat dt = new SimpleDateFormat("HH:mm");
		dt.setLenient(false);
		if (timestampList != null && timestampList.length > 0) {
			try {
				final long timezoneOffset = dt.parse("00:00").getTime();
				for (final String t : timestampList) {
					milliseconds += (dt.parse(t).getTime() - timezoneOffset);
				}
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
		((SimpleDateFormat) dt).applyPattern(":mm");
		return new StringBuilder(8).append(milliseconds / 3600000).append(dt.format(new Date(milliseconds))).toString();
	}

	public static void getAppliedLeaveDates(EmployeeLeaveJson employeeLeaveJson, List<Employee_Leave> employee_LeaveList) {
		Iterator<Employee_Leave> empLeaveIterator = employee_LeaveList.iterator();
		if (employeeLeaveJson.getLeaveStartDate() != null && employeeLeaveJson.getLeaveEndDate() != null) {
			while (empLeaveIterator.hasNext()) {
				Employee_Leave employee_Leave = empLeaveIterator.next();
				employee_Leave.getLeave().setLeaveDate(convertStringToDate(convertDateToString(employee_Leave.getLeave().getLeaveDate())));
				if (!((employee_Leave.getLeave().getLeaveDate().compareTo(employeeLeaveJson.getLeaveStartDate()) >= 0) && (employee_Leave.getLeave()
						.getLeaveDate().compareTo(employeeLeaveJson.getLeaveEndDate()) <= 0))) {
					empLeaveIterator.remove();
				}
			}
		} else {
			while (empLeaveIterator.hasNext()) {
				Employee_Leave employee_Leave = empLeaveIterator.next();
				employee_Leave.getLeave().setLeaveDate(convertStringToDate(convertDateToString(employee_Leave.getLeave().getLeaveDate())));
				if (!(employee_Leave.getLeave().getLeaveDate().equals(employeeLeaveJson.getLeaveStartDate()))) {
					empLeaveIterator.remove();
				}
			}
		}
	}

	public static void getAppliedTimesheetDates(EmployeeLeaveJson employeeLeaveJson, List<Employee_TimeSheet> employee_TimeSheets) {
		Iterator<Employee_TimeSheet> emptimesheetIterator = employee_TimeSheets.iterator();
		if (employeeLeaveJson.getLeaveStartDate() != null && employeeLeaveJson.getLeaveEndDate() != null) {
			while (emptimesheetIterator.hasNext()) {
				Employee_TimeSheet employee_TimeSheet = emptimesheetIterator.next();
				employee_TimeSheet.getTimesheet().setTimeSheetDate(
						convertStringToDate(convertDateToString(employee_TimeSheet.getTimesheet().getTimeSheetDate())));
				if (!((employee_TimeSheet.getTimesheet().getTimeSheetDate().compareTo(employeeLeaveJson.getLeaveStartDate()) >= 0) && (employee_TimeSheet
						.getTimesheet().getTimeSheetDate().compareTo(employeeLeaveJson.getLeaveEndDate()) <= 0))) {
					emptimesheetIterator.remove();
				}
			}
		} else {
			while (emptimesheetIterator.hasNext()) {
				Employee_TimeSheet employee_TimeSheet = emptimesheetIterator.next();
				employee_TimeSheet.getTimesheet().setTimeSheetDate(
						convertStringToDate(convertDateToString(employee_TimeSheet.getTimesheet().getTimeSheetDate())));
				if (!(employee_TimeSheet.getTimesheet().getTimeSheetDate().equals(employeeLeaveJson.getLeaveStartDate()))) {
					emptimesheetIterator.remove();
				}
			}
		}
	}
}
