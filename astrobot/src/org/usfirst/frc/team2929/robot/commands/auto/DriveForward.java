package org.usfirst.frc.team2929.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;

/**
 * Autonomous command to drive forward a set distance.
 * 
 * @author          Matthew Brosnon
 */
public class DriveForward extends Command {
	
	private double distance;
	private boolean finished;
	
	/**
	 * Drives straight a set distance.
	 * 
	 * @param  distance double of how far you need to drive
	 */
	public DriveForward(double distance) {
		
		//requires drivetrain subsystem
		requires(Robot.drivetrain);
		
		//variable setup
		this.distance = distance;
		finished = false;
		
		//Makes everything run backwards if distance is negative
		if (distance < 0) {
			Robot.drivetrain.motorInverted(true);
			Robot.drivetrain.encoderInverted(true);
			this.distance = -this.distance;
		}
	}

	@Override
	protected void initialize() {
		
		//Reset encoders
		Robot.drivetrain.encoderReset();
	}

	@Override
	protected void execute() {
		
		//Uses encoders to account for differences in distance for each side of the drivetrain
		if(Robot.drivetrain.getLEncoder().getDistance() < distance && Robot.drivetrain.getREncoder().getDistance() < distance) {
			if (Math.abs(Robot.drivetrain.getLEncoder().getDistance() - Robot.drivetrain.getREncoder().getDistance()) <= 0.1) {
				Robot.drivetrain.getDriveTrain().tankDrive(0.5, 0.5);
			} else if (Robot.drivetrain.getLEncoder().getDistance() > Robot.drivetrain.getREncoder().getDistance()) {
				Robot.drivetrain.getDriveTrain().tankDrive(0.45, 0.55);
			} else {
				Robot.drivetrain.getDriveTrain().tankDrive(0.55, 0.45);
			}
		} else {
			Robot.drivetrain.getDriveTrain().tankDrive(0, 0);
			finished = true;
		}
	}

	
	@Override
	protected boolean isFinished() {
		//finished if code says we're finished
		return finished;
	}

	
	@Override
	protected void end() {
		//Reset everything
		Robot.drivetrain.motorInverted(false);
		Robot.drivetrain.encoderInverted(false);
		Robot.drivetrain.encoderReset();
	}

	
	@Override
	protected void interrupted() {
		//Reset everything
		Robot.drivetrain.motorInverted(false);
		Robot.drivetrain.encoderInverted(false);
		Robot.drivetrain.encoderReset();
	}
}
