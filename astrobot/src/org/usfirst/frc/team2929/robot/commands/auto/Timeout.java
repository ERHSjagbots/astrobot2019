package org.usfirst.frc.team2929.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2929.robot.utility.ObjectSelect;

/**
 * Autonomous command to make the bot do nothing for a certain amount of time
 * 
 * @author          Matthew Brosnon
 */
public class Timeout extends Command {
	
	/**
	 * Makes the bot wait a set amount of time.
	 * 
	 * @param  time time needed to wait
	 */
	public Timeout(double time) {
		
		//set timeout
		setTimeout(time);
		
	}

	
	@Override
	protected void initialize() {
		
		
	}

	
	@Override
	protected void execute() {
	
	}

	
	@Override
	protected boolean isFinished() {
		//finish when we're timed out
		return isTimedOut();
	}

	
	@Override
	protected void end() {
	}

	
	@Override
	protected void interrupted() {
	}
}
