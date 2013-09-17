package com.xebia.xke.domain;

public class RobotChestBeepLight implements RobotBeepLight{

    private boolean beeping  = false;
   
    @Override
    public void startBeeping(BeepSignal signal) {
        if(signal == BeepSignal.OVERWEIGHT_SIGNAL){
            beeping = true;
            startBeeping();
        }
    }

    private void startBeeping() {
        System.out.println("Overweight chest Light Beep... Beep... Can't Move");
    }

    public boolean isBeeping() {
        return beeping;
    }

}
