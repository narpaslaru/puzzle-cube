package com.narcis.cube.cubepuzzle.algo;

import org.springframework.stereotype.Component;

@Component
public class OxPlusAdvancer extends OxAdvancer {
    public OxPlusAdvancer() {
        super(Integer::sum, Move.Direction.OX_PLUS);
    }
}
