package com.narcis.cube.cubepuzzle.algo;

public interface Advancer {
    Move.Direction towards();
    int advance(int[][][] theCube, int numberOfElementsToAdd, Position currentPosition);
}
