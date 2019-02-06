package org.usfirst.frc.team2929.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.subsystems.Drivetrain;


public class TankDrive extends Command {
	
	/**
	 * Gets values from joysticks to move the drivetrain.
	 * 
	 * @author Matthew Brosnon
	 */
	public TankDrive() {
		
		requires(Robot.drivetrain);
	}

	
	@Override
	protected void initialize() {
	}

	
	@Override
	protected void execute() {
		//tank drive using joysticks
		Robot.drivetrain.getDriveTrain().tankDrive(Robot.m_oi.getRJoystick().getY(),Robot.m_oi.getLJoystick().getY());
	}

	
	@Override
	protected boolean isFinished() {
		return false;
	}

	
	@Override
	protected void end() {
	}

	
	@Override
	protected void interrupted() {
	}
}
