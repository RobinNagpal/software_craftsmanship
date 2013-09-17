package com.sak.vis;

import com.sak.vis.service.BatteryDischargeWarner;
import com.sak.vis.service.OverloadWarner;

public class RobotMainController {

	public static Robot setUpRobot() {
		Robot robot = new Robot();
		robot.addObservers(new BatteryDischargeWarner());
		robot.addObservers(new OverloadWarner());
		robot.setBattery(100);
		return robot;
	}

	public static void main(String[] args) {
		Robot robot = setUpRobot();
		robot.walk(2);
	}

}
