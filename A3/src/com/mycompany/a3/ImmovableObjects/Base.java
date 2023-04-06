package com.mycompany.a3.ImmovableObjects;


import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.mycompany.a3.GameObjects;
//Base Class
public class Base extends FixedObjects{
	private int sequenceNumber;
	private Point location;
	// Generates a base while assigning it a sequenceNumber
	public Base(int sequence) {

		super(20, ColorUtil.BLUE);
		sequenceNumber = sequence;
		location = new Point((float) 150 * sequenceNumber, (float) 120 * sequenceNumber);
		//set Location of each base
		super.setLocation(location);
	}
// returns sequence number
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	// toString Method
	public String toString() {
		String information = super.toString();
		information += "sequenceNumber" + this.getSequenceNumber();
		return information;
	}
}
