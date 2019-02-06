package org.usfirst.frc.team2929.robot.vision;

import edu.wpi.cscore.UsbCamera;

/**
 * Holds information on the camera and creates camera objects.
 * 
 * @author Matthew Brosnon
 */
public class Camera {
	
	//creation of camera
	private UsbCamera camera;
	
	/**
	 * Sets the camera of this class to the given camera.
	 * 
	 * @param camera camera wanted to be assigned to the camera of this class
	 */
	public Camera(UsbCamera camera) {
		//assigns camera value
		this.camera = camera;
	}
	
	/**
	 * Returns the camera.
	 * 
	 * @return camera class camera
	 */
	public UsbCamera getCamera() {
		return camera;
	}
}
