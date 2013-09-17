package com.hi.cdi.logging;

import org.junit.Test;

public class TestRobot {

    @Test
    public void testScenario1() {
        Robot robot = new DistanceOnly(new SimpleRobot(), 3.5);
        System.out.println("Scenario 1");
        System.out.println("Remaining Battery " + robot.getRemainingBattery());
    }

    @Test
    public void testScenario2() {
        Robot robot = new DistanceWithWeight(new DistanceOnly(new SimpleRobot(), 2), 3);
        System.out.println("Scenario 2");
        System.out.println("Remaining Battery " + robot.getRemainingBattery());
    }

    @Test
    public void testScenario3() {
        Robot robot = new DistanceWithWeight(new DistanceOnly(new SimpleRobot(), 0), 12);
        System.out.println("Scenario 3");
        System.out.println("Remaining Battery " + robot.getRemainingBattery());
    }

    @Test
    public void testScenario4() {
        Robot robot = new DistanceWithWeight(new DistanceOnly(new SimpleRobot(), 0), 1);
        System.out.println("Scenario 4");
        System.out.println("Remaining Battery " + robot.getRemainingBattery());
    }

    @Test
    public void testScenario5() {
        Robot robot = new DistanceOnly(new SimpleRobot(), 6);
        System.out.println("Scenario 5");
        System.out.println("Remaining Battery " + robot.getRemainingBattery());
    }

}
