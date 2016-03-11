package com.intuiture.corp.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Ex {
	public static void main(String[] args) throws ParseException {
		Calendar cal = Calendar.getInstance();
		Integer currentMonth = cal.get(Calendar.MONTH);
		List<Integer> monthsRange = new ArrayList<Integer>();
		for (int i = currentMonth, j = 0; j < 3; j++) {
			monthsRange.add(i--);
			if (i < 0) {
				i = 11;
			}
		}
		monthsRange.add(currentMonth + 1);

	}
}
