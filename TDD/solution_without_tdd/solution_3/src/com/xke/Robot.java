package com.xke;

public class Robot {

    private Load load;
    private boolean overWeight;
    private float chargePercentage;

    public void makeMyRobotWalk(float distance){
        if(!overWeight || chargePercentage == 0){
            float chargePerKilometer = getChargePerKilometer();
            float distanceCanWalk = chargePercentage/chargePerKilometer;
            if(distance > distanceCanWalk)
                throw new RuntimeException("Hi can not walk this long !!!");
            float distanceCanWalkWithLightOff = (chargePercentage-15)/chargePerKilometer;
            if(distance <= distanceCanWalkWithLightOff){
                walk(distance);
            }
            else{
                walk(distanceCanWalkWithLightOff);
                turnOnLowBatterySignal();
                walk(distance - distanceCanWalkWithLightOff);
            }
            chargePercentage -= distance*chargePerKilometer;
        }
        else
            throw new RuntimeException("I can not walk :(");
    }

    public void putLoad(Load load){
        if(this.load == null){
            this.load = load;
            if(this.load.getWeight() > 10){
                overWeight = true;
                turnOnRedLight();
            }
        }
        else
            throw new RuntimeException("I am already loaded :(");
    }

    public void takeOffLoad(float weight){
        if(this.load != null){
            this.load = null;
            overWeight = false;
            turnOffRedLight();
        }
        else
            throw new RuntimeException("Hey, first put some weight at least !!!");
    }

    public void charge(){
        chargePercentage = 100;
    }

    public float getChargePercentage(){
        return chargePercentage;
    }

    public boolean isOverWeight(){
        return overWeight;
    }

    private float getChargePerKilometer(){
        float chargePerKilometer = 20;
        if(load != null)
            chargePerKilometer += load.getWeight() * 2;
        return chargePerKilometer;
    }

    private void turnOnRedLight(){

    }

    private void turnOffRedLight(){

    }

    private void turnOnLowBatterySignal(){

    }

    private void turnOffLowBatterySignal(){

    }

    private void walk(float distance){

    }
}
