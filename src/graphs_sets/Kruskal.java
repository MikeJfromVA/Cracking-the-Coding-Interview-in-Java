package graphs_sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * Implementation of Kruskal's Minimum Spanning Tree
 *  
 * @author michaeljohnson
 *
 */
public class Kruskal {

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
	
	private ArrayList<Edge> edgeList = new ArrayList<Edge>();
	
	public void add(Edge e) {
		edgeList.add(e);
	}
	
	/**
	 * Calculates the total weights of all edges in the Minimum Spanning Tree of the current graph.
	 * 
	 * @return
	 */
	public int MST() {
		int mst = 0;
		Collections.sort(edgeList);
		Set cycleSet = new Set();
		for (Edge e: edgeList) {
			/*
			 * Only add an edge to the MST if the nodes are not already connected.
			 * They are connected if they are in the same set.
			 * When an edge is added to the MST, the sets of both nodes are connected
			 * together through Set Union.
			 */
			if (!cycleSet.find(e.nodeA, e.nodeB)) {
				mst += e.weight;
				cycleSet.union(e.nodeA, e.nodeB);
			}
		}
		return mst;
	}
}
