package com.intuiture.corp.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ex {
	public static void main(String[] args) throws ParseException {
		try {

			// Calendar cal1 = Calendar.getInstance();
			// Calendar cal2 = Calendar.getInstance();
			// cal1.set(2016, 02, 16, 9, 17, 18);
			// cal2.set(2016, 02, 16, 22, 17, 18);
			// System.out.println(cal1.getTime());
			// System.out.println(cal2.getTime());
			// Long diff = cal2.getTimeInMillis() - cal1.getTimeInMillis();

			// SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			// java.util.Date d1 = (java.util.Date) format.parse("12:32");
			// java.util.Date d2 = (java.util.Date) format.parse("23:42");
			// Long diff = d1.getTime()+d2.getTime();
			//
			// long diffSeconds = diff / 1000 % 60;
			// long diffMinutes = diff / (60 * 1000) % 60;
			// long diffHours = diff / (60 * 60 * 1000) % 24;
			// long diffDays = diff / (24 * 60 * 60 * 1000);
			//
			// System.out.print(diffDays + " days, ");
			// System.out.print(diffHours + " hours, ");
			// System.out.print(diffMinutes + " minutes, ");
			// System.out.print(diffSeconds + " seconds.");

			// SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			//
			// java.util.Date d1 = (java.util.Date) format.parse("12:32");
			// java.sql.Time ppstime = new java.sql.Time(d1.getTime());
			// System.out.println(ppstime);
			
			//solution - 1
			List<String> timestampsList = new ArrayList<String>();
			timestampsList.add("8:56");
			timestampsList.add("6:00");
			timestampsList.add("8:12");
			timestampsList.add("8:10");
			timestampsList.add("6:00");
			timestampsList.add("16:00");
			timestampsList.add("16:00");
			timestampsList.add("00:5");
			String[] s=new String[timestampsList.size()];
			System.out.println(sumTimes(timestampsList.toArray(s)));
//			final DateFormat dt = new SimpleDateFormat("HH:mm");
//			final Calendar c = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
//			long milliseconds = 0;
//			c.clear();
//			long startingMS = c.getTimeInMillis();
//			for (final String t : timestampsList) {
//			  milliseconds = milliseconds + (dt.parse(t).getTime() - startingMS);
//			}
//
//			System.out.println(milliseconds + " milliseconds");
//			System.out.println(milliseconds / 1000 + " seconds");
//			System.out.println(milliseconds / 1000 / 60 + " minutes");
//			System.out.println(milliseconds / 1000 / 60 / 60 + " hours");
		    } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String sumTimes(final String[] timestampList) {
	    long milliseconds = 0;
	    final DateFormat dt = new SimpleDateFormat("HH:mm");
	    dt.setLenient(false);
	    try {
	        final long timezoneOffset = dt.parse("00:00").getTime();
	        for (final String t: timestampList) {
	            milliseconds += (dt.parse(t).getTime() - timezoneOffset);
	        }
	    } catch (final Exception e) {
	       e.printStackTrace();
	    }

	    ((SimpleDateFormat) dt).applyPattern(":mm");
	    return new StringBuilder(8).append(milliseconds / 3600000).append(
	            dt.format(new Date(milliseconds))).toString();
	}
}
