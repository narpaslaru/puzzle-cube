package com.narcis.cube.cubepuzzle.algo.validators;

import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class SumMustBe3x3x3 implements CubeInvalidator {
    @Override
    public boolean invalid(int[] cube) {
        return Arrays.stream(cube).sum() != 27;
    }

    @Override
    public String invalidMessage() {
        return "The cube must have 27 elements";
    }
}
