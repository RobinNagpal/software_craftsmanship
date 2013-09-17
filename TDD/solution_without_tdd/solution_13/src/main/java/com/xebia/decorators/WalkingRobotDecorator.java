/**
 * 
 */
package com.xebia.decorators;

import com.xebia.Robot;

/**
 * Decorator for a walking robot.
 * 
 */
public class WalkingRobotDecorator extends RobotDecorator {
    Robot robot;
    private int perKmBatteryDischarge = 20;
    private int kilometersToWalk;

    public WalkingRobotDecorator(Robot robot) {
        super(robot);
        this.robot = robot;
        System.out.println("created walking robot");
    }

    public void performAction(int kmToWalk) {
        this.kilometersToWalk = kmToWalk;
        System.out.println("the robot is walking for : " + kmToWalk + "KM");
        getBatteryStatus();

    }

    private void giveWarning() {
        System.out.println("Battery is low");
    }

    private void getBatteryStatus() {
        String batteryLevel = robot.getBatteryLevel();
        super.remainingBatteryLevel = Integer.parseInt(batteryLevel) - (kilometersToWalk * perKmBatteryDischarge);
        if (super.remainingBatteryLevel < 15) {
            giveWarning();
        }
        System.out.println("The remaining battery is :" + remainingBatteryLevel + " %");
    }
    
    public String getBatteryLevel(){
        return String.valueOf(super.remainingBatteryLevel);
    }

}
