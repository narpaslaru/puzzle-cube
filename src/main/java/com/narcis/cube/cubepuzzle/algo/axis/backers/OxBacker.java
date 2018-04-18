package com.narcis.cube.cubepuzzle.algo.axis.backers;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.Position;
import org.springframework.stereotype.Component;

import java.util.function.IntFunction;
import java.util.function.IntPredicate;

public class OxBacker implements Backer {
    private final IntFunction<Integer> sign;
    private final Move.Direction from;

    public OxBacker(IntFunction<Integer> sign, Move.Direction from) {
        this.sign = sign;
        this.from = from;
    }

    @Override
    public Move.Direction towards() {
        return null;
    }

    @Override
    public Position goBack(int[][][] theCube, int numberOfElementsToAdd, Position currentPosition) {
        return null;
    }
}
