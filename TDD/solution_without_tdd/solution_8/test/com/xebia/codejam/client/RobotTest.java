package com.xebia.codejam.client;

import junit.framework.Assert;

import org.junit.Test;

import com.xebia.codejam.model.BatteryDecorator;
import com.xebia.codejam.model.RobotComponent;
import com.xebia.codejam.model.WalkBatteryDecorator;
import com.xebia.codejam.model.WeightBatteryDecorator;

public class RobotTest {

	@Test
	public void RobotWalkTest() {

		BatteryDecorator robot = new RobotComponent(100D);
		robot = new WalkBatteryDecorator(robot, 3.5D);

		Double calculateRemainingBattery = robot.calculateRemainingBattery();

		Assert.assertEquals(30D, calculateRemainingBattery);

	}

	@Test
	public void RobotWalkWithWeightTest() {

		BatteryDecorator robot = new RobotComponent(100D);
		robot = new WalkBatteryDecorator(robot, 2D);
		robot = new WeightBatteryDecorator(robot, 3);

		Double calculateRemainingBattery = robot.calculateRemainingBattery();
		Assert.assertEquals(56.4, calculateRemainingBattery);

	}

	@Test(expected = RuntimeException.class)
	public void RobotWithWeightTest() {

		BatteryDecorator robot = new RobotComponent(100D);
		robot = new WeightBatteryDecorator(robot, 12);

		Double calculateRemainingBattery = robot.calculateRemainingBattery();
		Assert.assertEquals(76D, calculateRemainingBattery);

	}

}
