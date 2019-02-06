package org.usfirst.frc.team2929.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Setup for compressorino.
 * 
 * @author Matthew Brosnon
 */
public class Compressorino extends Subsystem {
	

	Compressor comp = new Compressor();
	
	/**
	 * Sets closed loop control and starts compressor.
	 * 
	 */
	public Compressorino() {
		
		//setup for compressor
		comp.setClosedLoopControl(true);
		comp.start();
	}
	
	/**
	 * Defines the default command. Called when the subsystem is made.
	 * 
	 */
	public void initDefaultCommand() {
		
		//setDefaultCommand();
		
	}
	
	/**
	 * Turns compressor on.
	 * 
	 */
	public void compOn() {
		
		//start compressor
		comp.start();
	}
	
	/**
	 * Turns compressor off.
	 * 
	 */
	public void compOff() {
		
		//stop compressor
		comp.stop();
	}
}
