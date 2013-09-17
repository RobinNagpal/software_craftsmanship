package com.xebia.xke.battery;

import java.util.ArrayList;
import java.util.List;

public class Robot extends BatteryConsumption {

	private Double battery;

	List<BatteryConsumption> batteryDecoratorListeners = new ArrayList<BatteryConsumption>();

	public Robot(Double battery) {
		super();
		this.battery = battery;
	}

	public Double getBattery() {
		return battery;
	}

	public void setBattery(Double battery) {
		this.battery = battery;
	}

	@Override
	public Double getRemainingBattery() {
		return battery;
	}

}