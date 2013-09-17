package com.robotics.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.robotics.domain.Battery;
import com.robotics.domain.Robot;

public class RoboticsServiceTest {
	
	private RoboticService roboticService;
	
   @Before
   public void init() {
	   roboticService = new RoboticServiceImpl();
   }

	@Test
	public void testRobotWalksForThreeKilometersSuccessfully() {
		Battery battery = buildBattery(5,2);
		Robot robot = buildRobot(3.5f, 0);
		robot.setBattery(battery);
		roboticService.walk(robot);
	}
	
	@Test
	public void testRobotWalksForTwoKms_WithThreeKgWeight() {
		Battery battery = buildBattery(5,7);
		Robot robot = buildRobot(2.0f, 3);
		robot.setBattery(battery);
		roboticService.walk(robot);
	}
	
	@Test
	public void testRobotWalks_WithTwelveKgWeight() {
		Battery battery = buildBattery(5,8);
		Robot robot = buildRobot(4.0f, 12);
		robot.setBattery(battery);
		roboticService.walk(robot);
	}
	
	
	
	private Robot buildRobot(Float distanceCovered, Integer weight) {
		Robot robot = new Robot();
		robot.setDistanceCovered(distanceCovered);
		robot.setWeight(weight);
		return robot;
	}

	private Battery buildBattery(int charge,int currentCharge) {
		Battery battery = new Battery();
		battery.setCharge(charge);
		battery.setCurrentCharge(currentCharge);
		return battery;
	}
}
