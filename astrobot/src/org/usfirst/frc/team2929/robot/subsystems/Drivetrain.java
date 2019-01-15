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

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public static WPI_TalonSRX L1TalonSRX;
	public static WPI_TalonSRX L2TalonSRX;
	public static WPI_TalonSRX R1TalonSRX;
	public static WPI_TalonSRX R2TalonSRX;
	
	public Drivetrain(){
		L1TalonSRX = new WPI_TalonSRX(RobotMap.dL1TalonSRX);
		L2TalonSRX = new WPI_TalonSRX(RobotMap.dL2TalonSRX);
		R1TalonSRX = new WPI_TalonSRX(RobotMap.dR1TalonSRX);
		R2TalonSRX = new WPI_TalonSRX(RobotMap.dR2TalonSRX);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
