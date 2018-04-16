package com.narcis.cube.cubepuzzle.algo;

import java.util.List;
import java.util.Stack;

import com.narcis.cube.cubepuzzle.algo.Move.Direction;
import com.narcis.cube.cubepuzzle.algo.axis.advancers.Advancer;
import com.narcis.cube.cubepuzzle.algo.axis.backers.Backer;
import com.narcis.cube.cubepuzzle.algo.validators.CubeInvalidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author npaslaru
 *
 */
@Component
public class CubeResolver {

	private final List<CubeInvalidator> invalidators;

	private final List<Advancer> advancers;

	private final List<Backer> backers;

	@Autowired
	public CubeResolver(List<CubeInvalidator> invalidators, List<Advancer> advancers, List<Backer> backers) {
		this.invalidators = invalidators;
		this.advancers = advancers;
		this.backers = backers;
	}

	public String findSolution(int[] cube) {
		String error = validateCube(cube);
		if ("OK".equals(error)) {
			//proceed to fix the cube
			Stack<Move> solution = new Stack<>();
			int[][][] theCube = new int[3][3][3];
			// first step - start with cube[0] = 1 and put it into theCube[0,0,0]
			theCube[0][0][0] = cube[0];
			new Position(0, 0, 0).getAlreadyCheckedDirections().add(Direction.OX_PLUS);
			solution.push(new Move(cube[0], Direction.OX_PLUS));
			solution.push(new Move(cube[1], Direction.OX_PLUS));
			//make this move
			theCube[1][0][0] = 1;
			theCube[2][0][0] = 1;
			int currentIndexInCubeArray = 2;
			Position currentPosition = new Position(2, 0, 0);
			//
			while (!isFinalSolution(currentIndexInCubeArray, cube)) {
				int numberOfElementsToAdd = cube[currentIndexInCubeArray];
				for (Direction dirToGo : Direction.values()) {
					if (!currentPosition.getAlreadyCheckedDirections().contains(dirToGo)) {
						currentPosition.getAlreadyCheckedDirections().add(dirToGo);
						if (areFreeElements(theCube, currentPosition, dirToGo, numberOfElementsToAdd)) {
							currentPosition = advance(theCube, currentPosition, dirToGo, numberOfElementsToAdd, solution);
							currentIndexInCubeArray ++;
							break;
						}
					}
				}
				// after all directions have been tried without luck, go back
				if (currentPosition.getAlreadyCheckedDirections().size() == 6) {
					currentPosition = goBack(theCube, currentPosition, solution);
					currentIndexInCubeArray --;
				}
			}
			
			if (isFinalSolution(currentIndexInCubeArray, cube)) {
				printSolution(solution);
			}
			
			return "Fixing the cube...";
			
		} else {
			return error;
		}
	}

	// moves in the cube in one direction
	private Position advance(int[][][] theCube, Position currentPosition, Direction dirToGo, int numberOfElementsToAdd, Stack<Move> solution) {
		solution.push(new Move(numberOfElementsToAdd, dirToGo));
		return advancers.stream().filter(advancer -> advancer.towards().equals(dirToGo))
                .findFirst().map(advancer -> advancer.advance(theCube, numberOfElementsToAdd, currentPosition))
                .orElseGet(() -> getPosition(currentPosition.getX(), currentPosition.getY(), currentPosition.getZ()));

	}

	private Position goBack(int[][][] theCube, Position currentPosition, Stack<Move> solution) {
		Move previousMove = solution.pop();
		Direction dirToGoBack = previousMove.getDirection();
		int stepsToGoBackTo = previousMove.getSteps();
		int currentX = currentPosition.getX();
		int currentY = currentPosition.getY();
		int currentZ = currentPosition.getZ();
		int newX = currentX;
		int newY = currentY;
		int newZ = currentZ;

		theCube[currentX][currentY][currentZ] = 0;
		new Position(currentX, currentY, currentZ);

		switch (dirToGoBack) {
			case OX_PLUS:
				newX -= 1;
				if (stepsToGoBackTo == 2) {
					theCube[currentX - 1][currentY][currentZ] = 0;
					new Position(currentX - 1, currentY, currentZ);
					newX -= 1;
				}
				break;

			case OX_MINUS:
				newX += 1;
				if (stepsToGoBackTo == 2) {
					theCube[currentX + 1][currentY][currentZ] = 0;
					new Position(currentX + 1, currentY, currentZ);
					newX += 1;
				}
				break;

			case OY_PLUS:
				newY -= 1;
				if (stepsToGoBackTo == 2) {
					theCube[currentX][currentY - 1][currentZ] = 0;
					new Position(currentX, currentY-1, currentZ);
					newY -= 1;
				}
				break;

			case OY_MINUS:
				newY += 1;
				if (stepsToGoBackTo == 2) {
					theCube[currentX][currentY + 1][currentZ] = 0;
					new Position(currentX, currentY + 1, currentZ);
					newY += 1;
				}
				break;

			case OZ_PLUS:
				newZ -= 1;
				if (stepsToGoBackTo == 2) {
					theCube[currentX][currentY][currentZ - 1] = 0;
					new Position(currentX, currentY, currentZ - 1);
					newZ -= 1;
				}
				break;

			case OZ_MINUS:
				newZ += 1;
				if (stepsToGoBackTo == 2) {
					theCube[currentX][currentY][currentZ + 1] = 0;
					new Position(currentX, currentY, currentZ + 1);
					newZ += 1;
				}
				break;

			default:
				break;
		}
		return getPosition(newX, newY, newZ);
	}

