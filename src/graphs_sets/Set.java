package graphs_sets;

import java.util.Arrays;

/**
 * 
 * Implementation of Union and Find operations on a Set using Weighted Quick
 * Union with Path Compression.
 * 
 * @author michaeljohnson
 *
 */
public class Set {

	/**
	 * Height of the tree rooted at any index.
	 */
	private int[] weight;
	/**
	 * Parent index for the element at any index. If element is its own parent, it
	 * is a root.
	 */
	private int[] parent;

	/**
	 * Initializes a fixed-size set.
	 * 
	 * @param size
	 *            Fixed size of the set
	 */
	public Set(int size) {
		weight = new int[size];
		Arrays.fill(weight, 1);
		parent = new int[size];
		Arrays.setAll(parent, i -> i);
	}

	/**
	 * Test classes should not test themselves, but that's just how I set things up.
	 */
	public Set() {
		this(100);
	}

	/**
	 * Utility method to find index of root element for any element Can be the same
	 * element, which means parameter element is a root.
	 * 
	 * @param element
	 *            index of element
	 * @return index of root of parameter element
	 */
	private int root(int element) {
		while (parent[element] != element) {
			// flattens the tree by making every other node point to its grandparent
			parent[element] = parent[parent[element]];
			element = parent[element];
		}
		return element;
	}

	/**
	 * returns true if both elements are in the same set, false otherwise
	 * 
	 * @param a
	 *            index of element a
	 * @param b
	 *            index of element b
	 * @return true if elements are in the same set, false otherwise
	 */
	public boolean find(int a, int b) {
		return root(a) == root(b);
	}

	/**
	 * Union two elements by joining their trees
	 * 
	 * @param a
	 * @param b
	 */
	public void union(int a, int b) {
		a = root(a);
		b = root(b);
		int small, big;
		if (weight[a] > weight[b]) {
			small = b;
			big = a;
		} else {
			small = a;
			big = b;
		}
		parent[small] = big;
		if (weight[small] == weight[big])
			weight[big]++;
	}

}
