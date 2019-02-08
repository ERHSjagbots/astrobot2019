package org.usfirst.frc.team2929.robot.subsystems;

import org.usfirst.frc.team2929.robot.RobotMap;
import org.usfirst.frc.team2929.robot.commands.lift.LiftMotor;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

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
	WPI_TalonSRX liftMotor = new WPI_TalonSRX(RobotMap.liftMotor);
	
	/**
	 * Defines the default command. Called when the subsystem is made.
	 * 
	 */
	public void initDefaultCommand() {
		
		//setting default command to lift motor
		setDefaultCommand(new LiftMotor());
		
	}
	
	/**
	 * Sets value on the motor
	 * 
	 * @param speed speed for the motor
	 */
	public void setMotor(double speed) {
		liftMotor.set(speed);
	}
}
