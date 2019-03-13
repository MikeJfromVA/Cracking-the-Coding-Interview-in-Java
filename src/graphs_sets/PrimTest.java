package graphs_sets;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PrimTest {

	@Test
	public void testPrim() {
		Prim prim = new Prim(9);
		prim.add(prim.new Edge(0, 1, 4));
		prim.add(prim.new Edge(1, 2, 8));
		prim.add(prim.new Edge(2, 3, 7));
		prim.add(prim.new Edge(3, 4, 9));
		prim.add(prim.new Edge(1, 7, 11));
		prim.add(prim.new Edge(7, 8, 7));
		prim.add(prim.new Edge(2, 8, 2));
		prim.add(prim.new Edge(6, 8, 6));
		prim.add(prim.new Edge(2, 5, 4));
		prim.add(prim.new Edge(3, 5, 14));
		prim.add(prim.new Edge(0, 7, 8));
		prim.add(prim.new Edge(6, 7, 1));
		prim.add(prim.new Edge(5, 6, 2));
		prim.add(prim.new Edge(4, 5, 10));
		assertEquals(37, prim.MST());
	}
}
