package com.narcis.cube.cubepuzzle.algo;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class MustNotBeNull implements CubeInvalidator {
    @Override
    public boolean invalid(int[] cube) {
        return cube == null;
    }

    @Override
    public String invalidMessage() {
        return "The cube should not be null";
    }
}
