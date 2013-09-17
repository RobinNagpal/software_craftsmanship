package com.xebia.codejam.model;

public class WalkBatteryDecorator extends BatteryDecorator {

	private BatteryDecorator batteryDecorator;
	private Double walkingDistance;

	public WalkBatteryDecorator(BatteryDecorator batteryDecorator,
			Double walkingDistance) {
		super();
		this.batteryDecorator = batteryDecorator;
		this.walkingDistance = walkingDistance;
	}

	@Override
	public Double calculateRemainingBattery() {

		Double calculateRemainingBattery = batteryDecorator
				.calculateRemainingBattery();
		Double battery = calculateRemainingBattery
				- ((100 / 5) * walkingDistance);
		
		
		if (battery < 0) {
			throw new RuntimeException(
					"Robot can not perform the operations as battery required for these operations are greater than the battery.");
		}

		System.out.println("Battery in WalkBatteryDecorator: " + battery);
		return battery;
	}

}
