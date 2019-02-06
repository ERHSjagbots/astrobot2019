package org.usfirst.frc.team2929.robot.commands.grabber;

import org.usfirst.frc.team2929.robot.commands.auto.Timeout;
import org.usfirst.frc.team2929.robot.utility.PistonSelect;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command sequence to eject a cargo from the grabber.
 * 
 * @author          Matthew Brosnon
 */
public class GrabberEject extends CommandGroup{
	
	/**
	 * Ejects cargo from the grabber. 
	 * 
	 */
	public GrabberEject() {
		//adds commands
		addSequential(new GrabberPush(PistonSelect.FORWARD));
		addSequential(new Timeout(0.5));
		addSequential(new GrabberPush(PistonSelect.REVERSE));
		addSequential(new GrabberPush(PistonSelect.OFF));
	}
}
