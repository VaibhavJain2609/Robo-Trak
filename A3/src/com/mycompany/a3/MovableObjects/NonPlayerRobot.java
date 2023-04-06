package com.mycompany.a3.MovableObjects;
import java.util.*;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.Strategies.*;
import com.codename1.util.MathUtil;
public class NonPlayerRobot extends Robot{
	private IStrategy strategy;
	private GameWorld gw;
	private Robot player;
	public NonPlayerRobot(GameWorld gw, Robot player) {
		super(40, ColorUtil.BLACK, 0, 2);
		this.gw = gw;
		this.player = player;
		Random rand = new Random();
		this.setLocation(new Point(50 + rand.nextInt(100), 50 + rand.nextInt(50)));
		this.initialStrategy();
	}
	public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}
	
	// Sets Up a new Strategy
	public void initialStrategy() {
		Random rand  = new Random();
		int i = rand.nextInt(2);
		if (i %2 == 0) {
			this.strategy = new MoveTowardsBase(player, this, gw);
		}
		else {
			this.strategy = new AttackPlayer(player, this, gw);
		}
	}
	@Override
	public void move() {
		strategy.invokeStrategy();
		super.move();
	}
	public IStrategy getStrategy() {
		return this.strategy;
	}
	
	public String toString() {
		String val = super.toString();
		val += " Strategy: ";
		val += ((this.getStrategy() instanceof MoveTowardsBase) ? "MoveTowardsBase": "AttackingPlayer" );
		
		return val;
	}
}

