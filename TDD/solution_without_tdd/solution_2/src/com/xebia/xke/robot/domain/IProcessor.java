package com.xebia.xke.robot.domain;

import java.util.Map;

public interface IProcessor {
	
	
	
 static enum Task {
		
		WALK("Walk"),
		CARRY_LOAD("Carry Load");
			
        private String taskDesc;
		
		private Task(String taskDesc) {
		
            this.taskDesc = taskDesc;
	    }
		
		public String getTaskDesc() {
			return taskDesc;
		}

  }

 
 public  void processTasks(Map<Task,Integer> tasks, PrototypeRobot robot);
 public  Integer computeBatteryUsage(Map<Task,Integer> tasks, PrototypeRobot robot);
 
 
}
