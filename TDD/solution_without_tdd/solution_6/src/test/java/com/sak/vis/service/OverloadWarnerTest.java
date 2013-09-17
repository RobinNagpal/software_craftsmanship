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
public class OverloadWarnerTest {

	@Mock
	private Robot robot;

	private OverloadWarner warner;

	@Test
	public void shouldSwitchOnWarningLightForOverload() throws Exception {
		warner = new OverloadWarner();

		warner.update(new RobotStatus(100,11), robot);

		verify(robot).setChestLedDisplay(LightStatus.ON);

		warner.update(new RobotStatus(100,10), robot);

		verify(robot).setChestLedDisplay(LightStatus.OFF);
	}

}
