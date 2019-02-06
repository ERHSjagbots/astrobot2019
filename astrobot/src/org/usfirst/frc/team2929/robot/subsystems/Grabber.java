package org.usfirst.frc.team2929.robot.subsystems;

import org.usfirst.frc.team2929.robot.RobotMap;
import org.usfirst.frc.team2929.robot.commands.grabber.MoveGrabbie;
import org.usfirst.frc.team2929.robot.commands.lift.LiftPiston;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Grabber subsystem setup and methods.
 * 
 * @author         Matthew Brosnon
 */
public class Grabber extends Subsystem {
	
	//creating components
	DigitalInput lLimitSwitch = new DigitalInput(RobotMap.gls1);
	DigitalInput rLimitSwitch = new DigitalInput(RobotMap.gls2);
	//Counter counter = new Counter(limitSwitch);
	
	WPI_TalonSRX grabberMotor = new WPI_TalonSRX(RobotMap.grabberMotor);
	WPI_TalonSRX rotateMotor = new WPI_TalonSRX(RobotMap.grabberRotate);
	
	DoubleSolenoid pushSolenoid1 = new DoubleSolenoid(RobotMap.gsolenoid1L,RobotMap.gsolenoid1R);
	DoubleSolenoid pushSolenoid2 = new DoubleSolenoid(RobotMap.gsolenoid2L,RobotMap.gsolenoid2R);
	
	/**
	 * Defines the default command. Called when the subsystem is made.
	 * 
	 */
	public void initDefaultCommand() {
		
		//setting default command to move grabbie
		setDefaultCommand(new MoveGrabbie());
		
	}
	
	/**
	 * Pushes grabber solenoid forwards.
	 * 
	 */
	public void pushGrabbie() {
		//pushes solenoid forwards
		pushSolenoid1.set(Value.kForward);
		pushSolenoid2.set(Value.kForward);
	}
	
	/**
	 * Pushes grabber solenoid backwards.
	 * 
	 */
	public void reverseGrabbie() {
		//pushes solenoid backwards
		pushSolenoid1.set(Value.kReverse);
		pushSolenoid2.set(Value.kReverse);
	}
	
	/**
	 * Turns grabber solenoid off.
	 * 
	 */
	public void offGrabbie() {
		//turns off solenoid
		pushSolenoid1.set(Value.kOff);
		pushSolenoid2.set(Value.kOff);
	}
	
	/**
	 * Moves grabbie from side to side at a certain speed.
	 * 
	 * @param speed speed for motors to move
	 * @author      Matthew Brosnon
	 */
	public void setMotorSpeed(double speed) {
		grabberMotor.set(speed);
	}
	
	/**
	 * Moves grabbie from up and down at a certain speed.
	 * 
	 * @param speed speed for motors to move
	 * @author      Matthew Brosnon
	 */
	public void rotateMotorSpeed(double speed) {
		rotateMotor.set(speed);
	}
	
	/**
	 * Tests for left side limit switch to be set.
	 * 
	 * @author      Matthew Brosnon
	 */
	public boolean isLSwitchSet() {
		return lLimitSwitch.get();
	}
	
	/**
	 * Tests for right side limit switch to be set.
	 * 
	 * @author      Matthew Brosnon
	 */
	public boolean isRSwitchSet() {
		return rLimitSwitch.get();
	}
}
