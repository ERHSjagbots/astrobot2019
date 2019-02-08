package org.usfirst.frc.team2929.robot.utility;

import org.usfirst.frc.team2929.robot.Robot;

/**
 * Methods for vision-related math functions.
 * 
 * @author Matthew Brosnon
 */
public class Maths {
	
	/**
	 * Gives distance of an object based on how wide it is in pixels.
	 * 
	 * @param  pixels how wide the object is in pixels.
	 * @return double distance of object
	 */
	public static double distance(double pixels) {
		
		//return 145 * (Math.pow(0.71, distance)) + 8.8;
		
		//function to get distance from pixel width
		return 4009 * Math.pow(pixels, -1.169746);
	}
	
	public static double visionAngle() {
		return 90 - (90 - Math.acos((Math.pow(distance(Robot.distToObj1), 2) + Math.pow(9.377, 2) - Math.pow(Robot.distToObj2, 2))/(2 * Robot.distToObj1 * 9.377)));
	}
	
	public static double visionSide() {
		return distance((Robot.r1.width + Robot.r2.width)/2) * Math.cos(visionAngle());
	}
	
}
