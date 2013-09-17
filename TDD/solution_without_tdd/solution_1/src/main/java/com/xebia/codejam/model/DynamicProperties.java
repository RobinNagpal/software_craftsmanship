/**
 * 
 */
package com.xebia.codejam.model;

/**
 * @author Jagmeet
 *
 */
public enum DynamicProperties {
	CURRENT_CHARGE("currentCharge"), CURRENT_WEIGHT("currentWeight");
	
	private String propertyName;
	
	/**
	 * 
	 * @param propertyName
	 */
	private DynamicProperties(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public String getPropertyName() {
		return propertyName;
	};
}
