package controller;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import controller.RobotController;

public class RobotControllerTest {
	
	private RobotController robotController;
	
	@Before
	public void setup() {
		robotController = new RobotController();
		robotController.initializeRobot();
		robotController.configureRobot(100);
	}
	
	@Test
	public void testRobotMovesWithoutLoad() {
		robotController.robotWalksWithoutLoad(3.5f);
		assertEquals(99.3f, robotController.getRobot().getRemainingBattery());
	}

	@Test
	public void testRobotMovesLoad() {
		robotController.robotWalksWithLoad(2, 3);
		assertEquals(93.6f, robotController.getRobot().getRemainingBattery());
	}
	
	@Test(expected=RuntimeException.class)
	public void testRobotLiftsLoad() {
		robotController.robotStandsWithLoad(12);
		assertTrue(robotController.getRobot().isOverloaded());
		assertEquals(100.0f, robotController.getRobot().getRemainingBattery());
	}

}
