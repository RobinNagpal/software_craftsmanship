package com.xebia;

import com.xebia.decorators.LiftingRobotDecorator;
import com.xebia.decorators.WalkingRobotDecorator;

public class RunRobot {

    public static void main(String[] args) {
        runRobotWalksFor3Kilometers();
        System.out.println("******************************************");
        runRobotLift20Kg();
        System.out.println("******************************************");
        runRobotWalks3KmAndLifts20Kg();

    }

    private static void runRobotWalks3KmAndLifts20Kg() {
        Robot dummyRobot = new RobotImpl();
        dummyRobot = new WalkingRobotDecorator(dummyRobot);
        dummyRobot.performAction(3);
        dummyRobot.getBatteryLevel();
        dummyRobot = new LiftingRobotDecorator(dummyRobot);
        dummyRobot.performAction(20);
        dummyRobot.getBatteryLevel();

    }

    private static void runRobotLift20Kg() {
        Robot dummyRobot = new LiftingRobotDecorator(new RobotImpl());
        dummyRobot.performAction(20);
        dummyRobot.getBatteryLevel();

    }

    private static void runRobotWalksFor3Kilometers() {
        Robot dummyRobot = new WalkingRobotDecorator(new RobotImpl());
        dummyRobot.performAction(3);
        dummyRobot.getBatteryLevel();

    }
}
