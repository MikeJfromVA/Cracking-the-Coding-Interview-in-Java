package rabin_karp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringSearches {

	private static int naiveStringSearch(String pattern, String search) {
		search: for (int searchIndex = 0; searchIndex < search.length() - pattern.length() + 1; searchIndex += 1) {
			for (int patternIndex = 0; patternIndex < pattern.length(); patternIndex += 1) {
				if (pattern.charAt(patternIndex) != search.charAt(searchIndex + patternIndex))
					continue search;
			}
			return searchIndex;
		}
		return -1;
	}

	@Test
	void internalTestNaive() {
		assertEquals(3, naiveStringSearch("foo", "xghfooasd"));
		assertEquals(6, naiveStringSearch("abcd", "aababcabcdaababc"));
		assertEquals(-1, naiveStringSearch("hello", "goodbye"));
		assertEquals(-1, naiveStringSearch("goodbye", "hello"));
		assertEquals(-1, naiveStringSearch("longlonglong", "short"));
	}

	private void compareRabinKarpToNaive(String pattern, String search) {
		assertEquals(naiveStringSearch(pattern, search), RabinKarp.rabinKarp(pattern, search));
	}

	@Test
	void testRabinKarp() {
		compareRabinKarpToNaive("foo", "foo");
		compareRabinKarpToNaive("foo", "xghfooasd");
		compareRabinKarpToNaive("abcd", "aababcabcdaababc");
		compareRabinKarpToNaive("hello", "goodbye");
		compareRabinKarpToNaive("goodbye", "hello");
		compareRabinKarpToNaive("longlonglong", "short");
	}

}
