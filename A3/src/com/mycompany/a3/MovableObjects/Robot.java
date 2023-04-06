package com.mycompany.a3.MovableObjects;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point;
import com.mycompany.a3.GameObjects;

public class Robot extends Movable implements ISteerable {
	private Random rand;
	private int steeringDirection;
	private int energyLevel;
	private int energyConsumptionRate;
	private int damageLevel;
	private int lastBaseReached;
	private int maximumSpeed;
	private int maxDamageLevel;
	private int acceleration, deacceleration;
	private int totalSteered;
	public Robot() {
		super(40, ColorUtil.GRAY, 0, 1);
		rand = new Random();
		maximumSpeed = 30;
		energyConsumptionRate = 2;
		damageLevel = 0;
		maxDamageLevel = 100;
		steeringDirection = 0;
		energyLevel = 100;
		lastBaseReached = 1;
		acceleration = 3;
		deacceleration = 3;
		totalSteered = 0;

	}
	public Robot(int size, int color, int heading, int speed) {
		super(size, color, heading, speed);
		maximumSpeed = 40;
		energyConsumptionRate = 0;
		damageLevel = 0;
		maxDamageLevel = 100;
		steeringDirection = 5;
		energyLevel = 100;
		lastBaseReached = 1;
		acceleration = 4;
		deacceleration = 4;
		totalSteered = 0;
	}
	// Steers the robot
	public void steeringDirection(char x) {
		if(x == 'l') {
			if(totalSteered <= -40) {
				totalSteered = -40;
			}
			else {
				totalSteered -= 5;
				steeringDirection -= 5;
			}
		}
		
		if(x == 'r') {
			if(totalSteered >= 40) {
				totalSteered = 40;
			}
			else {
				totalSteered += 5;
				steeringDirection +=5;
			}
	}
	}
	// sets speed of robot
	@Override
	public void setSpeed(int speed){
		if(speed > maximumSpeed){
			super.setSpeed(maximumSpeed);
		}
		else super.setSpeed(speed);
	}
	// returns maximum speed
	public int getMaximimSpeed(){
		return maximumSpeed;
	}
	// robot breaks
	public void breaks(){
		if(this.getSpeed() > 0){
			setSpeed(this.getSpeed()-deacceleration);
			if(this.getSpeed() <0)
			this.setSpeed(0);
		}
	}
	// uses energy
	public void energyUsed(){
		energyLevel = energyLevel - energyConsumptionRate;
	}
// sets the energy level
	public void setEnergyLevel(int energyLevel){
		this.energyLevel = energyLevel;
	}
	// returns energy consumption rate
	public int getEnergyConsumptionRate(){
		return energyConsumptionRate;
	}
// sets lastbase reached
	public void setLastBaseReached(int base){
		lastBaseReached = base;
	}
	// returns steering direction
	public int getSteerDirection(){
		return steeringDirection;
	}
	
	// Moves robot
	@Override
	public void move(){
		
		if(this.energyLevel > 0  && this.damageLevel<maxDamageLevel){
			useEnergy();
			super.move();
			// fix heading
			this.steeringDirection = totalSteered;
		}
		
	}
	// Uses Enerygy
	public void useEnergy() {
		energyUsed();
	}
	// adds energy to robot
	public void addEnergy(int size) {
		energyLevel += size;
	}
	// sets max damage a robot can take
	public void setMaxDamageLevel(int maxDamageLevel) {
		this.maxDamageLevel = maxDamageLevel;
	}
	// returns acceleration rate
	public int getAcceleration(){
		return acceleration;
	}
	// returns deacceleration rate
	public int getDeacceleration(){
		return deacceleration;
	}
	// accelerates the robot
	
	
	public void accelerate(){
		int tempSpeed = super.getSpeed() + acceleration;
		if (tempSpeed > maximumSpeed){
			System.out.print("Speed too high, can't accelerate more");
			super.setSpeed(maximumSpeed);
		}
		else super.setSpeed(super.getSpeed() + acceleration);
	}
	// slows the robot down
	public void deaccelerate(){
		int tempSpeed = super.getSpeed() - deacceleration;
		if(tempSpeed < 0){
			super.setSpeed(0);
			System.out.print("Cant deaccelerate more, You have stopped moving");
		}
		else super.setSpeed(tempSpeed); 
	}
	// adds damage to the robot
	public void addDamage(int i) {
		damageLevel += i;
		
	}
	// what happens when robot collides with another robot
	public void collisionRobot() {
		addDamage(10);
		int rgbValue = rbgChanger();
		this.setColor(ColorUtil.rgb(rgbValue, 0, 0));
	}
	// returns lastbasereached
	public int getLastBaseReached() {
		return lastBaseReached;
	}
	
	public void baseCollision(int i)  {
		if(this.getLastBaseReached() + 1 == i) {
			this.setLastBaseReached(i);
		}
	}
	// changes the color
	
	public int rbgChanger() {
		int rgb = 155;
		int currentHP = this.maxDamageLevel - damageLevel;
		int d = (10 - (int) currentHP / 10) *10;
		rgb += d;
		return rgb;
		
	}
	
	// returns total damage done to the robot
	public int getDamageLevel() {
		return damageLevel;
	}
	// Returns energy level
	public int getEnergyLevel() {
		return energyLevel;
	}
	// toString method
	public String toString() {
		String information = super.toString();
		information += "MaxSpeed: " + this.getMaximimSpeed() + " ";
		information += "EnergLevel: " + this.getEnergyLevel() + " ";
		information += "Steering Direction: " + this.getSteerDirection();
		return information;
	}
	// returns maxDamageLevel
	public int getMaximumDamage() {
		// TODO Auto-generated method stub
		return maxDamageLevel;
	}
	

}

