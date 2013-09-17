package com.xebia.xke.robot.generator;

import java.util.HashMap;
import java.util.Map;

import com.xebia.xke.robot.domain.IProcessor.Task;
import com.xebia.xke.robot.domain.PrototypeProcessor;
import com.xebia.xke.robot.domain.PrototypeRobot;

/**the follwoing class can be used as a factory for generating robots .The configuration of the robot can be fed into the system**/
public class RobotGenerator {
	
	
	public static void main(String str[])
	{
		PrototypeRobot robot=new PrototypeRobot(5,15,10,2,"save me",100,new PrototypeProcessor());
		
		Map tasks=new HashMap();
		tasks.put(Task.WALK, 5);
		tasks.put(Task.CARRY_LOAD, 5);
		
		
		robot.performTasks(tasks);
		
	}

}
