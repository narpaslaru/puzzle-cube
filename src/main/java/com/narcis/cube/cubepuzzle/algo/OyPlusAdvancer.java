package com.narcis.cube.cubepuzzle.algo;

import org.springframework.stereotype.Component;

@Component
public class OyPlusAdvancer implements Advancer {
    @Override
    public Move.Direction towards() {
        return Move.Direction.OY_PLUS;
    }

    @Override
    public Position advance(int[][][] theCube, int numberOfElementsToAdd, Position currentPosition) {
        int currentX = currentPosition.getX();
        int currentY = currentPosition.getY();
        int currentZ = currentPosition.getZ();
        int newY = currentY;
        theCube[currentX][currentY + 1][currentZ] = 1;
        newY += 1;
        if (numberOfElementsToAdd == 2) {
            theCube[currentX][currentY + 2][currentZ] = 1;
            newY += 1;
        }
        return getPosition(currentX, newY, currentZ);
    }
}
