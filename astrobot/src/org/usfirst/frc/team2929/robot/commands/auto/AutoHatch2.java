

package org.usfirst.frc.team2929.robot.commands.auto;

import org.usfirst.frc.team2929.robot.commands.auto.Timeout;
import org.usfirst.frc.team2929.robot.commands.drivetrain.DriveForward;
import org.usfirst.frc.team2929.robot.commands.drivetrain.TurnAngle;
import org.usfirst.frc.team2929.robot.commands.grabber.GrabberEject;
import org.usfirst.frc.team2929.robot.commands.grabber.MoveGrabbie;
import org.usfirst.frc.team2929.robot.commands.lift.LiftPiston;
import org.usfirst.frc.team2929.robot.utility.Direction;
import org.usfirst.frc.team2929.robot.utility.Maths;
import org.usfirst.frc.team2929.robot.utility.ObjectSelect;
import org.usfirst.frc.team2929.robot.utility.PistonSelect;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * More complex autonomous code for grabber manipulation, specifically for the hatch.
 * 
 * @author Matthew Brosnon
 */
public class AutoHatch2 extends CommandGroup{
	
	private double angle;
	private double sideLength;
	private boolean right = true;
	
	/**
	 * Uses vision to go to a cargo bay and put a hatch on it on levels 1 & 2.
	 * 
	 * @param level which level to put the hatch on
	 */
	public AutoHatch2(int level) {
		
		sideLength = Maths.visionSide();
		if (Maths.visionAngle() >= 0) {
			angle = Maths.visionAngle();
		} else {
			angle = -Maths.visionAngle();
			right = false;
		}
		
		
		//adds commands based on level
		if (level == 1) {
			if (right) addSequential(new TurnAngle(angle, Direction.RIGHT));
			else addSequential(new TurnAngle(angle, Direction.LEFT));
			
			addSequential(new DriveForward(sideLength));
			
			if (right) addSequential(new AimAtTarget(ObjectSelect.CENTER, Direction.LEFT));
			else addSequential(new AimAtTarget(ObjectSelect.CENTER, Direction.RIGHT));
			
			addSequential(new DriveToDistance(12));
			addSequential(new MoveGrabbie(0.5, 0.25));
			addSequential(new DriveForward(-12));
		} else if (level == 2) {
			if(right) addSequential(new TurnAngle(angle, Direction.RIGHT));
			else addSequential(new TurnAngle(angle, Direction.LEFT));
			
			addSequential(new DriveForward(sideLength));
			
			if (right) addSequential(new AimAtTarget(ObjectSelect.CENTER, Direction.LEFT));
			else addSequential(new AimAtTarget(ObjectSelect.CENTER, Direction.RIGHT));
			
			addSequential(new DriveToDistance(12));
			addParallel(new LiftPiston(PistonSelect.FORWARD));
			addSequential(new MoveGrabbie(0.5, 0.25));
			addSequential(new LiftPiston(PistonSelect.REVERSE));
			addParallel(new DriveForward(-12));
		}
	}
}
