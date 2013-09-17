import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sak.vis.Robot;
import com.sak.vis.RobotMainController;
import com.sak.vis.domain.LightStatus;

public class RobotTest {
	@Test
	public void testWalkForThreeAndHalfKilometeres() throws Exception {
		Robot robot = RobotMainController.setUpRobot();
		robot.walk(3.5);
		assertEquals(30.0, robot.getBattery(), 1);
	}

	@Test
	public void testRobotWalksFor2KmCarrying3KgWeight() throws Exception {
		Robot robot = RobotMainController.setUpRobot();
		robot.setBattery(100);
		robot.setCarryWeight(2);
		robot.walk(3.5);
		assertEquals(28.8, robot.getBattery(), 0.3);
	}

	@Test
	public void testRobotCarries12KgWeight() throws Exception {
		Robot robot = RobotMainController.setUpRobot();
		robot.setCarryWeight(12);

		assertEquals(LightStatus.ON, robot.getChestLedDisplay());
		
		robot.walk(2);
	}

}
