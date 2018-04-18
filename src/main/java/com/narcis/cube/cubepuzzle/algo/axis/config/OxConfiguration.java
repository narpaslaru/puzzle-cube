package com.narcis.cube.cubepuzzle.algo.axis.config;

import com.narcis.cube.cubepuzzle.algo.Move;
import com.narcis.cube.cubepuzzle.algo.axis.advancers.Advancer;
import com.narcis.cube.cubepuzzle.algo.axis.advancers.OxAdvancer;
import com.narcis.cube.cubepuzzle.algo.axis.backers.Backer;
import com.narcis.cube.cubepuzzle.algo.axis.backers.OxBacker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OxConfiguration {
    @Bean
    Advancer oxPlusAdvancer() {
        return new OxAdvancer((x) -> ++x, Move.Direction.OX_PLUS);
    }

    @Bean
    Advancer oxMinusAdvancer() {
        return new OxAdvancer((x) -> --x, Move.Direction.OX_MINUS);
    }

    @Bean
    Backer oxPlusBacker() { return new OxBacker((x) -> ++x, Move.Direction.OX_PLUS); }
}
