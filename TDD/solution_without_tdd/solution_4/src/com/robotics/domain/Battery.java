package com.robotics.domain;

import java.io.Serializable;

public class Battery implements Serializable {
	private static final long serialVersionUID = -4107586543206173077L;
	
	private int charge;
	private int currentCharge;

	public int getCurrentCharge() {
		return currentCharge;
	}

	public void setCurrentCharge(int currentCharge) {
		this.currentCharge = currentCharge;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

}
