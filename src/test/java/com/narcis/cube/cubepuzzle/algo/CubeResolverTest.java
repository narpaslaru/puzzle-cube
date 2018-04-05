package com.narcis.cube.cubepuzzle.algo;


import com.narcis.cube.cubepuzzle.CubePuzzleApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CubePuzzleApplication.class)
public class CubeResolverTest {
	private static int[] perfectCube = {1, 2, 2, 2, 2, 1, 1, 1, 2, 2, 1, 1, 2, 1, 2, 1, 1, 2};
	private static int[] perfectCubeReversed = {1, 2, 1 ,1 ,2, 1, 2, 1 ,1, 2 ,2, 1, 1 ,1, 2, 2, 2, 2};
	@Autowired
	private CubeResolver cubeResolver;

	@Test
	public void testBadCube() {
		assertEquals("The cube should not be null", cubeResolver.findSolution(null));
		assertEquals("The cube must not be empty", cubeResolver.findSolution(new int[]{}));
		assertEquals("The cube must start with 1", cubeResolver.findSolution(new int[]{2}));
		assertEquals("The cube must only have 1 and 2 as emelents", cubeResolver.findSolution(new int[]{1,2,3}));
		assertEquals("The cube must have 27 elements", cubeResolver.findSolution(new int[]{1,2,1,2}));
	}

	@Test
	public void testFindingSolution() {
		assertEquals("Fixing the cube...", cubeResolver.findSolution(perfectCube));
		assertEquals("Fixing the cube...", cubeResolver.findSolution(perfectCubeReversed));
	}

	@Test
	public void solvesPerfectCube() throws Exception {
        ByteArrayOutputStream out = redirectStandardOutput();

		cubeResolver.findSolution(perfectCube);

		assertThat(out.toString("UTF-8")).isEqualToIgnoringNewLines(
				"Solution: [Move [steps=1, direction=OX_PLUS]\n" +
				", Move [steps=2, direction=OX_PLUS]\n" +
				", Move [steps=2, direction=OY_PLUS]\n" +
				", Move [steps=2, direction=OX_MINUS]\n" +
				", Move [steps=2, direction=OZ_PLUS]\n" +
				", Move [steps=1, direction=OX_PLUS]\n" +
				", Move [steps=1, direction=OZ_MINUS]\n" +
				", Move [steps=1, direction=OX_PLUS]\n" +
				", Move [steps=2, direction=OY_MINUS]\n" +
				", Move [steps=2, direction=OX_MINUS]\n" +
				", Move [steps=1, direction=OZ_PLUS]\n" +
				", Move [steps=1, direction=OY_PLUS]\n" +
				", Move [steps=2, direction=OZ_MINUS]\n" +
				", Move [steps=1, direction=OX_PLUS]\n" +
				", Move [steps=2, direction=OZ_PLUS]\n" +
				", Move [steps=1, direction=OY_MINUS]\n" +
				", Move [steps=1, direction=OX_PLUS]\n" +
				", Move [steps=2, direction=OY_PLUS]\n" +
				"]\n");
	}

    private ByteArrayOutputStream redirectStandardOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(out);
        System.setOut(output);
        return out;
    }

    @Test
    public void solvesPerfectCubeReversed() throws Exception {
        ByteArrayOutputStream out = redirectStandardOutput();

        cubeResolver.findSolution(perfectCubeReversed);

        assertThat(out.toString("UTF-8")).isEqualToIgnoringNewLines(
                "Solution: [Move [steps=1, direction=OX_PLUS]\n" +
                        ", Move [steps=2, direction=OX_PLUS]\n" +
                        ", Move [steps=1, direction=OY_PLUS]\n" +
                        ", Move [steps=1, direction=OX_MINUS]\n" +
                        ", Move [steps=2, direction=OZ_PLUS]\n" +
                        ", Move [steps=1, direction=OY_PLUS]\n" +
                        ", Move [steps=2, direction=OZ_MINUS]\n" +
                        ", Move [steps=1, direction=OX_PLUS]\n" +
                        ", Move [steps=1, direction=OZ_PLUS]\n" +
                        ", Move [steps=2, direction=OY_MINUS]\n" +
                        ", Move [steps=2, direction=OX_MINUS]\n" +
                        ", Move [steps=1, direction=OY_PLUS]\n" +
                        ", Move [steps=1, direction=OZ_MINUS]\n" +
                        ", Move [steps=1, direction=OY_PLUS]\n" +
                        ", Move [steps=2, direction=OZ_PLUS]\n" +
                        ", Move [steps=2, direction=OY_MINUS]\n" +
                        ", Move [steps=2, direction=OX_PLUS]\n" +
                        ", Move [steps=2, direction=OY_PLUS]\n" +
                        "]\n");
    }

	@Test
	public void resolvesMultipleInputs() throws Exception {
		cubeResolver.findSolution(perfectCube);
		reinitPositions();
		cubeResolver.findSolution(perfectCubeReversed);
		reinitPositions();
		cubeResolver.findSolution(perfectCube);
	}

	private void reinitPositions() {
		for (int i = 0; i<3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					Position.POSITIONS[i][j][k] = null;
				}
			}
		}
	}

	@Before
	public void setUp() throws Exception {
		reinitPositions();
	}
}
