package com.xke.robot;

/**
 * 
 * @author anirudh
 *
 */
public class Battery {
	
	private double remainingChargeInPercent;
	private static final double BATTERY_WARNING_LIMIT=15;
	
	public Battery(){
		this.remainingChargeInPercent=100;
	}

	public double getRemainingChargeInPercent() {
		return remainingChargeInPercent;
	}

	public boolean isBatteryLessThanLimit(){
		return remainingChargeInPercent<BATTERY_WARNING_LIMIT;
		
	}

	public void setRemainingChargeInPercent(double remainingChargeInPercent) {
		this.remainingChargeInPercent = remainingChargeInPercent;
	}
	
}
