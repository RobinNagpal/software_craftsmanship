package com.xebia;

import com.xebia.Robot;
import com.xebia.mothers.RobotMother;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: robin
 * Date: 19/6/13
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class RobotDistanceTest {


    @Test
    public void shouldWalkForFiveKmsOnFullCharge() {
        // setup
        Robot robot = RobotMother.getHundredPercentChargedRobot();

        // Test
        robot.walk(5.0);

        //  Verify
        assertEquals(0.0, robot.getBattery().getChargePercentage(), 0.0);
    }

    @Test
    public void shouldHaveChargeRemainingForWalkLessThanFiveKms(){

        // setup
        Robot robot = RobotMother.getHundredPercentChargedRobot();

        // Test
        robot.walk(4.0);

        //  Verify
        assertTrue(robot.getBattery().getChargePercentage() > 0.0);
    }


    @Test
    public void shouldNotBeAbleToWalkForMoreThanFiveKilometers(){
        // setup
        Robot robot = RobotMother.getHundredPercentChargedRobot();

        // Test
        robot.walk(6.0);

        //  Verify
        assertTrue(robot.getDistanceCovered() == 5.0);
    }

}
