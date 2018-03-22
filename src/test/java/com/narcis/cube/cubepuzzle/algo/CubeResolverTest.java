package com.narcis.cube.cubepuzzle.algo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CubeResolverTest {
	private static int[] perfectCube = {1, 2, 2, 2, 2, 1, 1, 1, 2, 2, 1, 1, 2, 1, 2, 1, 1, 2};
	private static int[] perfectCubeReversed = {1, 2, 1 ,1 ,2, 1, 2, 1 ,1, 2 ,2, 1, 1 ,1, 2, 2, 2, 2};
	private static CubeResolver cubeResolver = new CubeResolver();

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

}
