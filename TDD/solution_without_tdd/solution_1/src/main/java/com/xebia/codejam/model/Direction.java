/**
 * 
 */
package com.xebia.codejam.model;

/**
 * @author Jagmeet
 *
 */
public enum Direction {
	LEFT(0), RIGHT(0);
	
	private Integer chargeConsumption;
	
	/**
	 * 
	 * @param chargeConsumption
	 */
	private Direction(Integer chargeConsumption) {
		this.chargeConsumption = chargeConsumption;
	}
	
	public Integer getChargeConsumption() {
		return chargeConsumption;
	}
}