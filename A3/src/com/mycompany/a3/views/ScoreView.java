package com.mycompany.a3.views;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.a3.GameWorld;

public class ScoreView extends Container implements Observer {
	private GameWorld gw;
	private Label clockTime, livesLeft, sound, lastBaseReached, energyLevel, damageLevel;
		
	public ScoreView() {
		this.setLayout(new FlowLayout());
		init();

	}
	
	public void init() {
		clockTime = new Label("Time Elapsed: " + String.valueOf(0));
		this.add(clockTime);
		clockTime.getAllStyles().setPaddingLeft(10);
		livesLeft = new Label("Lives Left: " + String.valueOf(3));
		this.add(livesLeft);
		lastBaseReached = new Label("Last Base Reached: " + String.valueOf(1));
		this.add(lastBaseReached);
		energyLevel = new Label("Energy Level: " + String.valueOf(100));
		this.add(energyLevel);
		damageLevel = new Label("Damage Level: " +String.valueOf(0));
		this.add(damageLevel);
		sound = new Label("Sound: " + String.valueOf("OFF"));
		this.add(sound);
	}
	
public void update (Observable o, Object arg) {
// code here to call the method in GameWorld (Observable) that output the
// game object information to the console
	gw = (GameWorld)o;
	this.clockTime.setText("Time Elapsed: " + String.valueOf(gw.getTime()));
	this.livesLeft.setText("Lives Left: " + String.valueOf(gw.getLives()));
	this.lastBaseReached.setText("Base: " + String.valueOf(gw.getPlayer().getLastBaseReached()));
	this.energyLevel.setText("Energy Level: " + String.valueOf(gw.getPlayer().getEnergyLevel()));
	this.damageLevel.setText("Damage Level: " + String.valueOf(gw.getPlayer().getDamageLevel()));
	String sound1 = (gw.getSound() ? "ON" : "OFF");
	this.sound.setText("Sound: " + sound1);
	this.repaint();
}
}
