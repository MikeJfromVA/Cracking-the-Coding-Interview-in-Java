package compound_word;

import java.util.List;

/**
 * 
 * Method to determine if a word can be built from a dictionary of words.
 * 
 * @author michaeljohnson
 *
 */
public class CompoundWords {
	public enum Implementation {
		SLOW;
	}

	public static boolean isCompoundWord(String word, List<String> dictionary, Implementation method) {
		switch (method) {
		case SLOW:
			return slow(word, dictionary);
		default:
			throw new RuntimeException("Java should provid exhaustive enum switches");
		}
	}

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

}
