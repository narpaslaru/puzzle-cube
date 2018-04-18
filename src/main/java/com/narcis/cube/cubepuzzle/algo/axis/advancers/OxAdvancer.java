package com.narcis.cube.cubepuzzle.algo.axis.advancers;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.Position;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;

public class OxAdvancer implements Advancer {
    private final IntFunction<Integer> sign;
    private final Move.Direction towards;

    public OxAdvancer(IntFunction<Integer> sign, Move.Direction towards) {
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
        for (int i = 1; i <= numberOfElementsToAdd; i++) {
            theCube[sign.apply(currentX)][currentPosition.getY()][currentPosition.getZ()] = 1;
            currentX = sign.apply(currentX);
        }
        return getPosition(currentX, currentPosition.getY(), currentPosition.getZ());
    }
}
