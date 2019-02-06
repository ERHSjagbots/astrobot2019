package org.usfirst.frc.team2929.robot.commands.grabber;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.utility.PistonSelect;


public class GrabberPush extends Command {
	
	public int select;
	
	/**
	 * Moves the pistons on the grabbies forwards, in reverse, or turns them off.
	 * 
	 * @param  selection direction of the pistons
	 * @author           Matthew Brosnon
	 */
	public GrabberPush(PistonSelect selection) {
		
		requires(Robot.grabbie);
		select = selection.getValue();
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
		return isTimedOut();
	}

	
	@Override
	protected void end() {
	}

	
	@Override
	protected void interrupted() {
	}
}
