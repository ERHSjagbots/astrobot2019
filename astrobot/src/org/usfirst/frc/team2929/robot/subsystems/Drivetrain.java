package org.usfirst.frc.team2929.robot.subsystems;

import org.usfirst.frc.team2929.robot.RobotMap;
import org.usfirst.frc.team2929.robot.commands.drivetrain.TankDrive;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Drivetrain components and methods.
 * 
 * @author Matthew Brosnon
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
	
	//setup of encoders
	public static Encoder lEncoder;
	public static Encoder rEncoder;
	
	public static ADXRS450_Gyro gyro;
	
	/**
	 * Sets values of all the motors, drivetrain, and encoders.
	 * 
	 */
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
		
		gyro = new ADXRS450_Gyro();
		
		lEncoder.setDistancePerPulse(1/360);
		rEncoder.setDistancePerPulse(1/360);
		encoderReset();
	}
	
	/**
	 * Defines the default command. Called when the subsystem is made.
	 * 
	 */
	public void initDefaultCommand() {
		
		//setting default command to tankdrive
		setDefaultCommand(new TankDrive());
	}
	
	/**
	 * Returns the robot drivetrain.
	 * 
	 * @return DifferentialDrive robot drivetrain
	 */
	public DifferentialDrive getDriveTrain() {
		
		//getting a drivertrain
		return drivetrain;
	}
	
	/**
	 * Resets encoders.
	 * 
	 */
	public void encoderReset() {
		
		//resets encoders
		lEncoder.reset();
		rEncoder.reset();
	}
	
	/**
	 * Returns the left drivetrain encoder.
	 * 
	 * @return Encoder left drivetrain encoder
	 */
	public Encoder getLEncoder() {
		
		//returns left encoder
		return lEncoder;
	}
	
	/**
	 * Returns the right drivetrain encoder.
	 * 
	 * @return Encoder right drivetrain encoder
	 */
	public Encoder getREncoder() {
		
		//returns right encoder
		return rEncoder;
	}
	
	/**
	 * Returns the gyro.
	 * 
	 * @return ADXRS450_Gyro gyro
	 */
	public ADXRS450_Gyro getGyro() {
		
		//returns gyro
		return gyro;
	}
	
	/**
	 * Inverts motor controls or un-inverts them
	 * 
	 * @param inverted true or false depending on whether you want motors inverted or not
	 */
	public void motorInverted(boolean inverted) {
		
		//uses input to change inverted method on motors
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
	
	/**
	 * Inverts encoder readings or un-inverts them
	 * 
	 * @param inverted true or false depending on whether you want encoders inverted or not
	 */
	public void encoderInverted(boolean inverted) {
		
		//uses input to change inverted method for encoders
		if (inverted) {
			lEncoder.setReverseDirection(true);
			rEncoder.setReverseDirection(true);
		} else {
			lEncoder.setReverseDirection(false);
			rEncoder.setReverseDirection(false);
		}
	}
}
