package org.usfirst.frc.team2929.robot.utility;

/**
 * Enumerator for selecting the object during some vision commands.
 * 
 * @author Matthew Brosnon
 */
public enum Direction {
	
	//values
	LEFT(0),
	RIGHT(1);
	
	private final int value;
	
	/**
	 * Enum constructor.
	 * 
	 * @param selector 
	 */
	Direction(final int selector) {
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
