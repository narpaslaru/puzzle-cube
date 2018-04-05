package com.narcis.cube.cubepuzzle.algo;

import java.util.function.IntBinaryOperator;

public class OzAdvancer implements Advancer {
    private final IntBinaryOperator sign;
    private final Move.Direction towards;

    public OzAdvancer(IntBinaryOperator sign, Move.Direction towards) {
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
        int newZ = currentZ;
        theCube[currentX][currentY][sign.applyAsInt(currentZ, 1)] = 1;
        newZ = sign.applyAsInt(newZ, 1);
        if (numberOfElementsToAdd == 2) {
            theCube[currentX][currentY][sign.applyAsInt(currentZ, 2)] = 1;
            newZ = sign.applyAsInt(newZ, 1);
        }
        return getPosition(currentX, currentY, newZ);
    }
}
