/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot.subsystems;

import org.usfirst.frc.team2929.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Grabber extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	WPI_TalonSRX grabberMotor = new WPI_TalonSRX(RobotMap.grabberMotor);
	
	DoubleSolenoid pushSolenoid1 = new DoubleSolenoid(RobotMap.gsolenoid1L,RobotMap.gsolenoid1R);
	DoubleSolenoid pushSolenoid2 = new DoubleSolenoid(RobotMap.gsolenoid2L,RobotMap.gsolenoid2R);
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void pushGrabbie() {
		pushSolenoid1.set(Value.kForward);
		pushSolenoid2.set(Value.kForward);
	}
	
	public void reverseGrabbie() {
		pushSolenoid1.set(Value.kReverse);
		pushSolenoid2.set(Value.kReverse);
	}
	
	public void offGrabbie() {
		pushSolenoid1.set(Value.kOff);
		pushSolenoid2.set(Value.kOff);
	}
	
	public void setMotorSpeed(double speed) {
		grabberMotor.set(speed);
	}
}
