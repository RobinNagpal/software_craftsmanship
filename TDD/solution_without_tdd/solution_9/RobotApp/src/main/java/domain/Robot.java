package domain;

import java.io.Serializable;


public class Robot implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private static final int loadThreshold = 10; // in Kg(s)

	private float remainingBattery;
	
	private float initialBattery = 0.0f;
	
	private float load;
	
	private boolean overloaded;
	
	private float chargeThresold;
	
	private float distanceCovered = 0.0f;
	
	private boolean lowBattery;
	

	public float getInitialBattery() {
		return initialBattery;
	}

	public void setInitialBattery(float initialBattery) {
		this.initialBattery = initialBattery;
		this.remainingBattery = this.initialBattery;
		chargeThresold = 0.15f * this.initialBattery;
	}

	public float getRemainingBattery() {
		return remainingBattery;
	}

	public float getLoad() {
		return load;
	}

	public void setLoad(float load) {
		this.load = load;
		loadThresholdCheck();
//		processBatteryConsumption();
	}

	public float getChargeThresold() {
		return chargeThresold;
	}

	public boolean isOverloaded() {
		return overloaded;
	}
	
	public float getDistanceCovered() {
		return distanceCovered;
	}

	public void setDistanceCovered(float distanceCovered) {
		this.distanceCovered = this.distanceCovered + distanceCovered;
//		processBatteryConsumption();
	}
	
	public boolean isLowBattery() {
		return lowBattery;
	}
	
	public void processBatteryConsumption() throws RuntimeException{
		
		if(overloaded) {
			throw new RuntimeException("Overloaded!!!!!");
		}
		
		float walkingDischarge = distanceCovered * 0.2f;
		float loadDischarge = (0.02f * initialBattery) * load;
		
		remainingBattery = remainingBattery - (walkingDischarge + loadDischarge);
		
		chargeThresholdCheck();
	}
	
	public static int getLoadthreshold() {
		return loadThreshold;
	}
	
	public void reset() {
		initialBattery = 0.0f;
		remainingBattery = 0.0f;
		load = 0.0f;
		distanceCovered = 0.0f;
		overloaded = false;
		lowBattery = false;
	}
	
	private void loadThresholdCheck() {
		if(this.load > loadThreshold) {
			overloaded = true;
		} else {
			overloaded = false;
		}
	}

	private void chargeThresholdCheck() {
		
		if(remainingBattery <= chargeThresold) {
			lowBattery = true;
		} else {
			lowBattery = false;
		}
	}
	
	public String getRobotStatus() {
		return "\nCurrent Status" + "\n********************************" + "\n"
					+ "Remaining battery: " + remainingBattery + "\n"
					+ "Current load: " + load + "\n"
					+ "Distance covered: " + distanceCovered
					+ (lowBattery? "LOW BATTERY":"") 
					+ (overloaded? "OVERLOADED":"");
	}

}
