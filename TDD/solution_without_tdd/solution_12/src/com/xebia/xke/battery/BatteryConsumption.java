package com.xebia.xke.battery;

public abstract class BatteryConsumption {

	private String batteryDescription = "";
	private Double battery;
	private int weight;
	private int Distance_walking;

	public abstract Double getRemainingBattery();

	public String getBatteryDescription() {
		return batteryDescription;
	}

	public Double getBattery() {
		return battery;
	}

	public int getWeight() {
		return weight;
	}

	public int getWalkingDistance() {
		return Distance_walking;
	}

}