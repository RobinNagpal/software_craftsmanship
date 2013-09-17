package com.xebia;

import com.xebia.exceptions.OverWeightException;
import com.xebia.utils.ROBOT_CHEST_MESSAGE;

/**
 * Created with IntelliJ IDEA.
 * User: robin
 * Date: 19/6/13
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Robot {


    private final Battery battery;
    private double distanceCovered;
    private boolean headLightStatus;
    private ROBOT_CHEST_MESSAGE robot_chest_message = null;
    private double load;


    public Robot(Battery battery) {
        this.battery = battery;
        if (battery.getChargePercentage() < 15) {
            headLightStatus = true;
        }
    }

    public Battery getBattery() {
        return battery;
    }

    public double getDistanceCovered() {
        return distanceCovered;
    }

    public boolean isHeadLightOn() {
        return headLightStatus == true;
    }

    public void walk(double distance) {
        verifyLoad();


        if (distance > getMaxDistanceThatCanBeCovered()) {
            this.distanceCovered = getMaxDistanceThatCanBeCovered();
            getBattery().setChargePercentage(0);
        } else {
            this.distanceCovered = distance;
            double batteryPercentageConsumedByWalking = (distance / 5) * 100;
            double remainingChargePercentage = 100.0 - batteryPercentageConsumedByWalking - 2 * load;
            this.getBattery().setChargePercentage(remainingChargePercentage);
        }


        updateHeadLightStatus();

    }

    public ROBOT_CHEST_MESSAGE getChestMessage() {
        return this.robot_chest_message;
    }

    void updateHeadLightStatus() {
        if (getBattery().getChargePercentage() < 15) {
            this.headLightStatus = true;
        } else {
            this.headLightStatus = false;
        }
    }

    public void carry(double load) {
        this.load = load;
        verifyLoad();

    }

    void verifyLoad() {
        if (this.load > 10) {
            this.robot_chest_message = ROBOT_CHEST_MESSAGE.OVER_WEIGHT;
            throw new OverWeightException(load + " is more than allowed 10kgs of load");
        }
    }

    public double getMaxDistanceThatCanBeCovered() {
        return ((100 - 2 * load) * 5) / 100;
    }
}
