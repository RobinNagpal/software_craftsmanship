package com.robotics.domain;
import java.io.Serializable;
import java.math.BigDecimal;

public class Robot implements Serializable {

	private static final long serialVersionUID = 7584625139835940135L;
	
	private Integer weight;
	private String displayMessage;
	private Battery battery;
	private Float distanceCovered;

	
	public Float getDistanceCovered() {
		return distanceCovered;
	}
	public void setDistanceCovered(Float distanceCovered) {
		this.distanceCovered = distanceCovered;
	}
	public Battery getBattery() {
		return battery;
	}
	public void setBattery(Battery battery) {
		this.battery = battery;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getDisplayMessage() {
		return displayMessage;
	}
	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}

}
