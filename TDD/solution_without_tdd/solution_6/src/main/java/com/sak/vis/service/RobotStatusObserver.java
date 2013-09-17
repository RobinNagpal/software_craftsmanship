package com.sak.vis.service;

import com.sak.vis.Robot;
import com.sak.vis.domain.RobotStatus;

public interface RobotStatusObserver {
	void update(RobotStatus robotStatus, Robot robot);
}
