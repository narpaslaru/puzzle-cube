package com.narcis.cube.cubepuzzle.algo.axis.backers;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.Position;
import org.springframework.stereotype.Component;

@Component
public class OxBacker implements Backer {

    @Override
    public Move.Direction towards() {
        return null;
    }

    @Override
    public Position goBack(int[][][] theCube, int numberOfElementsToAdd, Position currentPosition) {
        return null;
    }
}
