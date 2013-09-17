/**
 * 
 */
package com.xebia.codejam.service;

import com.xebia.codejam.exception.BatteryDischarged;
import com.xebia.codejam.exception.OverloadedException;
import com.xebia.codejam.model.Direction;
import com.xebia.codejam.model.Robot;

/**
 * @author Jagmeet
 *
 */
public interface IDriver {

	/**
	 * 
	 * @param robot
	 * @param direction
	 * @throws OverloadedException
	 * @throws BatteryDischarged
	 */
	void move(Robot robot, Direction direction) throws OverloadedException, BatteryDischarged;
	
	/**
	 * 
	 * @param robot
	 * @param distance
	 * @throws OverloadedException
	 * @throws BatteryDischarged
	 */
	void travel(Robot robot, Float distance) throws OverloadedException, BatteryDischarged;
}
