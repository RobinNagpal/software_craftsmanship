package com.xebia.xke.robotdisplay;

public class RobotDisplayHead implements Display {

	@Override
	public void updateDisplay(String message) {

		System.out.println("Robot Head Display: " + message);

	}
}