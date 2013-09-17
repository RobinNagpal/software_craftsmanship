package com.xebia.exceptions.battery;

import com.xebia.exceptions.ApplicationRuntimeException;

/**
 * Created with IntelliJ IDEA.
 * User: robin
 * Date: 19/6/13
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class InvalidChargePercentage extends ApplicationRuntimeException {

    public InvalidChargePercentage(String message) {
        super(message);
    }
}
