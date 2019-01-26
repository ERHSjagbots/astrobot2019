package org.usfirst.frc.team2929.robot.utility;

public enum PistonSelect {
	
	FORWARD(0),
	REVERSE(1),
	OFF(2);
	
	private final int value;
	
	PistonSelect(final int selector) {
		value = selector;
	}
	
	public int getValue() {
		return value;
	}
}
