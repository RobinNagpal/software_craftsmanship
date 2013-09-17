package com.xebia.xke.test;
import junit.framework.Assert;

import org.junit.Test;

import com.xebia.xke.battery.BatteryConsumption;
import com.xebia.xke.battery.BatteryWalkConsumption;
import com.xebia.xke.battery.BatteryWeightConsumption;
import com.xebia.xke.battery.Robot;


public class BatteryTest {


	@Test
	public void RobotWeightAndWalkTest() {

		BatteryConsumption robot = new Robot(100D);
		robot = new BatteryWalkConsumption(robot, 2D);
		robot = new BatteryWeightConsumption(robot, 3);

		Double remainingBattery = robot.getRemainingBattery();
		Assert.assertEquals(56.4, remainingBattery);

	}

	@Test(expected = RuntimeException.class)
	public void RobotWithWeightTest() {

		BatteryConsumption robot = new Robot(100D);
		robot = new BatteryWeightConsumption(robot, 12);

		Double calculateBatteryRemaining = robot.getRemainingBattery();
		Assert.assertEquals(76D, calculateBatteryRemaining);

	}

	@Test
	public void RobotWalkTest() {
		
		BatteryConsumption robot = new Robot(100D);
		robot = new BatteryWalkConsumption(robot, 3.5);
		
		Double remainingBattery = robot.getRemainingBattery();
		
		Assert.assertEquals(30D, remainingBattery);
		
	}
}