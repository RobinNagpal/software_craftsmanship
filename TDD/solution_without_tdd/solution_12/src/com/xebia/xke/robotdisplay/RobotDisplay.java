package com.xebia.xke.robotdisplay;

public class RobotDisplay implements Display {

	@Override
	public void updateDisplay(String message) {

		System.out.println("Robot Chest Display: " + message);

	}

}