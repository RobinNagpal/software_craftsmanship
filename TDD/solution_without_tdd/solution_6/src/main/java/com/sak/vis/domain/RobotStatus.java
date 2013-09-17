package com.sak.vis.domain;

public class RobotStatus {
	private double battery;
	private double carryWeight;

	public RobotStatus() {
	}

	public RobotStatus(double battery, double carryWeight) {
		super();
		this.battery = battery;
		this.carryWeight = carryWeight;
	}

	public double getBattery() {
		return battery;
	}

	public void setBattery(double battery) {
		this.battery = battery;
	}

	public double getCarryWeight() {
		return carryWeight;
	}

	public void setCarryWeight(double carryWeight) {
		this.carryWeight = carryWeight;
	}

}