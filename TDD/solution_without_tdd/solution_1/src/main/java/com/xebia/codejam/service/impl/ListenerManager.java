/**
 * 
 */
package com.xebia.codejam.service.impl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.xebia.codejam.model.DynamicProperties;
import com.xebia.codejam.service.IListenerManager;

/**
 * @author Jagmeet
 *
 */
@Component
public class ListenerManager implements IListenerManager {
	
	private Map<DynamicProperties, List<PropertyChangeListener>> listenerMap = new HashMap<DynamicProperties, List<PropertyChangeListener>>();
	
	/*
	 * (non-Javadoc)
	 * @see com.xebia.codejam.service.IListenerManager#addListener(com.xebia.codejam.model.DynamicProperties, java.beans.PropertyChangeListener)
	 */
	@Override
	public void addListener(DynamicProperties property,
			PropertyChangeListener listener) {
		List<PropertyChangeListener> listeners = listenerMap.get(property);
		if (listeners == null) {
			listeners = new LinkedList<PropertyChangeListener>();
			listenerMap.put(property, listeners);
		}
		
		listeners.add(listener);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.xebia.codejam.service.IListenerManager#notifyListeners(com.xebia.codejam.model.DynamicProperties, java.beans.PropertyChangeEvent)
	 */
	@Override
	public void notifyListeners(DynamicProperties property, PropertyChangeEvent event) {
		List<PropertyChangeListener> listeners = listenerMap.get(property);
		
		if (listeners != null && !listeners.isEmpty()) {
			for (PropertyChangeListener listener : listeners) {
				listener.propertyChange(event);
			}
		}
	}
}
