package org.usfirst.frc.team2929.robot.commands.grabber;

import org.usfirst.frc.team2929.robot.commands.auto.Timeout;
import org.usfirst.frc.team2929.robot.utility.PistonSelect;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GrabberEject extends CommandGroup{
	public GrabberEject() {
		addSequential(new GrabberPush(PistonSelect.FORWARD));
		addSequential(new Timeout(0.5));
		addSequential(new GrabberPush(PistonSelect.REVERSE));
		addSequential(new GrabberPush(PistonSelect.OFF));
	}
}
