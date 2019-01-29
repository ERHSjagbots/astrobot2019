/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot.subsystems;

import org.usfirst.frc.team2929.robot.RobotMap;
import org.usfirst.frc.team2929.robot.commands.lift.LiftPiston;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Lift extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	DoubleSolenoid liftSolenoid = new DoubleSolenoid(RobotMap.lsolenoidL, RobotMap.lsolenoidR);
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new LiftPiston());
		
	}
	
	public void pushSolenoid() {
		liftSolenoid.set(Value.kForward);
	}
	
	public void reverseSolenoid() {
		liftSolenoid.set(Value.kReverse);
	}
	
	public void offSolenoid() {
		liftSolenoid.set(Value.kOff);
	}
}
