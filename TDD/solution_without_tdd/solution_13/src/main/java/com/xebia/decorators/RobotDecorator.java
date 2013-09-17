package com.xebia.decorators;

import com.xebia.Robot;

abstract class RobotDecorator implements Robot {

    protected int maxBatteryLevels = 100;
    protected int remainingBatteryLevel;

    public RobotDecorator(Robot robot) {
    }

    abstract public void performAction(int size);

}
