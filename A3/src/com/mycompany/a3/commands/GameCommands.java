package com.mycompany.a3.commands;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class GameCommands extends Command{
	private GameWorld gw;
	public GameCommands(GameWorld gw, String command) {
		super(command);
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(this.getCommandName()) {
		case "Sound":
			
			if(((CheckBox)e.getComponent()).isSelected()) {
				gw.setSound(true);
			}
			else {
				gw.setSound(false);
			}
			break;
		case "Exit":
			Boolean confirmExit = Dialog.show("Exit", "Are you sure you want to exit?", "Yes", "No");
			if(confirmExit)
				gw.exit();
			else System.out.println("You have chosen to continue with the game");
			break;
		case "Tick":
			gw.advanceTime('t');
			break;
		case "Help":
			String text = "   Action                   Key\n";
			String accelerate = " Accelerate               A\n";
			String brake = "   Brake                     B\n";
			String left = "  Left Turn                 L\n";
			String right =  "Right Turn                R\n";
			String energyCollide =   "  Collide with Energy Station              e\n";
			String baseCollide= "Collide with base       g\n";
			String tickClock = "Clock Tick                 t\n";
			String information = text + accelerate + brake + left + right + energyCollide + baseCollide +
					tickClock;
			Dialog.show("Help", information, "Ok", null);
			break;
		case "About":
			String about = "Vaibhav Jain | CSC 133 | RoboTrak Game V2 | Spring 2023";
			Dialog.show("About", about, "Done", null);
			break;
		case "Default":
			break;
		}
		
	}
}
