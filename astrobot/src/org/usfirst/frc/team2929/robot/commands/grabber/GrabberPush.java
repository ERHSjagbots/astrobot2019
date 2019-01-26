/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot.commands.grabber;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.utility.PistonSelect;

/**
 * An example command.  You can replace me with your own command.
 */
public class GrabberPush extends Command {
	
	public int select;
	
	public GrabberPush(PistonSelect selection) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.grabbie);
		select = selection.getValue();
		setTimeout(0.5);
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (select == 0) {
			Robot.grabbie.pushGrabbie();
		} else if (select == 1) {
			Robot.grabbie.reverseGrabbie();
		} else {
			Robot.grabbie.offGrabbie();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
