package org.usfirst.frc.team2929.robot.vision;

import edu.wpi.cscore.UsbCamera;

public class Camera {
	
	private UsbCamera camera;
	
	public Camera(UsbCamera camera) {
		this.camera = camera;
	}
	
	public UsbCamera getCamera() {
		return camera;
	}
}
