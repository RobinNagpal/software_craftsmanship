/**
 * 
 */
package com.xebia.codejam.listeners;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xebia.codejam.model.DynamicProperties;
import com.xebia.codejam.model.Robot;
import com.xebia.codejam.service.IListenerManager;

/**
 * @author Jagmeet
 *
 */
@Component
public class WeightListener implements PropertyChangeListener {

	/**
	 * 
	 * @param listenerManager
	 */
	@Autowired
	public WeightListener(IListenerManager listenerManager) {
		listenerManager.addListener(DynamicProperties.CURRENT_WEIGHT, this);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		Robot robot = (Robot) event.getSource();
		if (robot.getCurrentWeight() > robot.getWeightCapacity()) {
			System.err.println("ROBOT OVERLOADED. OVERLOADED FLASHING.....");
		}
	}

}
