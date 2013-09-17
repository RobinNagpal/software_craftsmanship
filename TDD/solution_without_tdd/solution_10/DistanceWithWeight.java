package com.hi.cdi.logging;

public class DistanceWithWeight extends DistanceOnly {

    int weight;

    public DistanceWithWeight(Robot robot, int weight) {
        super(robot);
        this.weight = weight;
    }

    public double getRemainingBattery() {
        return robot.getRemainingBattery() - dischargeByWeight();
    }

    private double dischargeByWeight() {
        double extraBatteryUsedByWeight = 0;
        double extraBatteryUsedByWeightFinal = 0;
        double charge = 100;
        if (weight > 10) {
            String ledMessage = "Overweight";
            System.out.println(ledMessage);
            return 0;
        }
        int distanceInMeters = (int) (distance * 1000);
        for (int j = 100; j <= distanceInMeters;) {

            if (j % 1000 == 0) {
                extraBatteryUsedByWeight = weight * ((2 * charge) / 100);
                charge = charge - 2 - extraBatteryUsedByWeight;
                extraBatteryUsedByWeightFinal = extraBatteryUsedByWeight + extraBatteryUsedByWeightFinal;
            } else {
                charge = charge - 2;
            }
            if (charge < 15) {
                String light = "RED";
                String ledMessage = "Low Battery";
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

        return extraBatteryUsedByWeightFinal;
    }
}
