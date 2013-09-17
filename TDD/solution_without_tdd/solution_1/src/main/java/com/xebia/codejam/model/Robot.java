/**
 * 
 */
package com.xebia.codejam.model;

import java.beans.PropertyChangeEvent;

import com.xebia.codejam.util.ListenerUtil;

/**
 * @author Jagmeet
 *
 */
public class Robot {

	private Long id;
	private Integer initialBatteryCharge;
	private Float distanceCapacity;
	private Integer lowBatteryCharge;
	private Integer weightCapacity;
	private Integer batteryDischargeFactorPerWeight;
	private Float distanceTravelled;
	private Integer currentCharge;
	private Integer currentWeight;
	
	public Robot(Long id) {
		this(id, 5f, 15, 10, 2);
	}
	
	public Robot(Long id, Float distanceCapacity, Integer lowBatteryCharge,
			Integer weightCapacity, Integer batteryDischargeFactorPerWeight) {
		this(id, 100, distanceCapacity, lowBatteryCharge, weightCapacity, batteryDischargeFactorPerWeight);
		
	}
	
	public Robot(Long id, Integer initialBatteryCharge,
			Float distanceCapacity, Integer lowBatteryCharge,
			Integer weightCapacity, Integer batteryDischargeFactorPerWeight) {
		this.id = id;
		this.initialBatteryCharge = initialBatteryCharge;
		this.distanceCapacity = distanceCapacity;
		this.lowBatteryCharge = lowBatteryCharge;
		this.weightCapacity = weightCapacity;
		this.batteryDischargeFactorPerWeight = batteryDischargeFactorPerWeight;
		this.distanceTravelled = 0f;
		this.currentCharge = initialBatteryCharge;
		this.currentWeight = 0;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getInitialBatteryCharge() {
		return initialBatteryCharge;
	}
	public void setInitialBatteryCharge(Integer initialBatteryCharge) {
		this.initialBatteryCharge = initialBatteryCharge;
	}
	public Float getDistanceCapacity() {
		return distanceCapacity;
	}
	public void setDistanceCapacity(Float distanceCapacity) {
		this.distanceCapacity = distanceCapacity;
	}
	public Integer getLowBatteryCharge() {
		return lowBatteryCharge;
	}
	public void setLowBatteryCharge(Integer lowBatteryCharge) {
		this.lowBatteryCharge = lowBatteryCharge;
	}
	public Integer getWeightCapacity() {
		return weightCapacity;
	}
	public void setWeightCapacity(Integer weightCapacity) {
		this.weightCapacity = weightCapacity;
	}
	public Integer getBatteryDischargeFactorPerWeight() {
		return batteryDischargeFactorPerWeight;
	}
	public void setBatteryDischargeFactorPerWeight(
			Integer batteryDischargeFactorPerWeight) {
		this.batteryDischargeFactorPerWeight = batteryDischargeFactorPerWeight;
	}
	public Float getDistanceTravelled() {
		return distanceTravelled;
	}
	public void setDistanceTravelled(Float distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}
	public Integer getCurrentCharge() {
		return currentCharge;
	}
	public void setCurrentCharge(Integer currentCharge) {
		ListenerUtil.notifyListeners(DynamicProperties.CURRENT_CHARGE, 
				new PropertyChangeEvent(this, DynamicProperties.CURRENT_CHARGE.getPropertyName(),
						this.currentCharge, this.currentCharge = currentCharge));
	}
	
	public Integer getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(Integer currentWeight) {
		ListenerUtil.notifyListeners(DynamicProperties.CURRENT_WEIGHT, 
				new PropertyChangeEvent(this, DynamicProperties.CURRENT_WEIGHT.getPropertyName(),
						this.currentWeight, this.currentWeight = currentWeight));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Robot other = (Robot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Boolean isLowOnBattery() {
		return currentCharge <= lowBatteryCharge ? Boolean.TRUE : Boolean.FALSE;
	}
	
	public Boolean isOverloaded() {
		return currentWeight <= weightCapacity ? Boolean.FALSE : Boolean.TRUE;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Robot [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (initialBatteryCharge != null)
			builder.append("initialBatteryCharge=")
					.append(initialBatteryCharge).append(", ");
		if (distanceCapacity != null)
			builder.append("distanceCapacity=").append(distanceCapacity)
					.append(", ");
		if (lowBatteryCharge != null)
			builder.append("lowBatteryCharge=").append(lowBatteryCharge)
					.append(", ");
		if (weightCapacity != null)
			builder.append("weightCapacity=").append(weightCapacity)
					.append(", ");
		if (batteryDischargeFactorPerWeight != null)
			builder.append("batteryDischargeFactorPerWeight=")
					.append(batteryDischargeFactorPerWeight).append(", ");
		if (distanceTravelled != null)
			builder.append("distanceTravelled=").append(distanceTravelled)
					.append(", ");
		if (currentCharge != null)
			builder.append("currentCharge=").append(currentCharge).append(", ");
		if (currentWeight != null)
			builder.append("currentWeight=").append(currentWeight);
		builder.append("]");
		return builder.toString();
	}
}
