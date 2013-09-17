package com.xke;

import junit.framework.Assert;
import org.junit.Test;

public class RobotTests {

    @Test
    public void testPutLoad(){
        Robot robot = new Robot();
        Load load = new Load();
        load.setWeight(5);
        robot.putLoad(load);
        try{
            load.setWeight(15);
            robot.putLoad(load);
            Assert.fail("Should not have reached here");
        }
        catch (RuntimeException exp){
        }
    }

    @Test
    public void testForOverLoad(){
        Robot robot = new Robot();
        Load load = new Load();
        load.setWeight(15);
        robot.putLoad(load);
        Assert.assertTrue(robot.isOverWeight());
    }

    @Test
    public void testTakeOffLoad(){
        Robot robot = new Robot();
        Load load = new Load();
        robot.putLoad(load);
        try{
            robot.putLoad(load);
            Assert.fail("Should not have reached here");
        }
        catch (RuntimeException exp){
        }
    }

    @Test
    public void testMakeMyRobotWalkWhenOverLoaded(){
        Robot robot = new Robot();
        Load load = new Load();
        load.setWeight(15);
        robot.putLoad(load);
        try{
            robot.makeMyRobotWalk(5);
            Assert.fail("Should not have reached here");
        }
        catch (RuntimeException exp){
        }
    }

    @Test
    public void testMakeMyRobotWalkWhenBetteryDown(){
        Robot robot = new Robot();
        Load load = new Load();
        load.setWeight(5);
        robot.putLoad(load);
        try{
            robot.makeMyRobotWalk(5);
            Assert.fail("Should not have reached here");
        }
        catch (RuntimeException exp){
        }
    }

    @Test
    public void testMakeMyRobotWalkBeyondCapacity(){
        Robot robot = new Robot();
        robot.charge();
        try{
            robot.makeMyRobotWalk(15);
            Assert.fail("Should not have reached here");
        }
        catch (RuntimeException exp){
        }
        robot.charge();
        Load load = new Load();
        load.setWeight(10);
        robot.putLoad(load);
        try{
            robot.makeMyRobotWalk(3);
            Assert.fail("Should not have reached here");
        }
        catch (RuntimeException exp){
        }
    }

    @Test
    public void testMakeMyRobotWalkSuccessfully(){
        Robot robot = new Robot();
        robot.charge();
        robot.makeMyRobotWalk(5);
        Assert.assertTrue(robot.getChargePercentage() == 0);
        robot.charge();
        Load load = new Load();
        load.setWeight(2);
        robot.putLoad(load);
        robot.makeMyRobotWalk(4);
    }
}