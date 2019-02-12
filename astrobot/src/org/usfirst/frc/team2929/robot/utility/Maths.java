package org.usfirst.frc.team2929.robot.utility;

import java.util.ArrayList;

import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2929.robot.Robot;
import org.usfirst.frc.team2929.robot.vision.GripPipeline;

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
	
	public static int returnXLargest(GripPipeline pipeline, int x) {
		
		//fills arrays with 0s depending on what largest you want
		ArrayList<Integer> id = new ArrayList<Integer>();
		if (x - 1 > pipeline.filterContoursOutput().size()) {
			for(int i = 0; i < pipeline.filterContoursOutput().size(); i++) {
				id.add(0);
			}
		} else {
			for(int i = 0; i < x; i++) {
				id.add(0);
			}
		}
		
		//x better for arrays
		x = x - 1;
		
		//finds the biggest widths
		for(int i = 0; pipeline.filterContoursOutput().size()< i; i++) {
			if(Imgproc.boundingRect(pipeline.filterContoursOutput().get(i)).width < id.get(0)) {
				for(int y = id.size(); y > 1; y--) {
					id.set(y, id.get(y-1));
				}
				id.set(0, i);
			}
		}
		
		//returns outputs
		if (id.get(x) != 0) {
			return id.get(x);
		} else {
			for(int i = id.size(); i > 0; i--) {
				if(id.get(i) != 0) {
					return id.get(i);
				}
			}
		}
		
		//if for some reason Jeff's an idiot return 0
		return 0;
	}
	
}
