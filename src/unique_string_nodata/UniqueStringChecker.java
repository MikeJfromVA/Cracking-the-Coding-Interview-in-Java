package unique_string_nodata;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

/**
 * Implement an algorithm to determine if all characters in a string are unique.
 * Do not use any additional data structures.
 * 
 * @author michaeljohnson
 *
 */
public class UniqueStringChecker {

	/**
	 * Since no additional data structures are allowed, using the stack through
	 * recursion. Recursive approach:
	 * 
	 * Base 0: "" result is true
	 * 
	 * Base 1: "a" result is true
	 * 
	 * Recursive: "abcd..." Iterate over positions 1,n and compare each character to
	 * position 0. If a match is found, return false. If the loop completes without
	 * matching, test the substring from 1,n recursively.
	 * 
	 * Using s.substring(i,j) since that one is familiar.
	 * 
	 * This solution is O(n^2), which is a penalty we pay for the recursive,
	 * zero-data approach.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isUniqueChars(String s) {
		if (s.equals(""))
			return true;
		// mistake thought length was a field
		if (s.length() == 1)
			return true;
		String a = s.substring(0, 1);
		for (int i = 1; i < s.length(); i++) {
			// second mistake means a.equals no s.equals
			if (a.equals(s.substring(i, i + 1)))
				return false;
		}
		return isUniqueChars(s.substring(1, s.length()));
	}

	@Test
	void testIsUniqueChars() {
		assertTrue(isUniqueChars(""));
		assertTrue(isUniqueChars("a"));
		assertTrue(isUniqueChars("b"));
		assertTrue(isUniqueChars("abcd"));
		assertFalse(isUniqueChars("abbba"));
		assertFalse(isUniqueChars("abcda"));
		assertFalse(isUniqueChars("aabcde"));
		assertFalse(isUniqueChars("zabcdz"));
		assertFalse(isUniqueChars("abcdefghb"));
	}

	/**
	 * Bonus: Come up with an O(n) approach if you are allowed to create a data
	 * structure.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isUniqueCharsNonRecursive(String s) {
		if (s.equals(""))
			return true;
		if (s.length() == 1)
			return true;

		boolean[] f = new boolean[Character.MAX_CODE_POINT];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (f[c])
				return false;
			else
				f[c] = true;
		}
		return true;
	}

	@Test
	void testisUniqueCharsNonRecursive() {
		assertTrue(isUniqueCharsNonRecursive(""));
		assertTrue(isUniqueCharsNonRecursive("a"));
		assertTrue(isUniqueCharsNonRecursive("b"));
		assertTrue(isUniqueCharsNonRecursive("abcd"));
		assertFalse(isUniqueCharsNonRecursive("abbba"));
		assertFalse(isUniqueCharsNonRecursive("abcda"));
		assertFalse(isUniqueCharsNonRecursive("aabcde"));
		assertFalse(isUniqueCharsNonRecursive("zabcdz"));
		assertFalse(isUniqueCharsNonRecursive("abcdefghb"));
	}

}
