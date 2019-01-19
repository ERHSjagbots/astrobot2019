/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot.subsystems;

import org.usfirst.frc.team2929.robot.RobotMap;
import org.usfirst.frc.team2929.robot.commands.TankDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {

	
	//setup of the talons for the drivetrain
	public static WPI_TalonSRX L1TalonSRX;
	public static WPI_TalonSRX L2TalonSRX;
	public static WPI_TalonSRX R1TalonSRX;
	public static WPI_TalonSRX R2TalonSRX;
	
	//getting differential drive
	public static SpeedControllerGroup LDrivetrain;
	public static SpeedControllerGroup RDrivetrain;
	public static DifferentialDrive drivetrain;
	
	public Drivetrain(){
		
		//initialization using constructor
		L1TalonSRX = new WPI_TalonSRX(RobotMap.dL1TalonSRX);
		L2TalonSRX = new WPI_TalonSRX(RobotMap.dL2TalonSRX);
		R1TalonSRX = new WPI_TalonSRX(RobotMap.dR1TalonSRX);
		R2TalonSRX = new WPI_TalonSRX(RobotMap.dR2TalonSRX);
		
		LDrivetrain = new SpeedControllerGroup(L1TalonSRX, L2TalonSRX);
		RDrivetrain = new SpeedControllerGroup(R1TalonSRX, R2TalonSRX);
		drivetrain = new DifferentialDrive(LDrivetrain, RDrivetrain);
		
	}
	
	public void initDefaultCommand() {
		
		//setting default command to tankdrive
		setDefaultCommand(new TankDrive());
	}
}
