package org.usfirst.frc.team2929.robot.subsystems;

import org.usfirst.frc.team2929.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

public class Arm extends Subsystem
{
	static DigitalInput limitSwitch = new DigitalInput(RobotMap.armLS1);
	static WPI_TalonSRX armMotor = new WPI_TalonSRX(RobotMap.armMotor);
	static Counter counter = new Counter(limitSwitch);
	
	public static boolean isSwitchSet()
	{
		return counter.get() > 0;
	}
	
	public static void initializeCounter()
	{
		counter.reset();
	}
	
	public static void armUp()
	{
		armMotor.set(0.5);
	}
	
	public void armDown()
	{
		armMotor.set(-0.5);
	}
	
	public static void armStop()
	{
		armMotor.set(0);
	}
	
	protected void initDefaultCommand()
	{
	}
}

//Documentation for code. DO NOT DELETE!!!
//https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599744-using-limit-switches-to-control-behavior