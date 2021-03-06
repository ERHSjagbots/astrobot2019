package org.usfirst.frc.team2929.robot;

import org.usfirst.frc.team2929.robot.commands.auto.AimAtTarget;
import org.usfirst.frc.team2929.robot.commands.auto.DriveToDistance;
import org.usfirst.frc.team2929.robot.utility.ObjectSelect;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public Joystick LJoystick;
	public Joystick RJoystick;
	
	public JoystickButton aimAtThing;
	public JoystickButton runAtThing;
	
	public OI() {
		
		LJoystick = new Joystick(0);
		RJoystick = new Joystick(1);
	
		aimAtThing = new JoystickButton(LJoystick, 1);
		aimAtThing.whenPressed(new AimAtTarget(ObjectSelect.CENTER));
		
		runAtThing = new JoystickButton(RJoystick, 1);
		runAtThing.whenPressed(new DriveToDistance(48));
		
		
	}
	
	public Joystick getLJoystick() {
		return LJoystick;
	}
	
	public Joystick getRJoystick() {
		return RJoystick;
	}
	
}
