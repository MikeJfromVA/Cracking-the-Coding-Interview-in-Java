package graphs_sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * Implementation of Prim's Minimum Spanning Tree.
 * 
 * Using nested loops, this is an O(V^2) time complexity algorithm. It can be improved using
 * a Fibonacci Heap.
 * 
 * @author michaeljohnson
 *
 */
public class Prim {

	public class Edge implements Comparable<Edge> {
		public final int nodeA;
		public final int nodeB;
		public final int weight;

		public Edge(int nodeA, int nodeB, int weight) {
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	private int[][] adjacencyMatrix;
	private int nodeCount;

	public Prim(int edgeCount) {
		adjacencyMatrix = new int[edgeCount][edgeCount];
		for (int[] row : adjacencyMatrix) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		this.nodeCount = edgeCount;
	}

	public void add(Edge e) {
		adjacencyMatrix[e.nodeA][e.nodeB] = e.weight;
		adjacencyMatrix[e.nodeB][e.nodeA] = e.weight;
	}

	/**
	 * Calculates the total weights of all edges in the Minimum Spanning Tree of the
	 * current graph.
	 * 
	 * @return
	 */
	public int MST() {
		int mst = 0;
		int edgesAdded = 0;
		// all selected edges are in the MST and will not be re-added
		boolean[] selected = new boolean[nodeCount];
		selected[0] = true;
		while (edgesAdded < nodeCount - 1) {
			int x = 0;
			int y = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < nodeCount; i++) {
				if (selected[i]) {
					for (int j = 0; j < nodeCount; j++) {
						// Don't examine edges that create cycles
						if (!selected[j] && min > adjacencyMatrix[i][j]) {
							min = adjacencyMatrix[i][j];
							x = i;
							y = j;
						}
					}
				}
			}
			System.out.printf("%d %d %d\n", x, y, adjacencyMatrix[x][y]);
			edgesAdded++;
			mst += adjacencyMatrix[x][y];
			selected[y] = true;
		}

		return mst;
	}
}
