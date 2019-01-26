/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Compressorino extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	Compressor comp = new Compressor();
	
	public Compressorino() {
		comp.setClosedLoopControl(true);
		comp.start();
	}
	
	public void initDefaultCommand() {
		
		
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void compOn() {
		comp.start();
	}
	
	public void compOff() {
		comp.stop();
	}
}
