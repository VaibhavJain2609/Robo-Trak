package com.mycompany.a3.Strategies;

import java.util.Iterator;

import com.codename1.charts.models.Point;
import com.codename1.util.MathUtil;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.IIterator;
import com.mycompany.a3.ImmovableObjects.Base;
import com.mycompany.a3.MovableObjects.NonPlayerRobot;
import com.mycompany.a3.MovableObjects.Robot;

public class MoveTowardsBase implements IStrategy {
	private NonPlayerRobot npr;
	private GameWorld gw;
	private Robot player;
	
	public MoveTowardsBase(Robot robot,NonPlayerRobot npr, GameWorld gw) {
		// TODO Auto-generated constructor stub
		this.npr = npr;
		this.gw = gw;
		this.player = robot;
		
		invokeStrategy();
	}
	
	public void setStrategy() {
		npr.setStrategy(new AttackPlayer(player, npr, gw));
	}
	
	// To change Strategies in gw class
	public void setStrategy(Robot player, NonPlayerRobot nonPlayerRobot, GameWorld gameWorld) {
		this.player = player;
		this.npr = nonPlayerRobot;
		this.gw = gameWorld;
		setStrategy();
	}
	public void invokeStrategy() {
		IIterator iterator = gw.getOBJCollection().getIterator();
		Point baseLocation = new Point();
		
		while(iterator.hasNext()) {
		Object base = iterator.getNext();
			if(base instanceof Base) {
				if(((Base)base).getSequenceNumber() == npr.getLastBaseReached() +1){
					baseLocation = ((Base) base).getLocation();	
				}
			}
		}
		
		Point  nprLocation = npr.getLocation();
        Float distanceX = baseLocation.getX() - nprLocation.getX();
        Float distanceY = baseLocation.getY() - nprLocation.getY();
        int heading = (int) (90 - Math.toDegrees(MathUtil.atan2(distanceY, distanceX)));
        npr.setHeading(heading);
	}

}
