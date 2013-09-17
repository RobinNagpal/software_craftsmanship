package com.sak.vis;

import java.util.HashSet;
import java.util.Set;

import com.sak.vis.domain.LightStatus;
import com.sak.vis.domain.RobotStatus;
import com.sak.vis.service.RobotStatusObserver;
import com.sak.vis.service.WalkingService;
import com.sak.vis.util.RobotException;

public class Robot {

	private RobotStatus status = new RobotStatus();

	private LightStatus redHeadLight = LightStatus.OFF;

	private LightStatus chestLedDisplay = LightStatus.OFF;

	private WalkingService walkingService = new WalkingService();

	private Set<RobotStatusObserver> observers = new HashSet<RobotStatusObserver>();

	public LightStatus getRedHeadLight() {
		return redHeadLight;
	}

	public void setRedHeadLight(LightStatus redHeadLight) {
		this.redHeadLight = redHeadLight;
	}

	public LightStatus getChestLedDisplay() {
		return chestLedDisplay;
	}

	public void setChestLedDisplay(LightStatus chestLedDisplay) {
		this.chestLedDisplay = chestLedDisplay;
	}

	public void addObservers(RobotStatusObserver observer) {
		observers.add(observer);
	}

	public void walk(double distance) {
		try {
			walkingService.walk(distance, this);
		} catch (RobotException e) {
			System.out.println(e.getMessage());
		}
	}

	private void informObservers() {
		for (RobotStatusObserver observer : observers) {
			observer.update(status, this);
		}
	}

	public void setBattery(double battery) {
		this.status.setBattery(battery);
		informObservers();
	}

	public double getBattery() {
		return status.getBattery();
	}

	public void setCarryWeight(double carryWeight) {
		this.status.setCarryWeight(carryWeight);
		informObservers();
	}

	public double getCarryWeight() {
		return status.getCarryWeight();
	}
}
