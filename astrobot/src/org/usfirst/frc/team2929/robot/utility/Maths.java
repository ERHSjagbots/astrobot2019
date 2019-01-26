package org.usfirst.frc.team2929.robot.utility;

public class Maths {
	
	public static double distance(double distance) {
		
		//return 145 * (Math.pow(0.71, distance)) + 8.8;
		return 4009 * Math.pow(distance, -1.169746);
	}
	
}
