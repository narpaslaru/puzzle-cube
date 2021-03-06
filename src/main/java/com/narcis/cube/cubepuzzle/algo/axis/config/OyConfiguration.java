package com.narcis.cube.cubepuzzle.algo.axis.config;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.axis.advancers.Advancer;
import com.narcis.cube.cubepuzzle.algo.axis.advancers.OyAdvancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OyConfiguration {
    @Bean
    Advancer oyPlusAdvancer() {
        return new OyAdvancer((x) -> ++x, Move.Direction.OY_PLUS);
    }

    @Bean
    Advancer oyMinusAdvancer() {
        return new OyAdvancer((x) -> --x, Move.Direction.OY_MINUS);
    }
}
