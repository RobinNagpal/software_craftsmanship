package com.xebia.codejam.model;

public abstract class BatteryDecorator {

	private String batteryDecoratorDescription = "";
	private Double battery;
	private int weight;
	private int walkingDistance;

	public abstract Double calculateRemainingBattery();

	public String getBatteryDecoratorDescription() {
		return batteryDecoratorDescription;
	}

	public Double getBattery() {
		return battery;
	}

	public int getWeight() {
		return weight;
	}

	public int getWalkingDistance() {
		return walkingDistance;
	}	
	
	
	

}
