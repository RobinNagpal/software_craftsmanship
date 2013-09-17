package com.sak.vis.service;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sak.vis.Robot;
import com.sak.vis.domain.LightStatus;
import com.sak.vis.domain.RobotStatus;

@RunWith(MockitoJUnitRunner.class)
public class BatteryDischargeWarnerTest {

	@Mock
	private Robot robot;

	private BatteryDischargeWarner warner;

	@Test
	public void shouldSwitchOnWarningLightForLowBattery() throws Exception {
		warner = new BatteryDischargeWarner();

		warner.update(new RobotStatus(14,10), robot);

		verify(robot).setRedHeadLight(LightStatus.ON);

		warner.update(new RobotStatus(15,10), robot);

		verify(robot).setRedHeadLight(LightStatus.OFF);
	}

}
