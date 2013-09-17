/**
 * 
 */
package com.xebia.codejam.service.impl;

import org.springframework.stereotype.Component;

import com.xebia.codejam.common.IConstants;
import com.xebia.codejam.model.Robot;
import com.xebia.codejam.service.ILoader;

/**
 * @author Jagmeet
 *
 */
@Component
public class LoaderImpl implements ILoader {

	/*
	 * (non-Javadoc)
	 * @see com.xebia.codejam.service.ILoader#loadWeight(com.xebia.codejam.model.Robot, java.lang.Integer)
	 */
	@Override
	public void loadWeight(Robot robot, Integer weight) {
		robot.setCurrentWeight(weight);
	}

	/*
	 * (non-Javadoc)
	 * @see com.xebia.codejam.service.ILoader#addWeight(com.xebia.codejam.model.Robot, java.lang.Integer)
	 */
	@Override
	public void addWeight(Robot robot, Integer weight) {
		robot.setCurrentWeight(robot.getCurrentWeight() + weight);
	}

	/*
	 * (non-Javadoc)
	 * @see com.xebia.codejam.service.ILoader#removeWeight(com.xebia.codejam.model.Robot)
	 */
	@Override
	public void removeWeight(Robot robot) {
		robot.setCurrentWeight(IConstants.EMPTY_WEIGHT);
	}

	/*
	 * (non-Javadoc)
	 * @see com.xebia.codejam.service.ILoader#removeWeight(com.xebia.codejam.model.Robot, java.lang.Integer)
	 */
	@Override
	public void removeWeight(Robot robot, Integer weight) {
		if (robot.getCurrentWeight() >= weight) {
			robot.setCurrentWeight(robot.getCurrentWeight() - weight);
		} else {
			robot.setCurrentWeight(IConstants.EMPTY_WEIGHT);
		}
	}
}
