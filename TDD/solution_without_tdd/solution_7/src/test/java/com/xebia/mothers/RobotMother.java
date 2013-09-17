package com.xebia.mothers;

import com.xebia.Battery;
import com.xebia.Robot;

/**
 * Created with IntelliJ IDEA.
 * User: robin
 * Date: 19/6/13
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class RobotMother {
    public static Robot getHundredPercentChargedRobot() {
        Battery battery = new Battery(100);
        return new Robot(battery);
    }

    public static Robot getRobot(int chargePercentage) {
        Battery battery = new Battery(chargePercentage);
        return new Robot(battery);
    }
}
