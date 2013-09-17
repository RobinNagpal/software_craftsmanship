package com.sak.vis.service;

import com.sak.vis.Robot;
import com.sak.vis.domain.LightStatus;
import com.sak.vis.domain.RobotStatus;

public class OverloadWarner implements RobotStatusObserver {

	private static final int MAXIMUM_WEIGHT = 10;

	public void update(RobotStatus robotStatus, Robot robot) {
		if (robotStatus.getCarryWeight() > MAXIMUM_WEIGHT) {
			robot.setChestLedDisplay(LightStatus.ON);
		} else {
			robot.setChestLedDisplay(LightStatus.OFF);
		}
	}

}
