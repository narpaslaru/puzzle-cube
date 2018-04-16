package com.narcis.cube.cubepuzzle.algo.validators;

public interface CubeInvalidator {
    boolean invalid(int[] cube);
    String invalidMessage();
}
