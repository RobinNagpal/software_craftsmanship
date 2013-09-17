/**
 * 
 */
package com.xebia.codejam.exception;

/**
 * @author Jagmeet
 *
 */
public class OverloadedException extends BaseException {

	private static final long serialVersionUID = 1175718608444744924L;

	public OverloadedException(String message, Throwable cause) {
		super(message, cause);
	}

	public OverloadedException(String message) {
		super(message);
	}

	public OverloadedException(Throwable cause) {
		super(cause);
	}

	
}
