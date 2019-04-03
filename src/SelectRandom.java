import java.util.HashSet;
import java.util.Set;

/**
 * 
 * A method to randomly generate a set of m integers from an array of n integers.
 * 
 * My first attempt at this problem had me reading the word 'set' quite literally. I have
 * since changed it to return an array of integers.
 * 
 * @author michaeljohnson
 *
 */
public class SelectRandom {

	public static int[] selectRandom(int[] array, int m) {
		array = array.clone(); // O(n) for defensive copy
		int[] results = new int[m];
		int remaining = array.length;
		for (int i = 0; i < m; i++) {
			int selectedIndex = (int) (Math.random() * remaining);
			results[i] = array[selectedIndex];
			array[selectedIndex] = array[remaining - 1];
			remaining--;
		}
		return results;
	}

	public static void printArray(int[] array) {
		for (int e: array) {
			System.out.print(e);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 0));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 1));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 2));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 3));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 4));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 0));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 1));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 2));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 3));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 4));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 0));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 1));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 2));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 3));
		printArray(selectRandom(new int[] { 1, 2, 3, 4 }, 4));
	}
}
