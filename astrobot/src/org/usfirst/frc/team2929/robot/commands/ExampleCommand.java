package org.usfirst.frc.team2929.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2929.robot.Robot;


public class ExampleCommand extends Command {
	/**
	 * -INSERT JAVADOC HERE-
	 * 
	 * @param  example Example used for example
	 * @author        AUTHOR HERE
	 */
	public ExampleCommand() {
		
		requires(Robot.m_subsystem);
	}

	
	@Override
	protected void initialize() {
	}

	
	@Override
	protected void execute() {
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
