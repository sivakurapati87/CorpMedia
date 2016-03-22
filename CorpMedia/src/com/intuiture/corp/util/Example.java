package com.intuiture.corp.util;

public class Example {
	public static void main(String[] args) {
		String s = "Rs.23,695.42";
		String s1[] = s.split("\\.");
		for (String str : s1)
			System.out.println(str);
	}
}
