package com.narcis.cube.cubepuzzle.algo;

import java.util.function.IntBinaryOperator;

public class OxAdvancer implements Advancer {
    private final IntBinaryOperator sign;
    private final Move.Direction towards;

    public OxAdvancer(IntBinaryOperator sign, Move.Direction towards) {
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
        int newX = currentX;
        theCube[sign.applyAsInt(currentX, 1)][currentY][currentZ] = 1;
        newX = sign.applyAsInt(newX, 1);
        if (numberOfElementsToAdd == 2) {
            theCube[sign.applyAsInt(currentX, 2)][currentY][currentZ] = 1;
            newX = sign.applyAsInt(newX, 1);
        }
        return getPosition(newX, currentY, currentZ);
    }
}