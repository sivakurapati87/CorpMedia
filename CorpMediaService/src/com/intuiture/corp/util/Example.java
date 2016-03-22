package com.intuiture.corp.util;

import java.util.Calendar;

public class Example {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2016, 02, 25);
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		cal.add(Calendar.DATE, -(cal.get(Calendar.DAY_OF_WEEK) -1));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.getTime());
		System.out.println(EnumUtils.APPROVE.getState());
		System.out.println(EnumUtils.APPROVE.getValue());
	}
}
