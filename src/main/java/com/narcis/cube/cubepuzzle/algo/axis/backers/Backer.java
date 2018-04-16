package com.narcis.cube.cubepuzzle.algo.axis.backers;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.Position;

public interface Backer {
    Move.Direction towards();
    Position goBack(int[][][] theCube, int numberOfElementsToAdd, Position currentPosition);

}
