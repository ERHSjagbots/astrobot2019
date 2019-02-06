/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot.subsystems;

import org.usfirst.frc.team2929.robot.RobotMap;
import org.usfirst.frc.team2929.robot.commands.drivetrain.TankDrive;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {

	
	//setup of the victors of the drivetrain
	public static WPI_TalonSRX L1TalonSRX;
	public static WPI_TalonSRX L2TalonSRX;
	public static WPI_TalonSRX R1TalonSRX;
	public static WPI_TalonSRX R2TalonSRX;
	
	//getting differential drive
	public static SpeedControllerGroup LDrivetrain;
	public static SpeedControllerGroup RDrivetrain;
	public static DifferentialDrive drivetrain;
	
	public static Encoder lEncoder;
	public static Encoder rEncoder;
	
	public Drivetrain(){
		
		//initialization using constructor
		L1TalonSRX = new WPI_TalonSRX(RobotMap.dL1TalonSRX);
		L2TalonSRX = new WPI_TalonSRX(RobotMap.dL2TalonSRX);
		R1TalonSRX = new WPI_TalonSRX(RobotMap.dR1TalonSRX);
		R2TalonSRX = new WPI_TalonSRX(RobotMap.dR2TalonSRX);
		
		LDrivetrain = new SpeedControllerGroup(L1TalonSRX, L2TalonSRX);
		RDrivetrain = new SpeedControllerGroup(R1TalonSRX, R2TalonSRX);
		drivetrain = new DifferentialDrive(LDrivetrain, RDrivetrain);
		
		lEncoder = new Encoder(0,1);
		rEncoder = new Encoder(2,3);
		
		lEncoder.setDistancePerPulse(1/360);
		rEncoder.setDistancePerPulse(1/360);
		encoderReset();
	}
	
	public void initDefaultCommand() {
		
		//setting default command to tankdrive
		setDefaultCommand(new TankDrive());
	}
	
	public DifferentialDrive getDriveTrain() {
		
		return drivetrain;
	}
	
	public void encoderReset() {
		
		lEncoder.reset();
		rEncoder.reset();
	}
	
	public Encoder getLEncoder() {
		return lEncoder;
	}
	
	public Encoder getREncoder() {
		return rEncoder;
	}
	
	public void motorInverted(boolean inverted) {
		if (inverted) {
			L1TalonSRX.setInverted(true);
			L2TalonSRX.setInverted(true);
			R1TalonSRX.setInverted(true);
			R2TalonSRX.setInverted(true);
		} else {
			L1TalonSRX.setInverted(false);
			L2TalonSRX.setInverted(false);
			R1TalonSRX.setInverted(false);
			R2TalonSRX.setInverted(false);
		}
	}
	
	public void encoderInverted(boolean inverted) {
		if (inverted) {
			lEncoder.setReverseDirection(true);
			rEncoder.setReverseDirection(true);
		} else {
			lEncoder.setReverseDirection(false);
			rEncoder.setReverseDirection(false);
		}
	}
}
