/**
 * 
 */
package com.xebia.codejam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xebia.codejam.config.AppConfig;
import com.xebia.codejam.exception.BatteryDischarged;
import com.xebia.codejam.exception.OverloadedException;
import com.xebia.codejam.model.Robot;
import com.xebia.codejam.service.IDriver;
import com.xebia.codejam.service.ILoader;
import com.xebia.codejam.util.CounterUtil;

/**
 * @author Jagmeet
 *
 */
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		CounterUtil counterUtil = context.getBean(CounterUtil.class);
		IDriver driver = context.getBean(IDriver.class);
		ILoader loader = context.getBean(ILoader.class);

		Robot robot = new Robot(counterUtil.getNextId(Robot.class));
		System.out.println("Initial State:\n" + robot.toString());
		try {
			driver.travel(robot, 3.5f);
		} catch (OverloadedException e) {
			System.err.println(e.getMessage());
		} catch (BatteryDischarged e) {
			System.err.println(e.getMessage());
		}
		System.out.println("After Travel:\n" + robot.toString());

		robot = new Robot(counterUtil.getNextId(Robot.class));
		System.out.println("Initial State:\n" + robot.toString());
		try {
			loader.addWeight(robot, 3);
			driver.travel(robot, 2f);
		} catch (OverloadedException e) {
			System.err.println(e.getMessage());
		} catch (BatteryDischarged e) {
			System.err.println(e.getMessage());
		}
		System.out.println("After Travel:\n" + robot.toString());

		robot = new Robot(counterUtil.getNextId(Robot.class));
		System.out.println("Initial State:\n" + robot.toString());
		try {
			loader.addWeight(robot, 12);
			driver.travel(robot, 1f);
		} catch (OverloadedException e) {
			System.err.println(e.getMessage());
		} catch (BatteryDischarged e) {
			System.err.println(e.getMessage());
		}
		System.out.println("After Travel:\n" + robot.toString());

	}
}
