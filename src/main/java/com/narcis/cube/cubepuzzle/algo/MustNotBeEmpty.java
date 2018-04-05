package com.narcis.cube.cubepuzzle.algo;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MustNotBeEmpty implements CubeInvalidator {
    @Override
    public boolean invalid(int[] cube) {
        return cube.length == 0;
    }

    @Override
    public String invalidMessage() {
        return "The cube must not be empty";
    }
}
