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
	public enum Implementation {
		SLOW, FAST;
	}

	public static boolean isCompoundWord(String word, List<String> dictionary, Implementation method) {
		switch (method) {
		case SLOW:
			return slow(word, dictionary);
		case FAST:
			return fast(word, dictionary);
		default:
			throw new RuntimeException("Java should provid exhaustive enum switches");
		}
	}

	/**
	 * Assuming word is L letters and dictionary has N entries. N is large compared
	 * to L. Time complexity is O(N^L)
	 * 
	 * @param word
	 * @param dictionary
	 * @return
	 */
	private static boolean slow(String word, List<String> dictionary) {
		if (word.equals(""))
			return true;
		for (String prefix : dictionary) {
			if (word.equals(prefix))
				return true;
			if (word.length() < prefix.length())
				continue;
			if (word.substring(0, prefix.length()).equals(prefix)) {
				if (slow(word.substring(prefix.length()), dictionary))
					return true;
			}
		}
		return false;
	}

	/**
	 * Assuming word is L letters and dictionary has N entries. N is large compared
	 * to L Time complexity is O(L^2*log(N)).
	 * 
	 * @param word
	 * @param dictionary
	 * @return
	 */
	private static boolean fast(String word, List<String> dictionary) {
		TreeSet<String> treeSet = new TreeSet<String>(dictionary);
		return fast(word, treeSet);
	}

	private static boolean fast(String word, TreeSet<String> dictionary) {
		if (word.equals(""))
			return true;
		for (int start = 0; start < word.length(); start++) {
			for (int finish = start + 1; finish < word.length() + 1; finish++) {
				if (dictionary.contains(word.substring(start, finish))) {
					if (finish == word.length())
						return true;
					if (fast(word.substring(finish, word.length()), dictionary))
						return true;
				}
			}
		}
		return false;
	}

}
