/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot;

import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionRunner;
import edu.wpi.first.wpilibj.vision.VisionThread;

import java.util.List;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2929.robot.commands.ExampleCommand;
import org.usfirst.frc.team2929.robot.commands.auto.AimAtTarget;
import org.usfirst.frc.team2929.robot.subsystems.Compressorino;
import org.usfirst.frc.team2929.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2929.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team2929.robot.subsystems.Grabber;
import org.usfirst.frc.team2929.robot.subsystems.Lift;
import org.usfirst.frc.team2929.robot.subsystems.RampSubsystem;
import org.usfirst.frc.team2929.robot.utility.ObjectSelect;
import org.usfirst.frc.team2929.robot.vision.Camera;
import org.usfirst.frc.team2929.robot.vision.GripPipeline;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */

public class Robot extends TimedRobot {
	public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
	public static Drivetrain drivetrain = new Drivetrain();
	public static OI m_oi;
	public static RampSubsystem ramp = new RampSubsystem();
	public static Lift lift = new Lift();
	public static Compressorino comp = new Compressorino();
	public static Grabber grabbie = new Grabber();
	
	public static Camera camera;
	
	public static VisionThread visionThread;
	public static final Object imgLock = new Object();
	public static MjpegServer contourServer;
	public static CvSource contourSource;
	public static Mat contourImage;
	
	public static double centerX;
	public static double center;
	public static double distToObj1;
	public static double dist;
	public static Rect r1;
	
	public static double centerX2;
	public static double center2;
	public static double distToObj2;
	public static double dist2;
	public static Rect r2;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		m_chooser.addDefault("Default Auto", new ExampleCommand());
		m_chooser.addObject("AimAtTarget", new AimAtTarget(ObjectSelect.CENTER));
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		
		
		camera = new Camera(CameraServer.getInstance().startAutomaticCapture(0));
		camera.getCamera().setVideoMode(PixelFormat.kMJPEG, 640, 480, 30);
		camera.getCamera().setBrightness(18);
		camera.getCamera().setExposureManual(18);
		
		contourServer = new MjpegServer("contours", 1189);
		contourSource = new CvSource("contours", PixelFormat.kMJPEG, 640, 480, 10);
		contourServer.setSource(contourSource);
		contourImage = new Mat(640, 480, CvType.CV_8SC1);
		
		visionThread = new VisionThread(camera.getCamera(), new GripPipeline(), new VisionRunner.Listener<GripPipeline>() {
			//double centerX;
			@Override
			public void copyPipelineOutputs(GripPipeline pipeline) {
	            SmartDashboard.putNumber("output size", pipeline.filterContoursOutput().size());
				if (pipeline.filterContoursOutput().size() > 0) {
		            r1 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
		            synchronized (imgLock) {
		                centerX = r1.x + (r1.width / 2);
		                distToObj1 = 0;
		                if(r1.area() > 30) {
		                	//Change distI to object distance through formula
		                }
		                SmartDashboard.putNumber("Object 1 Width (Pixels)", r1.width);
		                //SmartDashboard.putNumber("Object (0) Distance (Inches)", Maths.getObjectDistance(r.width, 2.0));
		                //FRCNet.readNetworkTableContours();
		            }
		        } else {
		        	synchronized (imgLock) {
		                centerX = 0;
		                distToObj1 = 0;
		                //FRCNet.readNetworkTableContours();
		            }
		        }
				if (pipeline.filterContoursOutput().size() > 1) {
		            r2 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1));
		            synchronized (imgLock) {
		                centerX2 = r2.x + (r2.width / 2);
		                distToObj2 = 0;
		                if(r2.area() > 30) {
		                	//change distI to object distance through formula
		                }
		                SmartDashboard.putNumber("Object 2 Width (Pixels)", r2.width);
		                //SmartDashboard.putNumber("Object (1) Distance (Inches)", Maths.getObjectDistance(r2.width, 2.0));
		                //FRCNet.readNetworkTableContours();
		            }
		        } else {
		        	synchronized (imgLock) {
		                centerX2 = 0;
		                distToObj2 = 0;
		                //FRCNet.readNetworkTableContours();
		            }
		        }
				
//				List<MatOfPoint> hulls = pipeline.findContoursOutput();

                // Draw all the contours such that they are filled in.
//                for (int i = 0; i < hulls.size(); i++) {
//                    Imgproc.drawContours(contourImage, hulls, i, new Scalar(255), 3);
//                }
                
				List<MatOfPoint> hulls = pipeline.convexHullsOutput();
				SmartDashboard.putNumber("centerX", centerX);
				SmartDashboard.putNumber("centerX2", centerX2);
				SmartDashboard.putNumber("center", (centerX2+centerX)/2);
				
//                contourImage = new Mat(320, 240, CvType.CV_32SC1);
				
			}
			
		});

		visionThread.start();
		
		contourSource.putFrame(contourImage);
		
		SmartDashboard.putString("Contour Server", contourServer.getListenAddress()+":"+contourServer.getPort());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		
		m_autonomousCommand = new AimAtTarget(ObjectSelect.CENTER);

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
                	 */
	@Override
	public void teleopPeriodic() {
		
		SmartDashboard.putNumber("LJoystick Y", m_oi.getLJoystick().getY());
		SmartDashboard.putNumber("RJoystick Y", m_oi.getRJoystick().getY());
		SmartDashboard.putNumber("center1", centerX);
		SmartDashboard.putNumber("center2", centerX2);
		
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
