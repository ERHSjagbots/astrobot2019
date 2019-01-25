/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.utility.*;

/**
 * An example command.  You can replace me with your own command.
 */
public class DriveToDistance extends Command {
	
	private double target;
	private int finished = 0;
	
	public DriveToDistance(double distance) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		target = Maths.distance(distance);
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double width = (Robot.r1.width + Robot.r2.width) / 2;
		SmartDashboard.putNumber("Average Width", width);
		SmartDashboard.putNumber("math.distance", target);
		SmartDashboard.putNumber("math.distance width", Maths.distance(width));
		if (Maths.distance(width) > target + 2) {
			Robot.drivetrain.getDriveTrain().tankDrive(-0.4, -0.4);
		} else if (Maths.distance(width) < target - 2) {
			Robot.drivetrain.getDriveTrain().tankDrive(0.4, 0.4);
		} else {
			finished = 1;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (finished == 0) return false;
		else return true;
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
