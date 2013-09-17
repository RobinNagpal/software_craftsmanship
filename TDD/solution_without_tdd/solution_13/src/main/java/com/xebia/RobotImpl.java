/**
 * 
 */
package com.xebia;

/**
 * @author user
 * 
 */
public class RobotImpl implements Robot {

    public void performAction(int sizeOfAction) {
        System.out.println("Robot Initialized");
    }

    public String getBatteryLevel() {
        return "100";
    }

}
