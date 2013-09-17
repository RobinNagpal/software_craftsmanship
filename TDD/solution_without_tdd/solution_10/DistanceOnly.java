package com.hi.cdi.logging;

public class DistanceOnly extends SimpleRobot {

    protected Robot robot;
    double distance;
    double charge;

    public DistanceOnly(Robot robot, double distance) {
        this.robot = robot;
        this.distance = distance;
        this.charge = robot.getRemainingBattery();
    }

    public DistanceOnly(Robot robot) {
        DistanceOnly distanceOnly = (DistanceOnly) robot;
        this.robot = robot;
        this.distance = distanceOnly.distance;
        this.charge = robot.getRemainingBattery();
    }

    @Override
    public double getRemainingBattery() {
        double charge = 100;
        String light;
        String ledMessage;

        int distanceInMeters = (int) (distance * 1000);

        for (int j = 100; j <= distanceInMeters;) {

            charge = charge - 2;
            if (charge < 15) {
                light = "RED";
                ledMessage = "Low Battery";
                System.out.println("Light " + light);
                System.out.println(ledMessage);
                // System.out.println("Distance covered " + j);
                return charge;
            }
            if (charge < 0) {
                return 0;
            }
            j = j + 100;
        }
        return charge;
    }

}
