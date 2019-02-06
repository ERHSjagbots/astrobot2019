
package org.usfirst.frc.team2929.robot.commands.lift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.utility.PistonSelect;

/**
 * Command to manipulate the piston on the lift.
 * 
 * @author          Matthew Brosnon
 */
public class LiftPiston extends Command {
	
	//variable creation
	public int select;
	public boolean finished;
	
	/**
	 * Lifts lift piston depending on joystick input.
	 * 
	 */
	public LiftPiston() {
		
		//requires grabbie subsystem
		requires(Robot.grabbie);
		
		//sets select to a value not able to be reached by PistonSelect enum
		select = 3;
		
	}
	
	/**
	 * Manipulates lift piston depending on a value.
	 * 
	 * @param  selection enum on what direction to go on
	 */
	public LiftPiston(PistonSelect selection) {
		
		//requires grabbie subsystem
		requires(Robot.grabbie);
		
		//sets select to PistonSelect value
		select = selection.getValue();
		
		//sets timeout to 1 second
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
		//changes when command finishes depending on constructor used
		if (select == 3) {
			return false;
		} else {
			return isTimedOut();
		}
	}

	
	@Override
	protected void end() {
	}

	
	@Override
	protected void interrupted() {
	}
}
