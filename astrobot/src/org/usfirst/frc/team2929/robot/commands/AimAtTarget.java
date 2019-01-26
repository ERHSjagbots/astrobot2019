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
import org.usfirst.frc.team2929.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2929.robot.utility.ObjectSelect;

/**
 * An example command.  You can replace me with your own command.
 */
public class AimAtTarget extends Command {
	
	private int selection;
	
	private int finished = 0;
	private double center;
	
	public AimAtTarget(ObjectSelect selector) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
		selection = selector.getValue();
		//setTimeout(10);
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		center = 0;
		if (selection == 0 && Robot.centerX > 0) {
			center = Robot.centerX;
		} else if (selection == 1) {
			if (Robot.centerX > 0 && Robot.centerX2 > 0) {
				center = (Robot.centerX + Robot.centerX2) / 2; 
			} else if (Robot.centerX > 0) {
				center = Robot.centerX;
			} else if (Robot.centerX2 > 0) {
				center = Robot.centerX2;
			}
		} else if (selection == 2 && Robot.centerX2 > 0){
			center = Robot.centerX2;
		}
		
		SmartDashboard.putNumber("center command", center);
		
		if (center > 370) {
			Robot.drivetrain.getDriveTrain().tankDrive(0.35, -0.35);
		} else if (center == 0) {
			Robot.drivetrain.getDriveTrain().tankDrive(0, 0);
		} else if (center < 270) {
			Robot.drivetrain.getDriveTrain().tankDrive(-0.35, 0.35);
		} else {
			Robot.drivetrain.getDriveTrain().tankDrive(0, 0);
			finished = 1;
		}
		
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if (finished == 0) return false;
		else return false;
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
