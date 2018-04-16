package com.narcis.cube.cubepuzzle.algo.axis.advancers;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.Position;

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
        int currentZ = currentPosition.getZ();
        for (int i = 1; i <= numberOfElementsToAdd; i++) {
            theCube[currentPosition.getX()][currentPosition.getY()][sign.applyAsInt(currentZ, 1)] = 1;
            currentZ = sign.applyAsInt(currentZ, 1);
        }

        return getPosition(currentPosition.getX(), currentPosition.getY(), currentZ);
    }
}
