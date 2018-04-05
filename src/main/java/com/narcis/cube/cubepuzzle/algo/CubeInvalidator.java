package com.narcis.cube.cubepuzzle.algo;

public interface CubeInvalidator {
    boolean invalid(int[] cube);
    String invalidMessage();
}
