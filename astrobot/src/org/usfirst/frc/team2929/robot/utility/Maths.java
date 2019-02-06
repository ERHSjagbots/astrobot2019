package org.usfirst.frc.team2929.robot.utility;

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
	
}
