package com.narcis.cube.cubepuzzle;

import com.narcis.cube.cubepuzzle.algo.CubeResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CubePuzzleApplication {

	public static void main(String[] args) {

        ApplicationContext appContext = SpringApplication.run(CubePuzzleApplication.class, args);
        CubeResolver cubeResolver = appContext.getBean(CubeResolver.class);

        int[] perfectCube = {1, 2, 2, 2, 2, 1, 1, 1, 2, 2, 1, 1, 2, 1, 2, 1, 1, 2};
        cubeResolver.findSolution(perfectCube);
	}
}
