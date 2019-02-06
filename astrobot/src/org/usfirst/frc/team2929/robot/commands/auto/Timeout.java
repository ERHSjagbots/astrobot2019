package org.usfirst.frc.team2929.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2929.robot.utility.ObjectSelect;


public class Timeout extends Command {
	
	/**
	 * Makes the bot wait a set amount of time.
	 * 
	 * @param  time time needed to wait
	 * @author      Matthew Brosnon
	 */
	public Timeout(double time) {
		
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
		return isTimedOut();
	}

	
	@Override
	protected void end() {
	}

	
	@Override
	protected void interrupted() {
	}
}
