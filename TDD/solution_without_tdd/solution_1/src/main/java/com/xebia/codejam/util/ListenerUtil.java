/**
 * 
 */
package com.xebia.codejam.util;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xebia.codejam.model.DynamicProperties;
import com.xebia.codejam.service.IListenerManager;

/**
 * @author Jagmeet
 *
 */
@Component
public class ListenerUtil {
	
	private static IListenerManager listenerManager;
	
	/**
	 * 
	 * @param property
	 * @param listener
	 */
	public static void addListener(DynamicProperties property, PropertyChangeListener listener) {
		listenerManager.addListener(property, listener);
	}
	
	/**
	 * 
	 * @param property
	 * @param event
	 */
	public static void notifyListeners(DynamicProperties property, PropertyChangeEvent event) {
		listenerManager.notifyListeners(property, event);
	}
	
	/**
	 * 
	 * @param listenerManager
	 */
	@Autowired
	public void setListenerManager(IListenerManager listenerManager) {
		ListenerUtil.listenerManager = listenerManager;
	}
}
