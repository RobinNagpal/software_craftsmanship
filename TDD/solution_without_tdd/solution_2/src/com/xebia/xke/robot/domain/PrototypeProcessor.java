package com.xebia.xke.robot.domain;

import java.util.Map;

public class PrototypeProcessor implements IProcessor {
	
	
	
	public  void processTasks(Map<Task,Integer> tasks, PrototypeRobot robot)
	{

		if(robot.getBatteryRemained()<15 && tasks.containsKey(Task.WALK))
				{
			    robot.displayLowBatteryAlert();
				}
		
		if(tasks.containsKey(Task.CARRY_LOAD) && (tasks.get(Task.CARRY_LOAD) > robot.getLoadCapacity()))
		       {
			    robot.displayOverweightAlert();
		       }
		
		System.out.println("All Ok!!Move on");
         int batteryAvailable=robot.getBatteryRemained();
		
		System.out.println("Battery Available : "+batteryAvailable);
		 int batteryToBeUsed=computeBatteryUsage(tasks,robot);
		
	
		if(tasks.containsKey(Task.WALK))
		{
	    robot.walk();
		}

        if(tasks.containsKey(Task.CARRY_LOAD))
        {
	    robot.carryLoad();
        }
		
        robot.setBatteryRemained(batteryAvailable-batteryToBeUsed);
	}
	
	
	public  Integer computeBatteryUsage(Map<Task,Integer> tasks, PrototypeRobot robot){
		
		
		
	    Integer batteryUsagePerKm=0;
	    
	    if( (tasks.containsKey(Task.WALK)) && ! (tasks.containsKey(Task.CARRY_LOAD)))
	    {
	    	batteryUsagePerKm=100/robot.getDistancePerCharge();
	    	System.out.println("For only walk battery usage per km : "+batteryUsagePerKm);
	    	
	    } else if( (tasks.containsKey(Task.WALK)) && (tasks.containsKey(Task.CARRY_LOAD)))
	    {
	    	batteryUsagePerKm=(100/robot.getDistancePerCharge())+(2*tasks.get(Task.CARRY_LOAD)) ;
	    	System.out.println("For both walk and carry load  battery usage per km : "+batteryUsagePerKm);
	    	
	    }
	    
	    int batteryToBeUsed=batteryUsagePerKm*tasks.get(Task.WALK);
	    System.out.println("Battery to be Consumed : "+batteryToBeUsed);
	    
	   return batteryToBeUsed;
	    
		
	}
	

}
