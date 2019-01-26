package org.usfirst.frc.team2929.robot.commands.arm;

import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.command.*;

public class ArmUp extends Command
{
	public ArmUp()
	{
		requires(Robot.arm);
	}
	
	protected void intitialize()
	{
		Arm.initializeCounter();
		Arm.armUp();
	}

	protected void execute()
	{
	}
	
	protected boolean isFinished()
	{
		return Arm.isSwitchSet();
	}
	
	protected void end()
	{
		Arm.armStop();
	}
	
	protected void interrupted()
	{
		end();
	}
}

//Documentation for code. DO NOT DELETE!!!
//https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599744-using-limit-switches-to-control-behavior