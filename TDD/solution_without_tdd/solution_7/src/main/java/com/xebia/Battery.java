package com.xebia;

import com.xebia.exceptions.battery.InvalidChargePercentage;

/**
 * Created with IntelliJ IDEA.
 * User: robin
 * Date: 19/6/13
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Battery {

    private double chargePercentage;

    public Battery(int chargePercentage) {
        if(chargePercentage < 0 || chargePercentage > 100) {
            throw new InvalidChargePercentage(chargePercentage + " is an invalid percentage and it can be only within 0 to 100 ");
        }
        this.chargePercentage=chargePercentage;
    }


    public double getChargePercentage() {
        return chargePercentage;
    }

    void setChargePercentage(double chargePercentage) {
        this.chargePercentage=chargePercentage;
    }
}
