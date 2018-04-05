package com.narcis.cube.cubepuzzle.algo;

import org.springframework.stereotype.Component;

@Component
public class OzPlusAdvancer implements Advancer {
    @Override
    public Move.Direction towards() {
        return Move.Direction.OZ_PLUS;
    }

    @Override
    public Position advance(int[][][] theCube, int numberOfElementsToAdd, Position currentPosition) {
        int currentX = currentPosition.getX();
        int currentY = currentPosition.getY();
        int currentZ = currentPosition.getZ();
        int newZ = currentZ;
        theCube[currentX][currentY][currentZ + 1] = 1;
        newZ += 1;
        if (numberOfElementsToAdd == 2) {
            theCube[currentX][currentY][currentZ + 2] = 1;
            newZ += 1;
        }
        return getPosition(currentX, currentY, newZ);
    }
}
