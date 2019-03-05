package bomberman;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

/**
 * A video game screen is implemented as a 2D array (matrix) of Characters. Each
 * element represents a Wall 'W', Badguy 'B', or empty space ' '. A bomb placed
 * in an empty space will create an explosion will blow up any Badguys in the
 * same column or row, unless they are behind a wall. A bomb planted on a Wall
 * or Badguy will fizzle or be defused, blowing up nobody.
 * 
 * Where can we place a bomb that will blow up the most Badguys?
 * 
 * @author michaeljohnson
 *
 */
public class Bomberman {

	/**
	 * 
	 * This problem can be performed in O(N) where N is the number of elements in
	 * the matrix.
	 * 
	 * Start by observing that, in a given row or column, putting a bomb between two
	 * walls will always get all of the Badguys between those two walls.
	 * 
	 * One way to track and exploit this is to make a lookup array for every row:
	 * One that has a count of the number of Badguys affected by a bomb dropped in
	 * every spot. You need another row of lookups for every row of the matrix, so
	 * this is essentially just another matrix "painted" with a count of Badguys
	 * affected by bombs placed at every location. Create a similar matrix for
	 * columns and add the row and col counts together at any location to derive the
	 * number of Badguys affected by bomb placement.
	 * 
	 * I found the implementation a bit difficult. An augmented matrix might have made for easier
	 * code.
	 * 
	 * @param m
	 * @return
	 */
	public static int[][] badguysCount(char[][] m) {
		if (m.length < 1)
			return new int[][] {};
		if (m[0].length < 1)
			return new int[][] {};

		int rows = m.length;
		int cols = m[0].length;

		int[][] r = new int[rows][cols];
		int[][] c = new int[rows][cols];
		int[][] a = new int[rows][cols];

		int rs = 0;
		int rbg = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] == 'B')
					rbg++;
				if (m[i][j] == 'W') {
					for (int x = rs; x < i; x++) {
						r[i][x] = rbg;
					}
					rbg = 0;
					rs = i + 1;
				}
			}
			// edge
			for (int x = rs; x < m[0].length; x++) {
				r[i][x] = rbg;
			}
			rbg = 0;
			rs = 0;
		}

		int cs = 0;
		int cbg = 0;
		for (int j = 0; j < m[0].length; j++) {
			for (int i = 0; i < m.length; i++) {
				if (m[i][j] == 'B')
					cbg++;
				if (m[i][j] == 'W') {
					for (int x = cs; x < i; x++) {
						c[x][j] = cbg;
					}
					cbg = 0;
					cs = j + 1;
				}
			}
			// edge
			for (int x = cs; x < m.length; x++) {
				c[x][j] = cbg;
			}
			cbg = 0;
			cs = 0;
		}

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				a[i][j] = r[i][j] + c[i][j];
				if (m[i][j] == 'B') a[i][j] -= 1; // double-counting Bombs
			}
		}

		return a;
	}

	void prettyPrint(int[][] m) {
		for (int[] r : m) {
			for (int e : r) {
				System.out.printf("%3d ", e);
			}
			System.out.println();
		}
	}
	
	void assert2DArrayEquals(int[][] a, int[][] b) {
		for (int i = 0; i < a.length; i++)
			assertArrayEquals(a[i], b[i]);
	}

	@AfterEach
	void newline() {
		System.out.println();
	}
	
	@Test
	void testSmallGameOne() {
		char[][] game = new char[][] { { ' ' } };
		int[][] desired = new int[][] { { 0 } };

		int[][] result = badguysCount(game);

		prettyPrint(result);
		
		assert2DArrayEquals(desired, result);
	}
	
	@Test
	void testSmallGameTwo() {
		char[][] game = new char[][] { { 'W' } };
		int[][] desired = new int[][] { { 0 } };

		int[][] result = badguysCount(game);

		prettyPrint(result);
		
		assert2DArrayEquals(desired, result);
	}
	
	@Test
	void testSmallGameThree() {
		char[][] game = new char[][] { { 'B' } };
		int[][] desired = new int[][] { { 1 } };

		int[][] result = badguysCount(game);

		prettyPrint(result);
		
		assert2DArrayEquals(desired, result);
	}
	
	@Test
	void testMediumGame() {
		char[][] game = new char[][] { 
			{ 'B', 'B', ' ' }, 
			{ 'B', 'W', ' ' }, 
			{ 'B', ' ', 'B' } 
		};
		int[][] desired = new int[][] { 
			{ 4, 2, 3 },
			{ 3, 0, 1 },
			{ 4, 2, 2 }
		};

		int[][] result = badguysCount(game);

		prettyPrint(result);
		
		assert2DArrayEquals(desired, result);
	}
}
