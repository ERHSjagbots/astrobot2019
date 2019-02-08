package org.usfirst.frc.team2929.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2929.robot.utility.Direction;
import org.usfirst.frc.team2929.robot.utility.ObjectSelect;

/**
 * Autonomous command to look at a vision target
 * 
 * @author          Matthew Brosnon
 */
public class AimAtTarget extends Command {
	
	//variables
	private int selection;
	
	private boolean finished;
	private double center;
	private boolean direction;
	
	private boolean foundObject;
	
	/**
	 * Uses vision to find an object and rotate the robot to look at said object.
	 * 
	 * @param  selector an ObjectSelect item saying to look at the left, middle, or right of the objects
	 */
	public AimAtTarget(ObjectSelect selector) {
		
		//requires drivetrain system
		requires(Robot.drivetrain);
		
		//variable setup depending on parameter
		finished = false;
		selection = selector.getValue();
		foundObject = false;
		direction = true;
		
	}
	
	/**
	 * Uses vision to turn in a direction until it finds an object
	 * 
	 * @param selector ObjectSelect item on where to look at an object
	 * @param right Direction item on which way to turn
	 */
	public AimAtTarget(ObjectSelect selector, Direction right) {
		
		//requires drivetrain system
		requires(Robot.drivetrain);
		
		//variable setup and stuff
		finished = false;
		selection = selector.getValue();
		foundObject = false;
		if(right.getValue() == 0) direction = false;
		else direction = true;
	}

	@Override
	protected void initialize() {
		
		//Sees if the robot sees an object
		if (selection == 0 || selection == 1) {
			if(!(Robot.centerX == 0)) {
				foundObject = true;
			}
		} else if (selection == 2){
			if(!(Robot.centerX2 == 0)) {
				foundObject = true;
			}
		}
	}

	@Override
	protected void execute() {
		
		//Finds object before running code
		while (!foundObject) {
			
			if (direction) Robot.drivetrain.getDriveTrain().tankDrive(0.4, -0.4);
			else Robot.drivetrain.getDriveTrain().tankDrive(-0.4, 0.4);
			
			if (selection == 0 || selection == 1) {
				if(!(Robot.centerX == 0)) {
					foundObject = true;
				}
			} else if (selection == 2){
				if(!(Robot.centerX2 == 0)) {
					foundObject = true;
				}
			}
		}
		
		//Sets center to 0 in case there's no object to be found
		center = 0;
		
		//Sets the center of the object
		if (selection == 0 && Robot.centerX > 0) {
			center = Robot.centerX;
		} else if (selection == 1) {
			if (Robot.centerX > 0 && Robot.centerX2 > 0) {
				center = (Robot.centerX + Robot.centerX2) / 2; 
			} else if (Robot.centerX > 0) {
				center = Robot.centerX;
			} else if (Robot.centerX2 > 0) {
				center = Robot.centerX2;
			}
		} else if (selection == 2 && Robot.centerX2 > 0){
			center = Robot.centerX2;
		}
		
		SmartDashboard.putNumber("center command", center);
		
		//Turns the bot in the direction of the center of the object
		if (center > 370) {
			Robot.drivetrain.getDriveTrain().tankDrive(0.35, -0.35);
		} else if (center == 0) {
			Robot.drivetrain.getDriveTrain().tankDrive(0, 0);
		} else if (center < 270) {
			Robot.drivetrain.getDriveTrain().tankDrive(-0.35, 0.35);
		} else {
			Robot.drivetrain.getDriveTrain().tankDrive(0, 0);
			finished = true;
		}
		
		
	}

	@Override
	protected boolean isFinished() {
		//finishes when the command is finished
		return finished;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
