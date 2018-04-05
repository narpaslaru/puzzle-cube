package com.narcis.cube.cubepuzzle.algo;

import org.springframework.stereotype.Component;

@Component
public class OxMinusAdvancer extends OxAdvancer {

    public OxMinusAdvancer() {
        super((x, y) -> x - y, Move.Direction.OX_MINUS);
    }
}
