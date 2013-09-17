package com.xke.robot;

/**
 * 
 * @author anirudh
 *
 */
public class Robot {
	
	private final static double WEIGHT_LIMIT =10;
	private final static double WALKING_LIMIT_PER_CHARGE=5;
	private final static String OVERWEIGHT_WARNING="Overweight";
	private Battery battery;
	private double carriedWeight;
	private double distanceTravelledInKm;
	private StringBuilder robotHead;
	
	public Robot(double carriedWeight,double distanceTravelledInKm){
		
		this.carriedWeight=carriedWeight;
		if(isOverWeight()){
			System.out.println(OVERWEIGHT_WARNING);
		}else{
			this.battery=new Battery();
			this.distanceTravelledInKm=distanceTravelledInKm;
			this.robotHead= new StringBuilder("battery is fine");
		}
	}
	
	public boolean isOverWeight(){
		return carriedWeight>WEIGHT_LIMIT;
	}
	
	public double calculateRemainingBattery(){
		double remainingBattery = battery.getRemainingChargeInPercent()-
				calculateBatteryConsumedByCarryingWeightAndWalk();
		battery.setRemainingChargeInPercent(remainingBattery);
		if(battery.isBatteryLessThanLimit()){
			robotHead=new StringBuilder("Low Battery");
		}
		return remainingBattery;
	}
	
	
	private double calculateBatterConsumedByWalk(){
		return (100/WALKING_LIMIT_PER_CHARGE)*distanceTravelledInKm;
	}
	
	private double calculateBatteryConsumedByCarryingWeightAndWalk(){
		return calculateBatterConsumedByWalk()+(2*carriedWeight);
	}

	public String getRobotHead() {
		return new String(robotHead);
	}
}
