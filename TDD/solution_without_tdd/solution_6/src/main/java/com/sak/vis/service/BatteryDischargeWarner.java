package com.sak.vis.service;

import com.sak.vis.Robot;
import com.sak.vis.domain.LightStatus;
import com.sak.vis.domain.RobotStatus;

public class BatteryDischargeWarner implements RobotStatusObserver {
	private static final int MINIMUM_BATTERY = 15;

	public void update(RobotStatus robotStatus, Robot robot) {
		if (robotStatus.getBattery() < MINIMUM_BATTERY) {
			robot.setRedHeadLight(LightStatus.ON);
		} else {
			robot.setRedHeadLight(LightStatus.OFF);
		}
	}
}
