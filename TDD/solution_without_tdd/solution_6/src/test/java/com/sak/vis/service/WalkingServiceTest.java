package com.sak.vis.service;

import org.junit.Test;

import com.sak.vis.Robot;
import com.sak.vis.RobotMainController;
import com.sak.vis.util.RobotException;

public class WalkingServiceTest {
	
	private WalkingService walkingService = new WalkingService();
	
	@Test(expected = RobotException.class)
	public void shouldThrowExceptionForOverload() throws RobotException{
		Robot robot = RobotMainController.setUpRobot();
		robot.setCarryWeight(12);
		walkingService.walk(2, robot);
	}
}
