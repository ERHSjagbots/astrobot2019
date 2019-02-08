

package org.usfirst.frc.team2929.robot.commands.auto;

import org.usfirst.frc.team2929.robot.commands.auto.Timeout;
import org.usfirst.frc.team2929.robot.commands.drivetrain.DriveForward;
import org.usfirst.frc.team2929.robot.commands.grabber.GrabberEject;
import org.usfirst.frc.team2929.robot.commands.grabber.MoveGrabbie;
import org.usfirst.frc.team2929.robot.commands.lift.LiftMotor;
import org.usfirst.frc.team2929.robot.utility.ObjectSelect;
import org.usfirst.frc.team2929.robot.utility.PistonSelect;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous code for grabber manipulation, specifically for the hatch.
 * 
 * @author Matthew Brosnon
 */
public class AutoHatch extends CommandGroup{
	
	/**
	 * Uses vision to go to a cargo bay and put a hatch on it on levels 1 & 2.
	 * 
	 * @param level which level to put the hatch on
	 */
	public AutoHatch(int level) {
		//adds commands based on level
		if (level == 1) {
			addSequential(new AimAtTarget(ObjectSelect.CENTER));
			addSequential(new DriveToDistance(12));
			addSequential(new MoveGrabbie(0.5, 0.25));
			addSequential(new DriveForward(-12));
		} else if (level == 2) {
			addSequential(new AimAtTarget(ObjectSelect.CENTER));
			addSequential(new DriveToDistance(12));
			addParallel(new LiftMotor(0.5, 0.5));
			addSequential(new MoveGrabbie(0.5, 0.25));
			addParallel(new LiftMotor(-0.5, 0.5));
			addParallel(new DriveForward(-12));
		}
	}
}
