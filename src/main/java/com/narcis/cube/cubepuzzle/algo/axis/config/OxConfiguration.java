package com.narcis.cube.cubepuzzle.algo.axis.config;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.axis.advancers.Advancer;
import com.narcis.cube.cubepuzzle.algo.axis.advancers.OxAdvancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OxConfiguration {
    @Bean
    Advancer oxPlusAdvancer() {
        return new OxAdvancer(Integer::sum, Move.Direction.OX_PLUS);
    }

    @Bean
    Advancer oxMinusAdvancer() {
        return new OxAdvancer((x, y) -> x - y, Move.Direction.OX_MINUS);
    }
}
