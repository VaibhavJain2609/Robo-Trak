package com.mycompany.a3.MovableObjects;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.mycompany.a3.GameObjects;

public class Drone extends Movable{

	private static Random random = new Random();
	public Drone() {
		super(random.nextInt(5)+10, ColorUtil.CYAN, random.nextInt(361), random.nextInt(10) + 6 );	
	}
	// Moves the drone
	@Override
	public void move() {
		Point oldLocation = getLocation(); 
		int theta = 90 - getHeading(); 
		
		float deltaX = (float) (Math.cos(Math.toRadians(theta)) * getSpeed()); 
		float deltaY = (float) (Math.sin(Math.toRadians(theta)) * getSpeed());
		Point newLocation = new Point(deltaX + oldLocation.getX(), deltaY + oldLocation.getY());
		if(newLocation.getX() <= 0 || newLocation.getY() <=0 || newLocation.getX() >= 1024 || newLocation.getY() >= 765) {
			setHeading(random.nextInt(360)); 
		}
		else {
			setLocation(newLocation);
			
		}
		
	}
	// To String method
	public String toString() {
		return super.toString();
	}
}
