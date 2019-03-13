package graphs_sets;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KruskalTest {

	@Test
	public void testKruskal() {
		Kruskal kruskal = new Kruskal();
		kruskal.add(kruskal.new Edge(0, 1, 4));
		kruskal.add(kruskal.new Edge(1, 2, 8));
		kruskal.add(kruskal.new Edge(2, 3, 7));
		kruskal.add(kruskal.new Edge(3, 4, 9));
		kruskal.add(kruskal.new Edge(1, 7, 11));
		kruskal.add(kruskal.new Edge(7, 8, 7));
		kruskal.add(kruskal.new Edge(2, 8, 2));
		kruskal.add(kruskal.new Edge(6, 8, 6));
		kruskal.add(kruskal.new Edge(2, 5, 4));
		kruskal.add(kruskal.new Edge(3, 5, 14));
		kruskal.add(kruskal.new Edge(0, 7, 8));
		kruskal.add(kruskal.new Edge(6, 7, 1));
		kruskal.add(kruskal.new Edge(5, 6, 2));
		kruskal.add(kruskal.new Edge(4, 5, 10));
		assertEquals(37, kruskal.MST());
	}
}
