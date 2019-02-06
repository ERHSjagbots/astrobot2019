
package org.usfirst.frc.team2929.robot.commands.lift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.utility.PistonSelect;


public class LiftPiston extends Command {
	
	public int select;
	public boolean finished;
	
	/**
	 * Lifts lift piston depending on joystick input.
	 * 
	 * @author Matthew Brosnon
	 */
	public LiftPiston() {
		
		requires(Robot.grabbie);
		select = 3;
		
	}
	
	/**
	 * Manipulates lift piston depending on a value.
	 * 
	 * @param  selection enum on what direction to go on
	 * @author           Matthew Brosnon
	 */
	public LiftPiston(PistonSelect selection) {
		
		select = selection.getValue();
		setTimeout(1);
	}

	
	@Override
	protected void initialize() {
	}

	
	@Override
	protected void execute() {
		//moves piston depending on joystick if no select value given
		if (select == 3) {
			if (Robot.m_oi.getLJoystick().getPOV(0) <= 45 || Robot.m_oi.getLJoystick().getPOV(0) >= 315) {
				Robot.grabbie.pushGrabbie();
			} else if (Robot.m_oi.getLJoystick().getPOV(0) <= 225 && Robot.m_oi.getLJoystick().getPOV(0) >= 135) {
				Robot.grabbie.reverseGrabbie();
			} else {
				Robot.grabbie.offGrabbie();
			}
		} 
		
		//otherwise uses the value given in second constructor
		else if (select == 0) {
			Robot.grabbie.pushGrabbie();
		} else if (select == 1) {
			Robot.grabbie.reverseGrabbie();
		} else if (select == 2) {
			Robot.grabbie.offGrabbie();
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
