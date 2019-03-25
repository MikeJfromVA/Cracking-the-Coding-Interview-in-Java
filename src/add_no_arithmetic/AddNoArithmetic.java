package add_no_arithmetic;

import java.util.List;
import java.util.TreeSet;

/**
 * 
 * Add two numbers without using + or any arithmetic operators.
 * 
 * @author michaeljohnson
 *
 */
public class AddNoArithmetic {

	public static int add(int a, int b) {
		// not sure what this does for negative numbers
		int c = 0;
		int sum = 0;
		for (int i = 0; i < 32; i++) {
			int x = (a >> i) & 1;
			int y = (b >> i) & 1;
			int d = (x | y) & ~(x & y); // x & y ~ is logical not
			d = (c | d) & ~(c & d);
			sum = sum | (d << i); // | not & for adding
			c = x & y | x & c | y & c;
		}
		return sum;
	}
	// realized later that a^b is xor
}
