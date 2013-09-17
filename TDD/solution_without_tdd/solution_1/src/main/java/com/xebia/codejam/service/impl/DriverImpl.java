/**
 * 
 */
package com.xebia.codejam.service.impl;

import org.springframework.stereotype.Component;

import com.xebia.codejam.common.IConstants;
import com.xebia.codejam.exception.BatteryDischarged;
import com.xebia.codejam.exception.OverloadedException;
import com.xebia.codejam.model.Direction;
import com.xebia.codejam.model.Robot;
import com.xebia.codejam.service.IDriver;

/**
 * @author Jagmeet
 *
 */
@Component
public class DriverImpl implements IDriver {

	/*
	 * (non-Javadoc)
	 * @see com.xebia.codejam.service.IDriver#travel(com.xebia.codejam.model.Robot, java.lang.Float)
	 */
	@Override
	public void travel(Robot robot, Float distance) throws OverloadedException, BatteryDischarged {
		if (robot.isOverloaded()) {
			throw new OverloadedException("Can't travel, remove some weight.");
		}
		float distanceFactor = IConstants.FULL_CHARGE_CAPACITY / robot.getDistanceCapacity();
		float weightFactor = robot.getBatteryDischargeFactorPerWeight() * robot.getCurrentWeight();
		
		int requiredCharge = Math.round(distance * (distanceFactor + weightFactor));
		if (robot.getCurrentCharge() >= requiredCharge) {
			robot.setDistanceTravelled(robot.getDistanceTravelled() + distance);
			robot.setCurrentCharge(robot.getCurrentCharge() - requiredCharge);
		} else {
			float maxDistanceToCover = robot.getCurrentCharge() / (distanceFactor + weightFactor);
			robot.setDistanceTravelled(robot.getDistanceTravelled() + maxDistanceToCover);
			robot.setCurrentCharge(IConstants.EMPTY_CHARGE_CAPACItY);
			
			throw new BatteryDischarged("Battery discharged, can't travel more.");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.xebia.codejam.service.IDriver#move(com.xebia.codejam.model.Robot, com.xebia.codejam.model.Direction)
	 */
	@Override
	public void move(Robot robot, Direction direction) throws OverloadedException, BatteryDischarged {
		if (robot.isOverloaded()) {
			throw new OverloadedException("Can't move, remove some weight.");
		}
		int requiredCharge = direction.getChargeConsumption();
		if (robot.getCurrentCharge() >= requiredCharge) {
			robot.setCurrentCharge(robot.getCurrentCharge() - requiredCharge);
		} else {
			throw new BatteryDischarged("Battery discharged, can't move more.");
		}
	}
}
