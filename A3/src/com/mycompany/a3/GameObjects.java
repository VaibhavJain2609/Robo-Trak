package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObjects {
	private Random random;
	// Min Y
	private final float RANGEMINX = 0.0f;
	// MAX y
	private final float RANGEMAXY = 768.0f;
	//Max X
	private final float RANGEMAXX = 1024.0f;
	//Min X
	private final float RANGEMINY = 0.0f;
	private float posX; // Position x for location
	private float posY; // position y for location
	private int color; // Color of the game object
	private Point location; // location of the object
	private int size; // size of the object
	
	// Returns the name of the game object such as Robot, Drone, Base, etc
	@SuppressWarnings("deprecation")
	private final String type = this.getClass().getSimpleName().toString();
	// Initializes the game objects
	public GameObjects (int size, int color) {
			random = new Random();
			posX = RANGEMINX + (RANGEMAXX-RANGEMINX) * random.nextFloat();
			posY = RANGEMINY + (RANGEMAXY-RANGEMINY) * random.nextFloat();
			location = new Point(posX, posY);
			this.size = size;
			this.color = color;
	}
	// returns the name of the type of object
	public String getType() {
		return type;
	}
	// returns object location
	public Point getLocation() {
		return location;
	}
	// sets location of object
	public void setLocation(Point x) {
		location.setX(x.getX());
		location.setY(x.getY());
	}
	// returns size
	public int getSize() {
		return size;
	}
	// sets color
	public void setColor(int color) {
		this.color = color;
	}
	// returns color
	public int getColor() {
		return color;
	}
	// To String method
	public String toString() {
	String information = "";
	information += this.getType() + ": ";
	
	information += "Location: " + this.getLocation().getX() + ", " + this.getLocation().getY() + " ";
	information += "color=[" + ColorUtil.red(getColor()) + "," + ColorUtil.green(getColor()) + "," + ColorUtil.blue(getColor()) + "] ";
	information += "Size: " + this.getSize() + " "; 
	return information;
	}

}
