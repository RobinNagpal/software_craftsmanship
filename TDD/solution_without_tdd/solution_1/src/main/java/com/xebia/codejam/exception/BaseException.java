/**
 * 
 */
package com.xebia.codejam.exception;

/**
 * @author Jagmeet
 *
 */
public class BaseException extends Exception {

	private static final long serialVersionUID = -8097371171932549745L;

	/**
	 * @param message
	 */
	public BaseException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BaseException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

}
