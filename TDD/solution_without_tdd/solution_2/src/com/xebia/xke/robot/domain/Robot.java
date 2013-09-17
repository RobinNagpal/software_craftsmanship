package com.xebia.xke.robot.domain;

public abstract class Robot {
	
	protected IProcessor processor;
	protected Integer lowBatteryLimit ;
	protected Integer batteryRemained;
	
	


	public Robot(Integer lowBatteryLimit, Integer batteryRemained,
			IProcessor processor) {
		this.batteryRemained=batteryRemained;
		this.processor=processor;
		this.lowBatteryLimit=lowBatteryLimit;
	}

	public Robot() {
		
	}

	public Integer getLowBatteryLimit() {
		return lowBatteryLimit;
	}

	public void setLowBatteryLimit(Integer lowBatteryLimit) {
		this.lowBatteryLimit = lowBatteryLimit;
	}

	


	public Integer getBatteryRemained() {
		return batteryRemained;
	}

	public void setBatteryRemained(Integer batteryRemained) {
		this.batteryRemained = batteryRemained;
	}
	
	
	public IProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(IProcessor processor) {
		this.processor = processor;
	}
	
	
		

}