	private Position getPosition(int newX, int newY, int newZ) {
		return Position.POSITIONS[newX][newY][newZ] != null ? Position.POSITIONS[newX][newY][newZ] : new Position(newX, newY, newZ);
	}

	// checks if there are free elements
	private boolean areFreeElements(int[][][] theCube, Position currentPosition, Direction dirToGo,  int numberOfElementsToAdd) {
		int currentX = currentPosition.getX();
		int currentY = currentPosition.getY();
		int currentZ = currentPosition.getZ();
		boolean result;
		switch (dirToGo) {
		case OX_PLUS:
			if (currentX + numberOfElementsToAdd <= 2) {
				// check the next cube element
				if (theCube[currentX + 1][currentY][currentZ] == 1) {
					// it is occupied
					result = false;
				} else if (numberOfElementsToAdd == 2){
					if (theCube[currentX+2][currentY][currentZ] == 1) {
						// this one is occupied
						result = false;
					} else {
						result = true;
					}
				} else {
					result = true;
				}
			} else {
				result = false;
			}
			break;
		case OX_MINUS:
			if (currentX - numberOfElementsToAdd >= 0) {
				// check the next cube element
				if (theCube[currentX - 1][currentY][currentZ] == 1) {
					// it is occupied
					result = false;
				} else if (numberOfElementsToAdd == 2){
					if (theCube[currentX - 2][currentY][currentZ] == 1) {
						// this one is occupied
						result = false;
					} else {
						result = true;
					}
				} else {
					result = true;
				}
			} else {
				result = false;
			}			
			break;
		case OY_PLUS:
			if (currentY + numberOfElementsToAdd <= 2) {
				// check the next cube element
				if (theCube[currentX][currentY + 1][currentZ] == 1) {
					// it is occupied
					result = false;
				} else if (numberOfElementsToAdd == 2){
					if (theCube[currentX][currentY + 2][currentZ] == 1) {
						// this one is occupied
						result = false;
					} else {
						result = true;
					}
				} else {
					result = true;
				}
			} else {
				result = false;
			}
			break;
		case OY_MINUS:
			if (currentY - numberOfElementsToAdd >= 0) {
				// check the next cube element
				if (theCube[currentX][currentY - 1][currentZ] == 1) {
					// it is occupied
					result = false;
				} else if (numberOfElementsToAdd == 2){
					if (theCube[currentX][currentY - 2][currentZ] == 1) {
						// this one is occupied
						result = false;
					} else {
						result = true;
					}
				} else {
					result = true;
				}
			} else {
				result = false;
			}			
			break;
		case OZ_PLUS:
			if (currentZ + numberOfElementsToAdd <= 2) {
				// check the next cube element
				if (theCube[currentX][currentY][currentZ + 1] == 1) {
					// it is occupied
					result = false;
				} else if (numberOfElementsToAdd == 2){
					if (theCube[currentX][currentY][currentZ + 2] == 1) {
						// this one is occupied
						result = false;
					} else {
						result = true;
					}
				} else {
					result = true;
				}
			} else {
				result = false;
			}
			break;
		case OZ_MINUS:
			if (currentZ - numberOfElementsToAdd >= 0) {
				// check the next cube element
				if (theCube[currentX][currentY][currentZ - 1] == 1) {
					// it is occupied
					result = false;
				} else if (numberOfElementsToAdd == 2){
					if (theCube[currentX][currentY][currentZ - 2] == 1) {
						// this one is occupied
						result = false;
					} else {
						result = true;
					}
				} else {
					result = true;
				}
			} else {
				result = false;
			}
			break;

		default:
			result = true;
			break;
		}
		return result;
	}

	private boolean isFinalSolution(int currentIndexInCubeArray, int[] cube) {
		// the final solution is when we reached the end
		return currentIndexInCubeArray == cube.length;
	}
	
	private void printSolution(Stack<Move> solution) {
		System.out.println("Solution: "+solution);
	}
	
	private String validateCube(int[] cube) {
		return invalidators.stream().filter(cubeInvalidator ->
				cubeInvalidator.invalid(cube))
				.map(CubeInvalidator::invalidMessage)
				.findFirst()
				.orElse("OK");
	}
}
