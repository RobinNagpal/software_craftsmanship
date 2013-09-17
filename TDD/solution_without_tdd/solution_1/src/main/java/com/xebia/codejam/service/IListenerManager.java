/**
 * 
 */
package com.xebia.codejam.service;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.xebia.codejam.model.DynamicProperties;

/**
 * @author Jagmeet
 *
 */
public interface IListenerManager {
	
	/**
	 * 
	 * @param property
	 * @param listener
	 */
	void addListener(DynamicProperties property, PropertyChangeListener listener);

	/**
	 * 
	 * @param property
	 * @param event
	 */
	void notifyListeners(DynamicProperties property, PropertyChangeEvent event);
}
