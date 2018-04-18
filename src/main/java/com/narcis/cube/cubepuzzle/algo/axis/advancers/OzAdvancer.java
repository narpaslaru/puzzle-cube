package com.narcis.cube.cubepuzzle.algo.axis.advancers;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.Position;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;

public class OzAdvancer implements Advancer {
    private final IntFunction<Integer> sign;
    private final Move.Direction towards;

    public OzAdvancer(IntFunction<Integer> sign, Move.Direction towards) {
        this.sign = sign;
        this.towards = towards;
    }

    @Override
    public Move.Direction towards() {
        return towards;
    }

    @Override
    public Position advance(int[][][] theCube, int numberOfElementsToAdd, Position currentPosition) {
        int currentZ = currentPosition.getZ();
        for (int i = 1; i <= numberOfElementsToAdd; i++) {
            theCube[currentPosition.getX()][currentPosition.getY()][sign.apply(currentZ)] = 1;
            currentZ = sign.apply(currentZ);
        }

        return getPosition(currentPosition.getX(), currentPosition.getY(), currentZ);
    }
}
