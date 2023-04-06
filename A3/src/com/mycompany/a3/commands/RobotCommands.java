package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class RobotCommands extends Command {
	private GameWorld gw;
	
	public RobotCommands(GameWorld gw, String command) {
		super(command);
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(this.getCommandName()) {
		case "Brake":
			gw.updateSpeed('b');
			break;
		case "Accelerate":
			gw.updateSpeed('a');
			break;
		case "DroneCollision":
			gw.droneCollision('g');
			break;
		case "NPRCollision":
			gw.collisionRobot();
			break;
		case "EnergyCollision":
			gw.energyCollision(10, 'e');
			break;
		case "BaseCollision":
			baseCollision();
			break;
			
		case "Left":
			gw.steerRobot('l');
			break;
		case "Right":
			gw.steerRobot('r');
			break;
		case "ChangeStrategies":
			gw.changeNPRStrategies();
			break;
		}
		
		
		
	}
	
	private void baseCollision() {
		Command cOk = new Command("Confirm");
		Command cCancel = new Command("Dunno");
		Command[] cmds = new Command[]{cOk, cCancel};
		TextField myTF = new TextField();
		Command c = Dialog.show("Please enter a Base Number", myTF, cmds);
		if(c == cOk) {
			try {
				int baseNumber = Integer.parseInt(myTF.getText());
				gw.baseCollision(baseNumber);
			}
			catch(NumberFormatException e) {
				System.out.println("Please enter a valid number");
			}
			}
		else System.out.println("You Cancelled the base Collision");
		}
		
	
}
