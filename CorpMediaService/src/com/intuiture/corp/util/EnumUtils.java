package com.intuiture.corp.util;

public enum EnumUtils {
	APPROVE("Approve", 299), REJECT("Reject", 300);
	private final String state;
	private final int value;

	private EnumUtils(String state, int value) {
		this.state = state;
		this.value = value;
	}

	public String getState() {
		return state;
	}

	public int getValue() {
		return value;
	}
}
