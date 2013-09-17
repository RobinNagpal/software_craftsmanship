package com.xebia.xke;

import com.xebia.xke.domain.GenXRobo;
import com.xebia.xke.domain.Robot;
import com.xebia.xke.domain.RobotChestBeepLight;
import com.xebia.xke.domain.RobotHeadBeepLight;

/**
 * Hello world!
 * 
 */
public class App {
    public static void main(String[] args) {
        Robot robot = new GenXRobo.RobotBuilder().movingSpeed(0.1F).build();
        robot.addBeepLight(new RobotHeadBeepLight());
        robot.addBeepLight(new RobotChestBeepLight());
        robot.move(10);
        System.out.println("===DONE===");
    }
}
