package org.usfirst.frc.team2929.robot.subsystems;

import org.usfirst.frc.team2929.robot.RobotMap;
import org.usfirst.frc.team2929.robot.commands.lift.LiftPiston;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Lift setup and methods.
 * 
 * @author Matthew Brosnon
 */
public class Lift extends Subsystem {

	//creating components
	DoubleSolenoid liftSolenoid = new DoubleSolenoid(RobotMap.lsolenoidL, RobotMap.lsolenoidR);
	
	/**
	 * Defines the default command. Called when the subsystem is made.
	 * 
	 */
	public void initDefaultCommand() {
		
		//setting default command to lift piston
		setDefaultCommand(new LiftPiston());
		
	}
	
	/**
	 * Pushes forward the lift solenoid.
	 * 
	 */
	public void pushSolenoid() {
		liftSolenoid.set(Value.kForward);
	}
	
	/**
	 * Pulls in the lift solenoid.
	 * 
	 */
	public void reverseSolenoid() {
		liftSolenoid.set(Value.kReverse);
	}
	
	/**
	 * Turns off the lift solenoid.
	 * 
	 */
	public void offSolenoid() {
		liftSolenoid.set(Value.kOff);
	}
}
