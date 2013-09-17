/**
 * 
 */
package com.xebia.decorators;

import com.xebia.Robot;

/**
 * Decorator for a weight lifting robot.
 * 
 */
public class LiftingRobotDecorator extends RobotDecorator {
    Robot robot;
    private int maxWeightLimit = 10;
    private int batterydischargePerKg = 2;
    private int weightToLift;

    public LiftingRobotDecorator(Robot robot) {
        super(robot);
        this.robot = robot;
        System.out.println("created lifting robot.");
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xebia.Robot#performAction(int)
     */
    public void performAction(int weightToLift) {
        this.weightToLift = weightToLift;
        System.out.println("The robot is lifting weight of: " + weightToLift + "Kgs.");
        if (weightToLift > maxWeightLimit) {
            giveWarning();
        }
        getBatteryStatus();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xebia.Robot#giveWarning()
     */
    public void giveWarning() {
        System.out.println("The Robot is Overweight");

    }

    private void getBatteryStatus() {
        String batteryLevel = robot.getBatteryLevel();
        super.remainingBatteryLevel = Integer.parseInt(batteryLevel) - (batterydischargePerKg * this.weightToLift);
        System.out.println("remaining battery is : " + remainingBatteryLevel + "%");

    }

    public String getBatteryLevel() {
        return String.valueOf(super.remainingBatteryLevel);
    }
}
