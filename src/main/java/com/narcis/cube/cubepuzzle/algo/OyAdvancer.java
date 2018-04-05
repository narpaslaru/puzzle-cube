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
        for (int i = 1; i <= numberOfElementsToAdd; i++) {
            theCube[currentX][sign.applyAsInt(currentY, 1)][currentZ] = 1;
            currentY = sign.applyAsInt(currentY, 1);
        }
        return getPosition(currentX, currentY, currentZ);
    }
}
