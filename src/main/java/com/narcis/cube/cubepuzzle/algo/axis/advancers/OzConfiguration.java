package com.narcis.cube.cubepuzzle.algo.axis.advancers;

import com.narcis.cube.cubepuzzle.algo.Move;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OzConfiguration {
    @Bean
    Advancer ozPlusAdvancer() {
        return new OzAdvancer(Integer::sum, Move.Direction.OZ_PLUS);
    }

    @Bean
    Advancer ozMinusAdvancer() {
        return new OzAdvancer((x, y) -> x - y, Move.Direction.OZ_MINUS);
    }
}
