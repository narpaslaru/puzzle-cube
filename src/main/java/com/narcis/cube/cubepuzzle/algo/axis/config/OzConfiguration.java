package com.narcis.cube.cubepuzzle.algo.axis.config;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.axis.advancers.Advancer;
import com.narcis.cube.cubepuzzle.algo.axis.advancers.OzAdvancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OzConfiguration {
    @Bean
    Advancer ozPlusAdvancer() {
        return new OzAdvancer((x) -> ++x, Move.Direction.OZ_PLUS);
    }

    @Bean
    Advancer ozMinusAdvancer() {
        return new OzAdvancer((x) -> --x, Move.Direction.OZ_MINUS);
    }
}
