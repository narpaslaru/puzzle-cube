package com.narcis.cube.cubepuzzle.algo.validators;

import org.springframework.stereotype.Component;

@Component
public class MustStartWithOne implements CubeInvalidator {
    @Override
    public boolean invalid(int[] cube) {
        return cube[0] != 1;
    }

    @Override
    public String invalidMessage() {
        return "The cube must start with 1";
    }
}
