/**
 * 
 */
package com.xebia.codejam.exception;

/**
 * @author Jagmeet
 *
 */
public class BatteryDischarged extends BaseException {

	/**
	 * @param message
	 */
	public BatteryDischarged(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BatteryDischarged(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BatteryDischarged(String message, Throwable cause) {
		super(message, cause);
	}

}
