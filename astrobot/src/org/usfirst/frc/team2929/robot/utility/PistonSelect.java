package org.usfirst.frc.team2929.robot.utility;

/**
 * Enumerator for selection of the direction of pistons.
 * 
 * @author Matthew Brosnon
 */
public enum PistonSelect {
	
	//values
	FORWARD(0),
	REVERSE(1),
	OFF(2);
	
	private final int value;
	
	/**
	 * Enum constructor.
	 * 
	 * @param selector 
	 */
	PistonSelect(final int selector) {
		//sets value
		value = selector;
	}
	
	/**
	 * Returns enum value.
	 * 
	 * @return value enum value
	 */
	public int getValue() {
		//returns value
		return value;
	}
}
