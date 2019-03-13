package graphs_sets;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SetTest {

	@Test
	public void testUnionSet() {
		Set set = new Set(100);

		// no unions
		assertFalse(set.find(0, 1));
		assertFalse(set.find(0, 2));
		assertFalse(set.find(0, 3));
		assertFalse(set.find(2, 1));
		assertFalse(set.find(3, 2));
		assertFalse(set.find(4, 3));
		assertFalse(set.find(0, 99));
		// elements with themselves
		assertTrue(set.find(0, 0));
		assertTrue(set.find(1, 1));
		assertTrue(set.find(2, 2));
		assertTrue(set.find(99, 99));

		set.union(0, 1);
		assertTrue(set.find(0, 1));
		assertTrue(set.find(1, 0));
		assertFalse(set.find(0, 2));
		assertFalse(set.find(0, 3));
		assertFalse(set.find(2, 1));
		assertFalse(set.find(3, 2));
		assertFalse(set.find(4, 3));
		assertFalse(set.find(0, 99));
		// elements with themselves
		assertTrue(set.find(0, 0));
		assertTrue(set.find(1, 1));
		assertTrue(set.find(2, 2));
		assertTrue(set.find(99, 99));

		set.union(0, 2);
		assertTrue(set.find(0, 1));
		assertTrue(set.find(1, 0));
		assertTrue(set.find(0, 2));
		assertFalse(set.find(0, 3));
		assertTrue(set.find(2, 1));
		assertFalse(set.find(3, 2));
		assertFalse(set.find(4, 3));
		assertFalse(set.find(0, 99));
		// elements with themselves
		assertTrue(set.find(0, 0));
		assertTrue(set.find(1, 1));
		assertTrue(set.find(2, 2));
		assertTrue(set.find(99, 99));

		set.union(99, 2);
		assertTrue(set.find(0, 1));
		assertTrue(set.find(1, 0));
		assertTrue(set.find(0, 2));
		assertFalse(set.find(0, 3));
		assertTrue(set.find(2, 1));
		assertFalse(set.find(3, 2));
		assertFalse(set.find(4, 3));
		assertTrue(set.find(0, 99));
		// elements with themselves
		assertTrue(set.find(0, 0));
		assertTrue(set.find(1, 1));
		assertTrue(set.find(2, 2));
		assertTrue(set.find(99, 99));

		set.union(3, 4);
		assertTrue(set.find(0, 1));
		assertTrue(set.find(1, 0));
		assertTrue(set.find(0, 2));
		assertFalse(set.find(0, 3));
		assertTrue(set.find(2, 1));
		assertFalse(set.find(3, 2));
		assertTrue(set.find(4, 3));
		assertTrue(set.find(0, 99));
		// elements with themselves
		assertTrue(set.find(0, 0));
		assertTrue(set.find(1, 1));
		assertTrue(set.find(2, 2));
		assertTrue(set.find(99, 99));

		set.union(4, 0);
		assertTrue(set.find(0, 1));
		assertTrue(set.find(1, 0));
		assertTrue(set.find(0, 2));
		assertTrue(set.find(0, 3));
		assertTrue(set.find(2, 1));
		assertTrue(set.find(3, 2));
		assertTrue(set.find(4, 3));
		assertTrue(set.find(0, 99));
		// elements with themselves
		assertTrue(set.find(0, 0));
		assertTrue(set.find(1, 1));
		assertTrue(set.find(2, 2));
		assertTrue(set.find(99, 99));
}
}
