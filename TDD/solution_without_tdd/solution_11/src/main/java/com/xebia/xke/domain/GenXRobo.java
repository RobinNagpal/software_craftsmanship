package com.xebia.xke.domain;

import java.util.ArrayList;
import java.util.List;

public class GenXRobo implements Robot {

    /**
     * Value of minBatteryLevelForBeep should be between 0 and 1
     */
    private float minBatteryLevelForBeep;

    /**
     * Discharge per Km for per Kg of weight value should be between 0 and 1
     */
    private float extraDisChargePerKg;
    /**
     * Value of batteryLevel should be between 0 and 1
     */

    private float batteryLavel;
    /**
     * Discharge per Km value should be between 0 and 1
     */
    private float walkingDischargeRate;
    /**
     * Speed in Km/sec
     */
    private float movingSpeed;

    List<RobotBeepLight> robotBeepLights = new ArrayList<RobotBeepLight>();

    /*
     * {@inheritDoc}
     */
    @Override
    public void move(int weight) {
        if (weight > 10) {
            sendBeepSignal(BeepSignal.OVERWEIGHT_SIGNAL);
            return;
        }
        int timeSeconds = 0;
        float batteyLvl = this.batteryLavel;
        float distanceCovered = 0;
        float dischargeRate = getDisChargeRate(weight);
        while (batteyLvl > 0) {
            distanceCovered = movingSpeed * timeSeconds;
            batteyLvl = (batteryLavel - dischargeRate * distanceCovered);
            if (batteyLvl < minBatteryLevelForBeep) {
                sendBeepSignal(BeepSignal.LOW_BATTERY_SIGNAL);
            }
            if(batteyLvl > 0){
                printRobotMovingStatus(timeSeconds, batteyLvl, distanceCovered);
            }
            timeSeconds++;
        }
    }

    /*
     * {@inheritDoc}
     */
    @Override
    public void addBeepLight(RobotBeepLight beepLight) {
        robotBeepLights.add(beepLight);
    }

    public List<RobotBeepLight> getBeepLights() {
        return robotBeepLights;
    }

    private void sendBeepSignal(BeepSignal signal) {
        for (RobotBeepLight beepLight : robotBeepLights) {
            beepLight.startBeeping(signal);
        }

    }

    private void printRobotMovingStatus(int timeSeconds, float batteyLvl, float distanceCovered) {
        System.out.print("Battery Status : " + Math.round(batteyLvl * 100) + " % || ");
        System.out.print("Distance Moved : " + distanceCovered + " Km ||");
        System.out.println("Time Lapsed : " + timeSeconds + " Seconds");
    }

    private float getDisChargeRate(int weight) {
        return walkingDischargeRate + weight * extraDisChargePerKg;
    }

    /**
     * Robot Builder
     */
    public static class RobotBuilder {

        private float movingSpeed = DEFAULT_MOVING_SPEED;
        private float minBatteryLevelForBeep = DEFAULT_MIN_BATTERY_LAVEL_FOR_BEEP;
        private float extraDisChargePerKg = DEFAULT_EXTRA_DISCHARGE_PER_KG;
        private float batteryLavel = DEFAULT_BATTERY_LEVEL;
        private float walkingDischargeRate = DEFAULT_WALKING_DISCHARGE_RATE;

        public RobotBuilder movingSpeed(float val) {
            movingSpeed = val;
            return this;
        }

        public RobotBuilder minBatteryLevelForBeep(float val) {
            minBatteryLevelForBeep = val;
            return this;
        }

        public RobotBuilder extraDisChargePerKg(int val) {
            extraDisChargePerKg = val;
            return this;
        }

        public RobotBuilder batteryLavel(float val) {
            batteryLavel = val;
            return this;
        }

        public RobotBuilder walkingDischargeRate(float val) {
            walkingDischargeRate = val;
            return this;
        }

        public GenXRobo build() {
            return new GenXRobo(this);
        }
    }

    private GenXRobo(RobotBuilder builder) {
        minBatteryLevelForBeep = builder.minBatteryLevelForBeep;
        extraDisChargePerKg = builder.extraDisChargePerKg;
        batteryLavel = builder.batteryLavel;
        walkingDischargeRate = builder.walkingDischargeRate;
        movingSpeed = builder.movingSpeed;

    }

}
