package com.mycompany.a3;
import java.util.ArrayList;
import java.util.Collections;

import com.mycompany.a3.ImmovableObjects.*;
import com.mycompany.a3.MovableObjects.*;
import com.mycompany.a3.Strategies.AttackPlayer;
import com.mycompany.a3.Strategies.IStrategy;
import com.mycompany.a3.Strategies.MoveTowardsBase;

import java.util.Iterator;
import java.util.Observable;
import java.util.Vector;
public class GameWorld extends Observable {
// Generates a list of game objects
	private GameObjectCollection gameObjects;
	//private Iterator<GameObjects> Iterator;
	private Robot player;
	private int elapasedTime, lives;
	private NonPlayerRobot npr1, npr2, npr3;
	private boolean sound;
	// Develops a constructor
	public GameWorld(){
		lives = 3;
		elapasedTime = 0;
		sound = false;
		update();
		
	}
	// Initializes the Game Objects
	public void init() {
		player = new Robot();
		
		gameObjects = new GameObjectCollection();
		
		gameObjects.getCollection().add(player);
		npr1 = new NonPlayerRobot(this, player);
		npr2 = new NonPlayerRobot(this, player);
		npr3 = new NonPlayerRobot(this, player);
		gameObjects.getCollection().add(npr1);
		gameObjects.getCollection().add(npr2);
		gameObjects.getCollection().add(npr3);
		
		for(int i = 0; i < 2; i++){
			addDrone();
		}
		

		for(int i = 0; i < 9; i++){
			addBase(i+1);
		}
		for(int i = 0; i < 2; i++){
			addEnergyStation();
		}
			update();
	}
	
	
	
	// Adds drones to game objects
	public void addDrone(){
		Drone drones = new Drone();
		gameObjects.getCollection().add(drones);
	}
	// Adds bases to game Objects
	public void addBase(int sequenceNumber){
		Base base = new Base(sequenceNumber);
		gameObjects.getCollection().add(base);
	}
	public boolean getSound() {
		return sound;
	}
	// Adds energy Station to game objects
	public void addEnergyStation(){
		EnergyStation energyStation = new EnergyStation();
		gameObjects.getCollection().add(energyStation);
	}
	// Collides with a drone
	public void droneCollision(char x){
		if(x == 'g') {
			player.addDamage(20);
			death();
		}
		update();
	}
	// checks if we collided with a base
	public void baseCollision(int sequenceNumber){
		if(sequenceNumber == player.getLastBaseReached() +1) {
			System.out.println("You have collided with Base number; " + sequenceNumber);
			player.setLastBaseReached(sequenceNumber);
			if(player.getLastBaseReached() == 9) {
				System.out.println("Game over, you win! Total time: " + this.getTime());
				exit();
			}
		}
		else System.out.println("You Can't skip a base");
		update();
	}
	
	
	// Change NPR Strategies
	
	public GameObjectCollection getOBJCollection() {
		return gameObjects;
	}
	
	// Used for Changing Strategies
	public void changeNPRStrategies() {
		
		// Generates the iterator
		IIterator iterator = gameObjects.getIterator();
		
		//Going through the gameObject Collection
		while(iterator.hasNext()) {
			// Temporary variable used to update the Objects
			GameObjects obj = (GameObjects) iterator.getNext();
			//checks if the object is an NonPlayerRobot
			if(obj instanceof NonPlayerRobot) {
				// Side affect that is to collide everytime strategies are changed
				
				((NonPlayerRobot) obj).baseCollision(((NonPlayerRobot)obj).getLastBaseReached() +1);
				// Changes based on the current Strategy being followed
				
				
				((NonPlayerRobot) obj).getStrategy().setStrategy(player, ((NonPlayerRobot) obj), this);
				System.out.println("Strategies Changed");
				}
			}
	}
	
	// collision with a energy station
	public void energyCollision(int size, char c){
		if(c == 'e') {
			if(player.getEnergyLevel() + size >= 100) {
				player.setEnergyLevel(100);}
			else player.addEnergy(size);
		update();
		System.out.println("The robot has added: " + size + " energy");
		
		}
	}
	// Checks if you are alive or dead
	public void death() {
		
		if (player.getEnergyLevel()<=0 || player.getDamageLevel() >= 100) {
			lives--;
			init();
			
		}
		if(lives == 0) {
			update();
			System.out.println("Game over, a non-player robot wins!");
			exit();
		}
		
	}
	// Steers the robot right or left
	public void steerRobot(char x) {
		if (x == 'l') {
			System.out.println("Steer left by 5 degrees.");
			player.steeringDirection('l');
		}
		else {
			System.out.println("Steer right by 5 degrees.");
			player.steeringDirection('r');
		}
		update();
	}
	// Prints a map of game objects
	public String printMap() {
		
		IIterator i = gameObjects.getIterator();
		String map = "";
		while(i.hasNext()) 
		{
			map += i.getNext().toString();
			map += "\n";
			
		}
		return map;
		
	}
	// accelerates the drone
	public void accelerate() {
		System.out.println("Accelerating!");
		player.accelerate();
	}
	// Deaccelerates the drone
	public void deaccelerate() {
		System.out.println("Deaccelerating!");
		player.deaccelerate();
	}
	
	public void updateSpeed(char x) {
		if (x == 'a') accelerate();
		if (x == 'b') deaccelerate();
		
		update();
	}
	// breaks
	public void breaks() {
		player.breaks();
	}
	
	// Exits the game
	public void exit() {
		System.exit(0);
	}
	// Returns number of lives
	public int getLives() {
		return lives;
	}
	// Advances time by 1
	public void advanceTime(char x) {
		if(x == 't') {
		for (int i=0; i<gameObjects.getCollection().size(); i++) { 
			   if (gameObjects.getCollection().elementAt(i) instanceof Movable) { 
			    Movable mObj = (Movable)gameObjects.getCollection().elementAt(i); 
			   mObj.move();    }
			   player.useEnergy();
			   death();
			   
			   }
		this.elapasedTime++;
		System.out.println("Time Has Advanced");
		update();
		}
	}
	// Returns player
	public Robot getPlayer() {
		return this.player;
	}
	// returns elapsed Time
	public int getTime() {
		return this.elapasedTime;
	}
	
	// Returns the state of the player
	public String getPlayerState() {
		String information = "";
		information += "Lives Remaining: " + getLives() +"\n";
		information += " Time Elapsed: " + this.elapasedTime +"\n";
		information += " Last base Reached: " + player.getLastBaseReached() +"\n";
		information += " Current Player Energy: " + player.getEnergyLevel() +"\n";
		information += " Player Damage Level: " + player.getDamageLevel() +"\n";
		information+= " Player Max Damage: " + player.getMaximumDamage() +"\n";
		update();
		return information;
	}
	// Collides with a robot
	public void collisionRobot() {
		player.addDamage(20);
		System.out.println("20 Dammage added to the Robot");
		death();
		update();
		
	}
	// Updates the observers
	public void update() {
		this.setChanged();
		this.notifyObservers();
	}
	
	// sets sound
	public void setSound(boolean string) {
		this.sound = string;
		update();
		
	}

}
