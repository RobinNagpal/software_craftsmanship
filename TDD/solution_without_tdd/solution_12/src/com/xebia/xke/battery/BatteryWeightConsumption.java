package com.xebia.xke.battery;

public class BatteryWeightConsumption extends BatteryConsumption {

	private BatteryConsumption batteryDecorator;
	private int weight;

	public BatteryWeightConsumption(BatteryConsumption batteryDecorator, int weight) {
		super();
		this.batteryDecorator = batteryDecorator;
		this.weight = weight;
	}

	@Override
	public Double getRemainingBattery() {

		if (weight > 10) {
			throw new RuntimeException(
					"Robot can not carry any weight more than 10 Kg.");
		}
		Double calculateBatteryRemaining = batteryDecorator
				.getRemainingBattery();
		Double battery = calculateBatteryRemaining
				- ((calculateBatteryRemaining * 2) / 100) * weight;

		if (battery < 0) {
			throw new RuntimeException(
					"Robot can not perform the operations as battery required for these operations are greater than the battery.");
		}
		System.out.println("Battery in WeightBattery: " + battery);

		return battery;
	}

}
