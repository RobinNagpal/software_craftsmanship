package com.xebia.codejam.client;

import com.xebia.codejam.model.BatteryDecorator;
import com.xebia.codejam.model.RobotComponent;
import com.xebia.codejam.model.WalkBatteryDecorator;
import com.xebia.codejam.model.WeightBatteryDecorator;

public class RobotAppClient {

	public static void main(String[] args) {

		BatteryDecorator robot = new RobotComponent(100D);
		robot = new WalkBatteryDecorator(robot, 2D);
		robot = new WeightBatteryDecorator(robot, 3);

		robot.calculateRemainingBattery();

	}
}
