package com.mycompany.a3;

import java.util.HashMap;
import java.util.Map;

import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.a3.commands.GameCommands;
import com.mycompany.a3.commands.RobotCommands;
import com.mycompany.a3.views.MapView;
import com.mycompany.a3.views.ScoreView;


public class Game extends Form implements ActionListener{
	private GameWorld gw;
	
	private MapView mv;
	private ScoreView sv;
	private Toolbar tools;
	private Container east, west, south;
	private Map<String, Command> gameCommands;
	private CustomButton accelerate, brake, left, right, changeStrategies, nprCollision,
					baseCollision, energyCollision, droneCollision, tick;
	private CheckBox sound;
	private Command accelerateCommand, about, exit; 
	
	
	
	public Game() {
		gw = new GameWorld();
		gameCommands = initMap(gw);
		
		mv = new MapView();
		sv = new ScoreView();
		// Initializes new containers for the games
		east = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		west = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		south = new Container(new BoxLayout(BoxLayout.X_AXIS));
		// Adds the Observers of Map View and ScoreView classes
		gw.addObserver(mv);
		gw.addObserver(sv);
		this.setLayout(new BorderLayout());
		this.setHeight(mv.getObjHeight());
		this.setWidth(mv.getObjWidth());
		
		// Setting up the tool Bar
		tools = new Toolbar();
		this.setToolbar(tools);
		this.tools.setTitle("Robo-Trak Game");
		
		// adding the help button to the tool bar at the right side
		tools.addCommandToRightBar(gameCommands.get("Help"));
		
		
		// Adding accelerate to left Menu
		accelerateCommand = gameCommands.get("Accelerate");
		tools.addCommandToSideMenu(accelerateCommand);
		// Adding about command to left menu
		about = gameCommands.get("About");
		tools.addCommandToSideMenu(about);
		
		// Adding sound
		sound = ((gw.getSound()) ? new CheckBox("ON") : new CheckBox("OFF"));
		sound.setCommand(gameCommands.get("Sound"));
		sound.addActionListener(this);
		tools.addComponentToSideMenu(sound);
		// 
		
		// Adding exit command to Left menu
		tools.addCommandToSideMenu(gameCommands.get("Exit"));
		
		
		
		
		// Adding buttons for all the commands onto the home screen
		
		// Accelerate Button:
		accelerate = new CustomButton();
		accelerate.setCommand(gameCommands.get("Accelerate"));
		west.add(accelerate);
		
		
		// Left Button:
		left = new CustomButton();
		left.setCommand(gameCommands.get("Left"));
		west.add(left);
		
		
		// change Strategies Button:
		changeStrategies = new CustomButton();
		changeStrategies.setCommand(gameCommands.get("ChangeStrategies"));
		west.add(changeStrategies);	
		
		
		// Beginning Work on East Container
		
		// Brake button:
		brake = new CustomButton();
		brake.setCommand(gameCommands.get("Brake"));
		east.add(brake);
		
		
		// Right Button
		
		right = new CustomButton();
		right.setCommand(gameCommands.get("Right"));
		east.add(right);
		
		
		// Beginning work on South Container
		
		// NPR Collision Button
		
		nprCollision = new CustomButton();
		nprCollision.setCommand(gameCommands.get("NPRCollision"));
		nprCollision.addActionListener(this);
		south.add(nprCollision);
		
		
		// Base Collision Button:
		baseCollision = new CustomButton();
		baseCollision.setCommand(gameCommands.get("BaseCollision"));
		south.add(baseCollision);
		
		
		// Energy Station Collision Button
		energyCollision = new CustomButton();
		energyCollision.setCommand(gameCommands.get("EnergyCollision"));
		south.add(energyCollision);
		
		
		// Drone Collision Button
		droneCollision = new CustomButton();
		droneCollision.setCommand(gameCommands.get("DroneCollision"));
		south.add(droneCollision);
		
		
		// Tick Button
		
		tick = new CustomButton();
		tick.setCommand(gameCommands.get("Tick"));
		south.add(tick);
		// Adds ALl the Containers within the GUi
		this.addComponent(BorderLayout.CENTER, mv);
		this.addComponent(BorderLayout.NORTH, sv);
		this.addComponent(BorderLayout.WEST, west);
		this.addComponent(BorderLayout.EAST, east);
		this.addComponent(BorderLayout.SOUTH, south);
		gw.init();
		this.show();
		
// Plays the game, as well as generates the input fields for the game
	}
	public Map<String, Command> initMap(GameWorld gw){
		Map<String, Command> commands = new HashMap<String, Command>();
		String[] robotCommands = {"Brake", "Accelerate", "NPRCollision", "DroneCollision",
				"EnergyCollision","BaseCollision", "Left", "Right", "ChangeStrategies"
				};
		for (int i = 0; i < robotCommands.length; i++) {
			commands.put(robotCommands[i], new RobotCommands(gw, robotCommands[i]));
		}
		String[] gameCommands = {"About", "Help", "Exit", "Tick", "Sound"};
		for(int i = 0; i < gameCommands.length; i++) {
			commands.put(gameCommands[i], new GameCommands(gw, gameCommands[i]));
		}
		
		
		return commands;
		
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
}
