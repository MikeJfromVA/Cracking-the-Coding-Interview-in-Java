package rabin_karp;

public class RabinKarp {

	public static int rabinKarp(String pattern, String search) {
		// trivial cases
		if (pattern.length() == 0 || search.length() == 0)
			return -1;
		if (pattern == null || search == null)
			return -1;
		if (search.length() < pattern.length())
			return -1;

		// calculate hashes
		final int hashIndex = 256;

		int patternHash = 0;

		for (int index = 0; index < pattern.length(); index += 1)
			patternHash = (patternHash + pattern.charAt(index)) % hashIndex;

		int[] searchHashes = new int[search.length() - pattern.length() + 1];
		int searchHashAccumulator = 0;
		// hash of the word starting at the first index 0
		for (int index = 0; index < pattern.length(); index += 1) {
			searchHashAccumulator = (searchHashAccumulator + search.charAt(index)) % hashIndex;
		}
		searchHashes[0] = searchHashAccumulator;
		// hash of every index from 1 on
		for (int index = 1; index <= search.length() - pattern.length(); index += 1) {
			// add new character
			searchHashAccumulator += search.charAt(index + pattern.length() - 1);
			// remove old character
			searchHashAccumulator -= search.charAt(index - 1);
			// add padding to protect against negative numbers
			searchHashAccumulator += hashIndex;
			// modulo
			searchHashAccumulator %= hashIndex;
					
			searchHashes[index] = searchHashAccumulator;
		}

		// search for pattern
		search: for (int searchIndex = 0; searchIndex < search.length() - pattern.length() + 1; searchIndex += 1) {
			if (patternHash != searchHashes[searchIndex]) {
				System.out.println("Optimize!");
				continue;
			}
			for (int patternIndex = 0; patternIndex < pattern.length(); patternIndex += 1) {
				if (pattern.charAt(patternIndex) != search.charAt(searchIndex + patternIndex))
					continue search;
			}
			return searchIndex;
		}


		return -1;
	}

}
