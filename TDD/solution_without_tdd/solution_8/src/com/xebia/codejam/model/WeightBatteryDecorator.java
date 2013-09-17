package com.xebia.codejam.model;

public class WeightBatteryDecorator extends BatteryDecorator {

	private BatteryDecorator batteryDecorator;
	private int weight;

	public WeightBatteryDecorator(BatteryDecorator batteryDecorator, int weight) {
		super();
		this.batteryDecorator = batteryDecorator;
		this.weight = weight;
	}

	@Override
	public Double calculateRemainingBattery() {

		if (weight > 10) {

			System.out.println("Robot Chest Display: Overweight.");
			throw new RuntimeException(
					"Robot can not carry any object weighing more than 10 Kg.");
		}
		Double calculateRemainingBattery = batteryDecorator
				.calculateRemainingBattery();
		Double battery = calculateRemainingBattery
				- ((calculateRemainingBattery * 2) / 100) * weight;

		if (battery < 15) {

			System.out.println("Robot head light : Low battery");
		}

		if (battery < 0) {

			throw new RuntimeException(
					"Robot can not perform the operations as battery required for these operations are greater than the battery.");
		}
		System.out.println("Battery in WeightBatteryDecorator: " + battery);

		return battery;
	}

}
