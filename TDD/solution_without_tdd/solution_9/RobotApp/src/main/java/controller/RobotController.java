package controller;

import domain.Robot;

public class RobotController {
	
	private Robot robot;
	
	public Robot getRobot() {
		return robot;
	}

	public void initializeRobot() {
		robot = new Robot();
		robot.reset();
	}
	
	public void configureRobot(float battery) {
		
		robot.setInitialBattery(battery);
		System.out.println("\nRobot initialized\n" + robot.getRobotStatus());
	}
	
	public void robotWalksWithLoad(float distance, float load) {
		robot.setDistanceCovered(distance);
		robot.setLoad(load);
		robot.processBatteryConsumption();
		System.out.println("\nRobot walks carrying load\n" + robot.getRobotStatus());
	}
	
	public void robotWalksWithoutLoad(float distance) {
		robot.setDistanceCovered(distance);
		robot.processBatteryConsumption();
		System.out.println("\nRobot walks without carrying load\n" + robot.getRobotStatus());
	}
	
	public void robotStandsWithLoad(float load) {
		robot.setLoad(load);
		robot.processBatteryConsumption();
		System.out.println("\nRobot stands carrying load\n" + robot.getRobotStatus());
	}

}
