package com.narcis.cube.cubepuzzle.algo.axis.advancers;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.Position;

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
        int newX = currentX;
        theCube[sign.applyAsInt(currentX, 1)][currentPosition.getY()][currentPosition.getZ()] = 1;
        newX = sign.applyAsInt(newX, 1);
        if (numberOfElementsToAdd == 2) {
            theCube[sign.applyAsInt(currentX, 2)][currentPosition.getY()][currentPosition.getZ()] = 1;
            newX = sign.applyAsInt(newX, 1);
        }
        return getPosition(newX, currentPosition.getY(), currentPosition.getZ());
    }
}
