package com.narcis.cube.cubepuzzle.algo.axis.advancers;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.Position;

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
        int currentY = currentPosition.getY();
        for (int i = 1; i <= numberOfElementsToAdd; i++) {
            theCube[currentPosition.getX()][sign.applyAsInt(currentY, 1)][currentPosition.getZ()] = 1;
            currentY = sign.applyAsInt(currentY, 1);
        }
        return getPosition(currentPosition.getX(), currentY, currentPosition.getZ());
    }
}
