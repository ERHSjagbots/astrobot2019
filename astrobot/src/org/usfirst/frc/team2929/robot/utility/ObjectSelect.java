package org.usfirst.frc.team2929.robot.utility;

public enum ObjectSelect {
	
	SMALL(0),
	CENTER(1),
	LARGE(2);
	
	private final int value;
	
	ObjectSelect(final int selector) {
		value = selector;
	}
	
	public int getValue() {
		return value;
	}
}
