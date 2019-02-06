package org.usfirst.frc.team2929.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.utility.*;

/**
 * Autonomous command to drive to a distance from a vision object
 * 
 * @author          Matthew Brosnon
 */
public class DriveToDistance extends Command {
	
	//variables
	private double target;
	private boolean finished = false;
	private double width = 0;
	
	/**
	 * Drives straight to a set distance from an object.
	 * 
	 * @param  distance double of how far you need to be away from object
	 */
	public DriveToDistance(double distance) {
		
		//requires drivetrain subsystem
		requires(Robot.drivetrain);
		
		//variable setup
		target = distance;
		finished = false;
		
	}

	
	@Override
	protected void initialize() {
		//setup
		width = 0;
	}

	
	@Override
	protected void execute() {
		//using math to find width-to-distance
		width = (Robot.r1.width + Robot.r2.width) / 2;
		SmartDashboard.putNumber("Average Width", width);
		SmartDashboard.putNumber("math.distance", target);
		SmartDashboard.putNumber("math.distance width", Maths.distance(width));
		
		//driving to object
		if (width == 0) {
			finished = true;
		}	else if (Maths.distance(width) > target + 1) {
			Robot.drivetrain.getDriveTrain().tankDrive(-0.5, -0.5);
		} else if (Maths.distance(width) < target - 1) {
			Robot.drivetrain.getDriveTrain().tankDrive(0.5, 0.5);
		} else {
			finished = true;
		}
	}

	
	@Override
	protected boolean isFinished() {
		//finished when we're finished
		return finished;
	}

	
	@Override
	protected void end() {
	}


	@Override
	protected void interrupted() {
	}
}
