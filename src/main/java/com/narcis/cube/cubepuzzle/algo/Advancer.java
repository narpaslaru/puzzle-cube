package com.narcis.cube.cubepuzzle.algo;

public interface Advancer {
    Move.Direction towards();
    Position advance(int[][][] theCube, int numberOfElementsToAdd, Position currentPosition);
    default Position getPosition(int newX, int newY, int newZ) {
        return Position.POSITIONS[newX][newY][newZ] != null ? Position.POSITIONS[newX][newY][newZ] : new Position(newX, newY, newZ);
    }
}
