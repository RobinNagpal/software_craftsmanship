package com.xebia;

import com.xebia.exceptions.OverWeightException;
import com.xebia.mothers.RobotMother;
import com.xebia.utils.ROBOT_CHEST_MESSAGE;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: robin
 * Date: 19/6/13
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class RobotLoadTest {

    @Test(expected = OverWeightException.class)
    public void shouldNotBeAbleToCarryMoreThanTenKg() {
        //setup
        Robot robot = RobotMother.getHundredPercentChargedRobot();
        double load = 11.0;

        robot.carry(load);
    }

    @Test
    public void shouldShowOverWeightWhenAskedToCarryMoreThanTenKg() {
        //setup
        Robot robot = RobotMother.getHundredPercentChargedRobot();
        double load = 11.0;

        try {
            robot.carry(load);
        } catch (OverWeightException e) {
            // do nothing
        }

        assertTrue(robot.getChestMessage() !=null && robot.getChestMessage().equals(ROBOT_CHEST_MESSAGE.OVER_WEIGHT));
    }


    @Test(expected = OverWeightException.class)
    public void shouldNotWalkWhenOverWeight() {
        //setup
        Robot robot = RobotMother.getHundredPercentChargedRobot();
        double load = 11.0;

        try {
            robot.carry(load);
        } catch (OverWeightException e) {
            // do nothing
        }

        robot.walk(3);

    }

    @Test
    public void shouldVerifyLoadWhenAskedToWalk() {

        //setup
        Robot robot = RobotMother.getHundredPercentChargedRobot();
        Robot robotSpy = spy(robot);


        // exercise
        try {
            robotSpy.walk(4);
        } catch (OverWeightException e) {
            // do nothing
        }


        // verify
        verify(robotSpy).verifyLoad();

    }

    @Test
    public void shouldVerifyLoadBeforeWalking() {

        //setup
        Robot robot = RobotMother.getHundredPercentChargedRobot();
        Robot robotSpy = spy(robot);
        double load = 11.0;

        try {
            robotSpy.carry(load);
        } catch (OverWeightException e) {
            // do nothing
        }


        // exercise
        try {
            robotSpy.walk(4);
        } catch (OverWeightException e) {
            // do nothing
        }


        // verify
        assertEquals(0.0, robotSpy.getDistanceCovered(), 0.0);

    }


    @Test
    public void shouldBeAbleToWalkFourKmsWithTenKgWeight() {
        Robot robot = RobotMother.getHundredPercentChargedRobot();
        robot.carry(10);


        double maxDistanceThatCanBeCovered = robot.getMaxDistanceThatCanBeCovered();


        assertEquals(4.0, maxDistanceThatCanBeCovered, 0.0);

    }



}
