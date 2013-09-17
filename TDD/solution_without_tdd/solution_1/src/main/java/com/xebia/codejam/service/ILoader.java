/**
 * 
 */
package com.xebia.codejam.service;

import com.xebia.codejam.model.Robot;

/**
 * @author Jagmeet
 *
 */
public interface ILoader {
	/**
	 * 
	 * @param robot
	 * @param weight
	 */
	void loadWeight(Robot robot, Integer weight);
	
	/**
	 * 
	 * @param robot
	 * @param weight
	 */
	void addWeight(Robot robot, Integer weight);
	
	/**
	 * 
	 * @param robot
	 */
	void removeWeight(Robot robot);
	
	/**
	 * 
	 * @param robot
	 * @param weight
	 */
	void removeWeight(Robot robot, Integer weight);
}
