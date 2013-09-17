package com.xebia.xke.domain;

public class RobotHeadBeepLight implements RobotBeepLight{

    private boolean beeping  = false;
    @Override
    public void startBeeping(BeepSignal signal) {
        if(signal == BeepSignal.LOW_BATTERY_SIGNAL){
            beeping = true;
            startBeeping();
        }
    }

    private void startBeeping() {
        System.out.println("Battery Low Beep... Beep...");
        System.out.println();
        System.out.println();
    }

    public boolean isBeeping() {
        return beeping;
    }

}
