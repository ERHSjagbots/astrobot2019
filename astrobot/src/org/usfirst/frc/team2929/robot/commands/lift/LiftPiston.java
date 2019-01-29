/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot.commands.lift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.utility.PistonSelect;

/**
 * An example command.  You can replace me with your own command.
 */
public class LiftPiston extends Command {
	
	//public int select;
	
	public LiftPiston(/* PistonSelect selection */) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.grabbie);
		//select = selection.getValue();
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (Robot.m_oi.getLJoystick().getPOV(0) <= 45 || Robot.m_oi.getLJoystick().getPOV(0) >= 315) {
			Robot.grabbie.pushGrabbie();
		} else if (Robot.m_oi.getLJoystick().getPOV(0) <= 225 && Robot.m_oi.getLJoystick().getPOV(0) >= 135) {
			Robot.grabbie.reverseGrabbie();
		} else {
			Robot.grabbie.offGrabbie();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
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
