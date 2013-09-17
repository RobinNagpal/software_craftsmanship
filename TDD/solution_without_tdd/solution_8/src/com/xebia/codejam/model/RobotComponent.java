package com.xebia.codejam.model;

import java.util.ArrayList;
import java.util.List;

public class RobotComponent extends BatteryDecorator {
	
	private Double battery;

	List<BatteryDecorator> batteryDecoratorListeners = new ArrayList<BatteryDecorator>();

	public RobotComponent(Double battery) {
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
	public Double calculateRemainingBattery() {
		return battery;
	}


}
