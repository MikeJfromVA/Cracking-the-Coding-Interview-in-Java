package add_no_arithmetic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompoundWordsTest {

	@Test
	public void test() {
		assertEquals(0, AddNoArithmetic.add(0, 0));
		assertEquals(3, AddNoArithmetic.add(1, 2));
		assertEquals(33, AddNoArithmetic.add(22, 11));
		assertEquals(198, AddNoArithmetic.add(99, 99));
		assertEquals(-10, AddNoArithmetic.add(-7, -3));
	}
}
