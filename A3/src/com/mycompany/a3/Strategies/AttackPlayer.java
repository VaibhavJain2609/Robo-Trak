package com.mycompany.a3.Strategies;

import com.codename1.charts.models.Point;
import com.codename1.util.MathUtil;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.MovableObjects.NonPlayerRobot;
import com.mycompany.a3.MovableObjects.Robot;

public class AttackPlayer implements IStrategy{
	private Robot robot;
	private NonPlayerRobot npr;
	private GameWorld gw;
	public AttackPlayer(Robot robot, NonPlayerRobot npr, GameWorld gw) {
		this.robot = robot;
		this.npr = npr;
		this.gw = gw;
		
		invokeStrategy();
	}

	@Override
	public void setStrategy() {
		
        npr.setStrategy(new MoveTowardsBase(robot, npr, gw));

	}
	// To Change strategies in gw class
	public void setStrategy(Robot player, NonPlayerRobot nonPlayerRobot, GameWorld gameWorld) {
		this.robot = player;
		this.npr = nonPlayerRobot;
		this.gw = gameWorld;
		setStrategy();
	}
	
	@Override
	public void invokeStrategy() {
		Point playerLocation = robot.getLocation();
        Point currentLocation = npr.getLocation();
        Float distanceX = playerLocation.getX() - currentLocation.getX();
        Float distanceY = playerLocation.getY() - currentLocation.getY();
        int heading = (int) (90 - Math.toDegrees(MathUtil.atan2(distanceY, distanceX)));
        npr.setHeading(heading);
		
	}
	
}
