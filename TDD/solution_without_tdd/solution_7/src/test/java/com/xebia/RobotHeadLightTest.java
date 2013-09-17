package com.xebia;

import com.xebia.Robot;
import com.xebia.mothers.RobotMother;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: robin
 * Date: 19/6/13
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class RobotHeadLightTest {


    @Test
    public void shouldLitLightForBatteryLessThanFifteenPercent() {
        // setup
        Robot robot  = RobotMother.getRobot(14);


        //verify the status
        assertTrue(robot.isHeadLightOn());

    }

    @Test
    public void shouldNotLitLightForBatteryMoreThanOrEqualToFifteenPercent() {
        // setup
        Robot robot  = RobotMother.getRobot(15);


        //verify the status
        assertFalse(robot.isHeadLightOn());

    }


    @Test
    public void shouldUpdateLightStatusWhileTravelling(){
        // setup
        Robot robot = RobotMother.getHundredPercentChargedRobot();
        Robot robotSpy = spy(robot);

        // exercise
        robotSpy.walk(4.0);

        //Verify
        verify(robotSpy).updateHeadLightStatus();
    }

    @Test
    public void shouldLitHeadLightWhileTravelling(){
        // setup
        Robot robot = RobotMother.getHundredPercentChargedRobot();

        // exercise
        robot.walk(4.9);

        //asset
        assertTrue(robot.isHeadLightOn());
    }


}
