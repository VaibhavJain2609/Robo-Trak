package com.mycompany.a3.ImmovableObjects;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class EnergyStation extends FixedObjects{
	private int capacity;
	private static Random random = new Random();
	// Creates an energy station
	public EnergyStation() {
		super(random.nextInt(40) +11, ColorUtil.GREEN);
		random = new Random();
		capacity = super.getSize();
		super.setColor(ColorUtil.GREEN);
		super.setLocation( new Point((float) 1024 * random.nextFloat(), (float) 765 * random.nextFloat()));

	}
// sets capacity of energy station
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	// retuns capacity of energy station
	public int getCapacity(){
		return capacity;
	}
	// toString methos
	public String toString() {
		String information = super.toString();
		information += "Capacity: " + this.getCapacity();
		return information;
	}
	
}

