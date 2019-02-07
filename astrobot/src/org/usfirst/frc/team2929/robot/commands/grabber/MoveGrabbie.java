

package org.usfirst.frc.team2929.robot.commands.grabber;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;

/**
 * Command to manipulate grabbie motor.
 * 
 * @author          Matthew Brosnon
 */
public class MoveGrabbie extends Command {
	
	private double speed;
	
	/**
	 * Moves grabbie left or right depending on joystick input.
	 * 
	 */
	public MoveGrabbie(/* double speed */) {
		
		//requries grabbie subsystem
		requires(Robot.grabbie);
		this.speed = 0;
		//this.speed = speed;
		
	}
	
	/**
	 * Moves grabbie left or right depending on parameter for a certain amount of time.
	 * 
	 * @param speed speed of grabbies
	 * @param time  time to move grabbies
	 */
	public MoveGrabbie(double speed, double time) {
		
		requires(Robot.grabbie);
		this.speed = speed;
		setTimeout(time);
		
	}

	
	@Override
	protected void initialize() {
	}

	
	@Override
	protected void execute() {
		//moves motor depending on joystick parameters
		if(speed == 0) {
			if (Robot.m_oi.getRJoystick().getPOV(0) >= 45 && Robot.m_oi.getRJoystick().getPOV(0) <= 135) {
				if (!Robot.grabbie.isRSwitchSet()) {
					Robot.grabbie.setMotorSpeed(0);
				} else {
					Robot.grabbie.setMotorSpeed(0.5);
				}
			} else if (Robot.m_oi.getRJoystick().getPOV(0) >= 225 && Robot.m_oi.getRJoystick().getPOV(0) <= 315) {
				if (!Robot.grabbie.isLSwitchSet()) {
					Robot.grabbie.setMotorSpeed(0);
				} else {
					Robot.grabbie.setMotorSpeed(-0.5);
				}
			} else {
			Robot.grabbie.setMotorSpeed(0);
			}
		}
		
		//moves motor is speed is given
		else {
			Robot.grabbie.setMotorSpeed(speed);
		}
	}

	
	@Override
	protected boolean isFinished() {
		//never finish command
		if (speed == 0) return false;
		else return isTimedOut();
	}

	
	@Override
	protected void end() {
	}

	
	@Override
	protected void interrupted() {
	}
}
