/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot.subsystems;

import org.usfirst.frc.team2929.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Setup and methods for the ramp.
 * 
 * @author Matthew Brosnon
 */
public class RampSubsystem extends Subsystem {
	
	WPI_TalonSRX rampMotor = new WPI_TalonSRX(RobotMap.rampMotor);
	
	/**
	 * Defines the default command. Called when the subsystem is made.
	 * 
	 */
	public void initDefaultCommand() {
		
		//not making a default command
		//setDefaultCommand();
	}
	
	/**
	 * Moves the ramp motor at a certain speed.
	 * 
	 * @param speed speed the motors move.
	 */
	public void moveMotor(double speed) {
		rampMotor.set(speed);
	}
}
