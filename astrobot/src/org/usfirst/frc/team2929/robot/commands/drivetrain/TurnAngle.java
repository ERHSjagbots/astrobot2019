/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.utility.Direction;

/**
 * FRC Generated command template.
 * 
 * 
 */
public class TurnAngle extends Command {
	
	//variables
	private double angle;
	private boolean direction;
	
	private boolean finished;
	
	public TurnAngle(double angle, Direction right) {
		
		//requires drivetrain
		requires(Robot.drivetrain);
		
		//setup
		if (right.getValue() == 0) {
			direction = false;
			this.angle = angle;
		} else {
			direction = true;
			this.angle = -angle;
		}
		finished = false;
	}

	
	@Override
	protected void initialize() {
		Robot.drivetrain.getGyro().reset();
	}

	
	@Override
	protected void execute() {
		
		if(direction) {
			while (angle > Robot.drivetrain.getGyro().getAngle()) {
				Robot.drivetrain.getDriveTrain().tankDrive(0.5, -0.5);
			}
			finished = true;
		} else {
			while (angle < Robot.drivetrain.getGyro().getAngle()) {
				Robot.drivetrain.getDriveTrain().tankDrive(-0.5, 0.5);
			}
			finished = true;
		}
		
	}

	
	@Override
	protected boolean isFinished() {
		return finished;
	}

	
	@Override
	protected void end() {
	}

	
	@Override
	protected void interrupted() {
	}
}
