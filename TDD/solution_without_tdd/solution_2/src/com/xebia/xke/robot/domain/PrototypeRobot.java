package com.xebia.xke.robot.domain;

import java.util.Map;

import com.xebia.xke.robot.domain.IProcessor.Task;



public  class PrototypeRobot extends Robot {
	 
	protected Integer loadCapacity;
	protected String overloadMessage;	
	protected Integer distancePerCharge;	
	protected Integer loadPerKgBatteryOverhead;
	
	
  public PrototypeRobot(Integer distancePerCharge, Integer lowBatteryLimit,
			Integer loadCapacity,Integer loadPerKgBatteryOverhead, String overloadMessage,
			Integer batteryRemained,IProcessor processor) {
		super(lowBatteryLimit,batteryRemained,processor);
		this.distancePerCharge = distancePerCharge;
		this.loadCapacity = loadCapacity;
		this.loadPerKgBatteryOverhead=loadPerKgBatteryOverhead;
		this.overloadMessage = overloadMessage;
		this.batteryRemained = batteryRemained;
	}

	
	public PrototypeRobot() {
	super();
    }


	public Integer getLoadPerKgBatteryOverhead() {
		return loadPerKgBatteryOverhead;
	}

	public void setLoadPerKgBatteryOverhead(Integer loadPerKgBatteryOverhead) {
		this.loadPerKgBatteryOverhead = loadPerKgBatteryOverhead;
	}


	public Integer getDistancePerCharge() {
		return distancePerCharge;
	}


	public void setDistancePerCharge(Integer distancePerCharge) {
		this.distancePerCharge = distancePerCharge;
	}
	
	public Integer getLoadCapacity() {
		return loadCapacity;
	}

	public void setLoadCapacity(Integer loadCapacity) {
		this.loadCapacity = loadCapacity;
	}


	public String getOverloadMessage() {
		return overloadMessage;
	}

	public void setOverloadMessage(String overloadMessage) {
		this.overloadMessage = overloadMessage;
	}

	
	public void performTasks(Map<Task,Integer> tasks)
	{
		
		System.out.println("Performing tasks :" +tasks.size());
		
		processor.processTasks(tasks,this);
	}

	

	public void displayLowBatteryAlert() {
		System.out.println("switching on the red light light as low battery");
		System.exit(1);
		
	}

	public void displayOverweightAlert() {
		System.out.println("displaying on the led "+overloadMessage);
		System.exit(1);
		
	}

	public void walk() {
		System.out.println("walking");
		
	}

	public void carryLoad() {
		System.out.println("carrying load");
		
	}
	
	
	
	
}
