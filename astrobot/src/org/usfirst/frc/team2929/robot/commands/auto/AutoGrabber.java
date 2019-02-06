

package org.usfirst.frc.team2929.robot.commands.auto;

import org.usfirst.frc.team2929.robot.commands.auto.Timeout;
import org.usfirst.frc.team2929.robot.commands.grabber.GrabberPush;
import org.usfirst.frc.team2929.robot.commands.lift.LiftPiston;
import org.usfirst.frc.team2929.robot.utility.ObjectSelect;
import org.usfirst.frc.team2929.robot.utility.PistonSelect;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoGrabber extends CommandGroup{
	/**
	 * Uses vision to go to a cargo bay and put cargo in it on levels 1 & 2.
	 * 
	 * @param  level which level to put the cargo in
	 * @author      Matthew Brosnon
	 */
	public AutoGrabber(int level) {
		if (level == 1) {
			addSequential(new AimAtTarget(ObjectSelect.CENTER));
			addSequential(new DriveToDistance(12));
			addSequential(new GrabberPush(PistonSelect.FORWARD));
			addSequential(new Timeout(0.5));
			addSequential(new GrabberPush(PistonSelect.REVERSE));
			addSequential(new GrabberPush(PistonSelect.OFF));
		} else if (level == 2) {
			addSequential(new AimAtTarget(ObjectSelect.CENTER));
			addSequential(new DriveToDistance(12));
			addParallel(new LiftPiston(PistonSelect.FORWARD));
			addSequential(new GrabberPush(PistonSelect.FORWARD));
			addSequential(new Timeout(0.5));
			addSequential(new GrabberPush(PistonSelect.REVERSE));
			addSequential(new GrabberPush(PistonSelect.OFF));
		}
	}
}
