package com.narcis.cube.cubepuzzle.algo;

import java.util.function.IntBinaryOperator;

public class OyAdvancer implements Advancer {
    private final IntBinaryOperator sign;
    private final Move.Direction towards;

    public OyAdvancer(IntBinaryOperator sign, Move.Direction towards) {
        this.sign = sign;
        this.towards = towards;
    }

    @Override
    public Move.Direction towards() {
        return towards;
    }

    @Override
    public Position advance(int[][][] theCube, int numberOfElementsToAdd, Position currentPosition) {
        int currentX = currentPosition.getX();
        int currentY = currentPosition.getY();
        int currentZ = currentPosition.getZ();
        int newY = currentY;
        theCube[currentX][sign.applyAsInt(currentY, 1)][currentZ] = 1;
        newY = sign.applyAsInt(newY, 1);
        if (numberOfElementsToAdd == 2) {
            theCube[currentX][sign.applyAsInt(currentY, 2)][currentZ] = 1;
            newY = sign.applyAsInt(newY, 1);
        }
        return getPosition(currentX, newY, currentZ);
    }
}
