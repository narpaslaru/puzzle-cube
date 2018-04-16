package com.narcis.cube.cubepuzzle.algo.validators;

import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class OnlyAcceptOneAndTwo implements CubeInvalidator {
    @Override
    public boolean invalid(int[] cube) {
        return Arrays.stream(cube).filter(i -> i == 1 || i == 2).count() != cube.length;
    }

    @Override
    public String invalidMessage() {
        return "The cube must only have 1 and 2 as emelents";
    }
}
