package com.sak.vis.service;

import com.sak.vis.Robot;
import com.sak.vis.domain.RobotStatus;
import com.sak.vis.util.RobotException;

public class WalkingService {
	public double walkRemaning(RobotStatus status) {
		return (status.getBattery() / 100) * 5;
	}

	public void walk(double distance, Robot robot) throws RobotException {
		double battery = robot.getBattery();
		double carryWeight = robot.getCarryWeight();
		
		if(carryWeight > 10){
			throw new RobotException("Overloaded can't walk!");
		}
		
		battery = battery - (carryWeight * (0.02 * battery));
		
		battery = battery - ((distance * battery) / 5);
		
		robot.setBattery(battery);
	}

}
