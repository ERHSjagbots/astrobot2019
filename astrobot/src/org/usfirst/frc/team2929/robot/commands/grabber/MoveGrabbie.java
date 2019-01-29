/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot.commands.grabber;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class MoveGrabbie extends Command {
	
	//private double speed;
	
	public MoveGrabbie(/* double speed */) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.grabbie);
		//this.speed = speed;
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (Robot.m_oi.getRJoystick().getPOV(0) >= 45 && Robot.m_oi.getRJoystick().getPOV(0) <= 135) {
			if (!Robot.grabbie.isRSwitchSet()) {
				Robot.grabbie.setMotorSpeed(0);
			} else {
				Robot.grabbie.setMotorSpeed(0.5);
			}
		} else if (Robot.m_oi.getRJoystick().getPOV(0) >= 225 && Robot.m_oi.getRJoystick().getPOV(0) <= 315) {
			if (!Robot.grabbie.isLSwitchSet()) {
				Robot.grabbie.setMotorSpeed(0);
			} else {
				Robot.grabbie.setMotorSpeed(-0.5);
			}
		} else {
			Robot.grabbie.setMotorSpeed(0);
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
