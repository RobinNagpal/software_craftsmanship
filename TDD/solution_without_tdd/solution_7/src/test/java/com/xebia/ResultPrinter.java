package com.xebia;

import com.xebia.mothers.RobotMother;

/**
 * Created with IntelliJ IDEA.
 * User: robin
 * Date: 19/6/13
 * Time: 6:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResultPrinter {

    public static void main(String[] args){
        Robot robot = RobotMother.getHundredPercentChargedRobot();
        robot.walk(3.5);
        System.out.println(" Battery Percentage remaining after walking 3.5 kms " + robot.getBattery().getChargePercentage());

        Robot robot1 = RobotMother.getHundredPercentChargedRobot();
        robot1.carry(3);
        robot1.walk(2);
        System.out.println(" Battery Percentage remaining after walking 2 kms " + robot1.getBattery().getChargePercentage());

        Robot robot2 =     RobotMother.getHundredPercentChargedRobot();
        robot2.carry(12);
    }
}
