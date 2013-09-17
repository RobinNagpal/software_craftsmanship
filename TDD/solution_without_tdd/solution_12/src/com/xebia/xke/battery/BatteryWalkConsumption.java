package com.xebia.xke.battery;

public class BatteryWalkConsumption extends BatteryConsumption {

	private BatteryConsumption batteryDecorator;
	private Double walkingDistance;

	public BatteryWalkConsumption(BatteryConsumption battery, Double walkingDistance) {
		super();
		this.batteryDecorator = battery;
		this.walkingDistance = walkingDistance;
	}

	@Override
	public Double getRemainingBattery() {

		Double calculateBatteryRemaining = batteryDecorator
				.getRemainingBattery();
		Double battery = calculateBatteryRemaining
				- ((100 / 5) * walkingDistance);

		if (battery < 0) {
			throw new RuntimeException(
					"Robot can not perform the operations as bettery is less.");
		}

		System.out.println("Battery in Battery for Walk: " + battery);
		return battery;
	}

}
