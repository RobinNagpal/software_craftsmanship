/**
 * 
 */
package com.xebia.codejam.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

/**
 * @author Jagmeet
 *
 */
@Component
public class CounterUtil {
	private ConcurrentMap<String, AtomicLong> counterMap = new ConcurrentHashMap<String, AtomicLong>();
	
	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public synchronized Long getNextId(Class<?> clazz) {
		AtomicLong currentCounter = counterMap.get(clazz.getName());
		if (currentCounter == null) {
			currentCounter = new AtomicLong(0);
			counterMap.put(clazz.getName(), currentCounter);
		}
		Long nextId = currentCounter.addAndGet(1);
		
		return nextId;
	}
}
