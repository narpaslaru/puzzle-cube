package com.narcis.cube.cubepuzzle.algo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OyConfiguration {
    @Bean
    Advancer oyPlusAdvancer() {
        return new OyAdvancer(Integer::sum, Move.Direction.OY_PLUS);
    }

    @Bean
    Advancer oyMinusAdvancer() {
        return new OyAdvancer((x, y) -> x - y, Move.Direction.OY_MINUS);
    }
}
