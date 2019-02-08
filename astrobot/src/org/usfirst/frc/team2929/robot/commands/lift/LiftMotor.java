
package org.usfirst.frc.team2929.robot.commands.lift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.utility.PistonSelect;

/**
 * Command to manipulate the piston on the lift.
 * 
 * @author          Matthew Brosnon
 */
public class LiftMotor extends Command {
	
	//variable creation
	public int constructor;
	public boolean finished;
	
	public double speed;
	
	/**
	 * Lifts lift piston depending on joystick input.
	 * 
	 */
	public LiftMotor() {
		
		//requires lift subsystem
		requires(Robot.lift);
		
		//lets code see which constructor
		constructor = 0;
	}
	
	public LiftMotor(double speed, double timeOut) {
		
		//requires grabbie subsystem
		requires(Robot.lift);
		
		//lets code see which constructor
		constructor = 1;
		
		//setup
		this.speed = speed;
	}

	
	@Override
	protected void initialize() {
	}

	
	@Override
	protected void execute() {
		//moves piston depending on joystick if no select value given
		if (constructor == 0) {
			if (Robot.m_oi.getLJoystick().getPOV(0) <= 45 || Robot.m_oi.getLJoystick().getPOV(0) >= 315) {
				Robot.grabbie.setMotorSpeed(0.5);
			} else if (Robot.m_oi.getLJoystick().getPOV(0) <= 225 && Robot.m_oi.getLJoystick().getPOV(0) >= 135) {
				Robot.grabbie.setMotorSpeed(-0.5);
			} else {
				Robot.grabbie.setMotorSpeed(0);
			}
		} 
		
		//otherwise uses the value given in second constructor
		else {
			Robot.grabbie.setMotorSpeed(speed);
		}
	}

	
	@Override
	protected boolean isFinished() {
		//changes when command finishes depending on constructor used
		if(constructor == 0) return false;
		else return isTimedOut();
	}

	
	@Override
	protected void end() {
	}

	
	@Override
	protected void interrupted() {
	}
}
