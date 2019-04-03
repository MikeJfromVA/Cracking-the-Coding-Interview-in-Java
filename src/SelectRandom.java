import java.util.HashSet;
import java.util.Set;

public class SelectRandom {

	public static Set<Integer> selectRandom(int[] array, int m) {
		int remaining = array.length;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < m; i++) { // O(m)
			int selectedIndex = (int) (Math.random() * remaining);
			set.add(array[selectedIndex]);
			array[selectedIndex] = array[remaining - 1];
			remaining--;
		}
		return set;
	}

	public static void main(String[] args) {
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 0));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 1));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 2));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 3));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 4));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 0));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 1));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 2));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 3));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 4));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 0));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 1));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 2));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 3));
		System.out.println(selectRandom(new int[] { 1, 2, 3, 4 }, 4));
	}
}
