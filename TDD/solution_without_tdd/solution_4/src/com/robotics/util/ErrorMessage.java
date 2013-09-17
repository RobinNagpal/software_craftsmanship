package com.robotics.util;

public enum ErrorMessage {

	OVER_WEIGHT("Over Weight"),
	UNDER_WEIGHT("Under Weight"),
	PROPER_WEIGHT("Proper Weight"),
	LOW_BATTERY("Low Battery");
	
	private String message;
	
	private ErrorMessage(String weight) {
		this.message= weight;
	}
	public String getWeight() {
		return message;
	}
}
