/**
 * 
 */
package com.narcis.cube.cubepuzzle.algo;

import java.util.ArrayList;
import java.util.List;

import com.narcis.cube.cubepuzzle.algo.Move.Direction;

/**
 * @author npaslaru
 *
 */
public class Position {
	public static final Position[][][] POSITIONS = new Position[3][3][3];
	
	
	private int x, y, z;
	private List<Direction> alreadyCheckedDirections = new ArrayList<Direction>();

	public Position(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		POSITIONS[x][y][z] = this;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
	
	public List<Direction> getAlreadyCheckedDirections() {
		return alreadyCheckedDirections;
	}
}
