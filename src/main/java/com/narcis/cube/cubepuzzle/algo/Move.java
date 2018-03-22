/**
 * 
 */
package com.narcis.cube.cubepuzzle.algo;

/**
 * @author npaslaru
 *
 */
public class Move {
	public enum Direction {
		OX_PLUS, OX_MINUS, OY_PLUS, OY_MINUS, OZ_PLUS, OZ_MINUS;
	}
	
	private int steps; // 1 or 2 - coming from cube
	private Direction direction;
	
	public Move(int steps, Direction direction) {
		super();
		this.setSteps(steps);
		this.setDirection(direction);
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return "Move [steps=" + steps + ", direction=" + direction + "]\n";
	}
}
