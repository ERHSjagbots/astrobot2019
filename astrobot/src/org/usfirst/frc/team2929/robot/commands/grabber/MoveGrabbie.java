

package org.usfirst.frc.team2929.robot.commands.grabber;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;

public class MoveGrabbie extends Command {
	
	//private double speed;
	
	/**
	 * Moves grabbie left or right depending on joystick input.
	 * 
	 * @author Matthew Brosnon
	 */
	public MoveGrabbie(/* double speed */) {
		
		requires(Robot.grabbie);
		//this.speed = speed;
		
	}

	
	@Override
	protected void initialize() {
	}

	
	@Override
	protected void execute() {
		//moves motor depending on joystick parameters
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
