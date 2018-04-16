package com.narcis.cube.cubepuzzle.algo.axis.advancers;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.Position;

public interface Advancer {
    Move.Direction towards();
    Position advance(int[][][] theCube, int numberOfElementsToAdd, Position currentPosition);
    default Position getPosition(int newX, int newY, int newZ) {
        return Position.POSITIONS[newX][newY][newZ] != null ? Position.POSITIONS[newX][newY][newZ] : new Position(newX, newY, newZ);
    }
}
