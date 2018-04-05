package com.narcis.cube.cubepuzzle.algo;

import org.springframework.stereotype.Component;

@Component
public class OxPlusAdvancer implements Advancer {
    @Override
    public Move.Direction towards() {
        return Move.Direction.OX_PLUS;
    }

    @Override
    public int advance(int[][][] theCube, int numberOfElementsToAdd, Position currentPosition) {
        int currentX = currentPosition.getX();
        int currentY = currentPosition.getY();
        int currentZ = currentPosition.getZ();
        int newX = currentX;
        theCube[currentX + 1][currentY][currentZ] = 1;
        newX += 1;
        if (numberOfElementsToAdd == 2) {
            theCube[currentX + 2][currentY][currentZ] = 1;
            newX += 1;
        }
        return newX;
    }
}
