package com.mycompany.a3.views;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.a3.GameWorld;

public class MapView extends Container implements Observer {
	private GameWorld gw;
	private TextField text;
	public MapView() {
		this.setWidth(1024);
		this.setHeight(768);
		this.setLayout(new BorderLayout());
		this.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.rgb(255, 0, 0)));
		text = new TextField();
		
		this.add(BorderLayout.CENTER, text);
	}
	public void update (Observable o, Object arg) {
		// code here to call the method in GameWorld (Observable) that output the
		// game object information to the console
			gw = (GameWorld ) o;
			//String map = gw.printMap();
			//System.out.println(map);
			//this.repaint();
		}
	public int getObjWidth() {
		return this.getWidth();
	}
	public int getObjHeight() {
		return this.getHeight();
	}
}
