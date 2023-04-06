package com.mycompany.a3.Strategies;

import com.mycompany.a3.GameWorld;
import com.mycompany.a3.MovableObjects.NonPlayerRobot;
import com.mycompany.a3.MovableObjects.Robot;

public interface IStrategy {
	public void setStrategy();
	public void invokeStrategy();
	public void setStrategy(Robot player, NonPlayerRobot nonPlayerRobot, GameWorld gameWorld);
}
