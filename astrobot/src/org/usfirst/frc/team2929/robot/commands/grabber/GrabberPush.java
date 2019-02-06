package org.usfirst.frc.team2929.robot.commands.grabber;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.utility.PistonSelect;

/**
 * Command to manipulate grabber solenoid.
 * 
 * @author          Matthew Brosnon
 */
public class GrabberPush extends Command {
	
	//integer to store selection
	public int select;
	
	/**
	 * Moves the pistons on the grabbies forwards, in reverse, or turns them off.
	 * 
	 * @param  selection direction of the pistons
	 */
	public GrabberPush(PistonSelect selection) {
		
		//requires grabbie susbsystem
		requires(Robot.grabbie);
		
		//sets value to PistonSelect value
		select = selection.getValue();
		
		//sets timeout
		setTimeout(0.5);
		
	}

	
	@Override
	protected void initialize() {
	}

	
	@Override
	protected void execute() {
		//moves piston depending on parameter
		if (select == 0) {
			Robot.grabbie.pushGrabbie();
		} else if (select == 1) {
			Robot.grabbie.reverseGrabbie();
		} else {
			Robot.grabbie.offGrabbie();
		}
	}

	
	@Override
	protected boolean isFinished() {
		//finishes command when timeout has finished
		return isTimedOut();
	}

	
	@Override
	protected void end() {
	}

	
	@Override
	protected void interrupted() {
	}
}
