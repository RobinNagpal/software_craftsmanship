package com.xebia.xke;

import org.junit.Assert;
import org.junit.Test;

import com.xebia.xke.domain.GenXRobo;
import com.xebia.xke.domain.Robot;
import com.xebia.xke.domain.RobotBeepLight;
import com.xebia.xke.domain.RobotChestBeepLight;
import com.xebia.xke.domain.RobotHeadBeepLight;

/**
 * Unit test for simple App.
 */
public class RobotTest {

    @Test
    public void shouldNotRunWith15KGWeight() {
        Robot robot = new GenXRobo.RobotBuilder().movingSpeed(0.1F).build();
        robot.addBeepLight(new RobotHeadBeepLight());
        robot.addBeepLight(new RobotChestBeepLight());
        robot.move(15);
        for (RobotBeepLight beepLight : robot.getBeepLights()) {
            if (beepLight instanceof RobotChestBeepLight) {
                Assert.assertTrue(beepLight.isBeeping());
            }
        }
    }
    @Test
    public void shouldRunWith10KGWeight() {
        Robot robot = new GenXRobo.RobotBuilder().movingSpeed(0.1F).build();
        robot.addBeepLight(new RobotHeadBeepLight());
        robot.addBeepLight(new RobotChestBeepLight());
        robot.move(10);
        for (RobotBeepLight beepLight : robot.getBeepLights()) {
            if (beepLight instanceof RobotChestBeepLight) {
                Assert.assertTrue(!beepLight.isBeeping());
            }
        }
    }
    @Test
    public void shouldHighLightLowBattery() {
        Robot robot = new GenXRobo.RobotBuilder().movingSpeed(0.1F).build();
        robot.addBeepLight(new RobotHeadBeepLight());
        robot.addBeepLight(new RobotChestBeepLight());
        robot.move(10);
        for (RobotBeepLight beepLight : robot.getBeepLights()) {
            if (beepLight instanceof RobotHeadBeepLight) {
                Assert.assertTrue(beepLight.isBeeping());
            }
        }
    }
}
