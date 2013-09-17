/**
 * 
 */
package com.robotics.service;

import com.robotics.domain.Robot;
import com.robotics.util.ErrorMessage;

public class RoboticServiceImpl implements RoboticService {

	
	@Override
	public void walk(Robot robot) {
		if(robot.getBattery().getCharge() > 0)
			robot.setDistanceCovered(5.0f);
		startWalking(robot);
	}


	private void startWalking(Robot robot) {
		if(calculateTotalBatteryPercentage(robot)<15){
			System.out.println(ErrorMessage.LOW_BATTERY);
		} else {
			if(robot.getWeight() > 10){
				System.out.println(ErrorMessage.OVER_WEIGHT);
			} else {
				batteryConsumption(robot);
			}
		}
		
	}
	
	private Integer calculateTotalBatteryPercentage(Robot robot) {
		return (robot.getBattery().getCurrentCharge()/robot.getBattery().getCharge())*100;
	}


	@Override
	public void batteryConsumption(Robot robot) {
		if(robot.getWeight()<10) {
			robot.getBattery().setCurrentCharge((int)Math.round(robot.getBattery().getCurrentCharge()-0.02));
		} else {
			robot.setDistanceCovered((float)robot.getBattery().getCharge()*5);
		} 
	}

}
