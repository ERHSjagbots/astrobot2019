

package org.usfirst.frc.team2929.robot.commands.auto;

import org.usfirst.frc.team2929.robot.commands.auto.Timeout;
import org.usfirst.frc.team2929.robot.commands.drivetrain.DriveForward;
import org.usfirst.frc.team2929.robot.commands.grabber.GrabberEject;
import org.usfirst.frc.team2929.robot.commands.lift.LiftPiston;
import org.usfirst.frc.team2929.robot.utility.ObjectSelect;
import org.usfirst.frc.team2929.robot.utility.PistonSelect;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous code for grabber manipulation, specifically for cargo.
 * 
 * @author Matthew Brosnon
 */
public class AutoCargo extends CommandGroup{
	
	/**
	 * Uses vision to go to a cargo bay and put cargo it on levels 1 & 2.
	 * 
	 * @param level which level to put the cargo in
	 */
	public AutoCargo(int level) {
		//adds commands based on level
		if (level == 1) {
			addSequential(new AimAtTarget(ObjectSelect.CENTER));
			addSequential(new DriveToDistance(12));
			addSequential(new GrabberEject());
			addSequential(new DriveForward(-12));
		} else if (level == 2) {
			addSequential(new AimAtTarget(ObjectSelect.CENTER));
			addSequential(new DriveToDistance(12));
			addParallel(new LiftPiston(PistonSelect.FORWARD));
			addSequential(new GrabberEject());
			addSequential(new LiftPiston(PistonSelect.REVERSE));
			addParallel(new DriveForward(-12));
		}
	}
}
