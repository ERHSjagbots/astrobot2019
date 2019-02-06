package org.usfirst.frc.team2929.robot.commands.ramp;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;

/**
 * Command to manipulate the motor on the ramp.
 * 
 * @author          Matthew Brosnon
 */
public class MoveRampMotor extends Command {
	
	//variable to store speed
	private double speed;
	
	/**
	 * Moves motor on the ramp at a certain speed.
	 * 
	 * @param speed speed of motor
	 */
	public MoveRampMotor(double speed) {
		
		requires(Robot.ramp);
		this.speed = speed;
		
	}

	
	@Override
	protected void initialize() {
	}

	
	@Override
	protected void execute() {
		//moves motor at the speed given
		Robot.ramp.moveMotor(speed);
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
