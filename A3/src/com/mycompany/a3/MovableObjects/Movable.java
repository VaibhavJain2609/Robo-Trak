package com.mycompany.a3.MovableObjects;

import java.util.Iterator;
import java.util.Random;

import com.codename1.charts.models.Point;
import com.mycompany.a3.GameObjects;

public class Movable extends GameObjects {
	
	// For Robot
	public Movable(int size, int color, int heading, int speed) {
		super(size, color);
		this.heading = heading;
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}
	
	public Movable(int size, int color) {
		super(size, color);
		randomHeading();
	}
	private int heading, speed;
	// Maximum speed for the objects
	private final int MAXIMUMSPEED = 15;
	public void move() {
		Point oldLocation = super.getLocation();
		// Using the Unit circle Unit circle 0 degrees is at EAST facing direction
		int angle = 90- heading;
		checkSpeed();
		float deltaX = (float) (Math.cos(Math.toRadians(angle))*speed);
		float deltaY = (float) (Math.sin(Math.toRadians(angle))*speed);
		Point newLocation = new Point(oldLocation.getX()+deltaX, oldLocation.getY()+deltaY);
		super.setLocation(newLocation);
		
	}
// Returns speed
	public int getSpeed() {
		return speed;
	}
	// checks speed
	private int checkSpeed() {
		if(this.speed ==0 ) {
			speed = 1;
		}
		return speed;
	}
	// generates a random heading
	public void randomHeading() {
		Random random = new Random();
		heading = random.nextInt(360);
	}
	// Sets speed
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	// Returns heading
	public int getHeading() {
		return heading;
	}
	// Sets heading
	public void setHeading(int heading) {
		this.heading = heading;
	}
	//ToString Method
	public String toString() {
		String information = super.toString();
		information += "Heading: " + this.getHeading();
		information += " Speed: " + this.getSpeed() + " ";
		return information;
	}
}
