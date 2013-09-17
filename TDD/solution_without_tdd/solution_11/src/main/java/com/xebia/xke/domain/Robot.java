package com.xebia.xke.domain;

import java.util.List;

public interface Robot {
    
    public static final float DEFAULT_MIN_BATTERY_LAVEL_FOR_BEEP = 0.15F;
    public static final float DEFAULT_EXTRA_DISCHARGE_PER_KG = 0.02F;
    public static final float DEFAULT_WALKING_DISCHARGE_RATE = 0.2F;
    public static final float DEFAULT_MOVING_SPEED = 0.1F;
    public static final float DEFAULT_BATTERY_LEVEL = 1F;
    
    public abstract void move(int weight);
    public abstract void addBeepLight(RobotBeepLight beepLight);
    public abstract List<RobotBeepLight> getBeepLights();

}