/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//Drive train
	public static final int dL1TalonSRX = 0;
	public static final int dL2TalonSRX = 1;
	public static final int dR1TalonSRX = 2;
	public static final int dR2TalonSRX = 3;
	
	//Arm
	public static final int armLS1 = 1;
	public static final int armMotor = 4;
	
	//Ramp
	public static final int rampMotor = 5;
	
	//Grabber
	public static final int grabberMotor = 6;
	public static final int grabberRotate = 7;
	
	public static final int gsolenoid1L = 0;
	public static final int gsolenoid1R = 1;
	public static final int gsolenoid2L = 2;
	public static final int gsolenoid2R = 3;
	
	public static final int gls1 = 0;
	public static final int gls2 = 1;
	
	//Lift
	public static final int lsolenoidL = 4;
	public static final int lsolenoidR = 5;
	
}
