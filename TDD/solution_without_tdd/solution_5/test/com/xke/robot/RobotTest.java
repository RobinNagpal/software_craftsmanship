package com.xke.robot;

import org.junit.Assert;
import org.junit.Test;
/**
 * 
 * @author anirudh
 *
 */
public class RobotTest {
	
	private Robot robot;
	
	/**
	 * Robot walks for 3.5 KM
	 */
	@Test
	public void testWithWeight0KgAndTravel3_5Test() {
		robot = new Robot(0,3.5);
		Assert.assertEquals(30.0, robot.calculateRemainingBattery(),0);
	}

	/**
	 * Robot walks for 2 Km carrying 3 Kg weight
	 */

	 @Test
	  public void testwith3KgAnd2Km(){
		 robot = new Robot(3, 2);
		 Assert.assertEquals(54.0, robot.calculateRemainingBattery(),0);
	 }
	 
	 /**
	  * Robot carries 12 Kg weight.
	  */
	 @Test
	 public void testOVerLoadWt12Kg(){
		 robot = new Robot(12, 0);
		 
	 }
	 
	 /**
	  * for less than 15 percent ; Robot Walks for 4Km and carries 6kg
	  */
	 @Test
	 public void testRobotHead(){
		 robot = new Robot(6,8);
		 robot.calculateRemainingBattery();
		 Assert.assertEquals("Low Battery",robot.getRobotHead());
	 }
}
