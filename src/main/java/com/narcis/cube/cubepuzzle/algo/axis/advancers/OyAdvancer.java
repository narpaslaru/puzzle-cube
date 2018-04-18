package com.narcis.cube.cubepuzzle.algo.axis.advancers;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.Position;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;

public class OyAdvancer implements Advancer {
    private final IntFunction<Integer> sign;
    private final Move.Direction towards;

    public OyAdvancer(IntFunction<Integer> sign, Move.Direction towards) {
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
            theCube[currentPosition.getX()][sign.apply(currentY)][currentPosition.getZ()] = 1;
            currentY = sign.apply(currentY);
        }
        return getPosition(currentPosition.getX(), currentY, currentPosition.getZ());
    }
}
