package word_to_word;

import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import compound_word.CompoundWords.Implementation;

public class WordToWordTest {

	private void testAllImplementations(String word, List<String> dictionary, boolean expected) {
		for (Implementation method : Implementation.values()) {
//			assertEquals(expected, WordToWord.isCompoundWord(word, dictionary, method));
		}
	}

	@Test
	public void test() {
		HashSet<String> dictionary = new HashSet<>();
		dictionary.add("FOOD");
		dictionary.add("FOLD");
		dictionary.add("GOD");
		dictionary.add("GOOD");
		dictionary.add("GOOBER");
		dictionary.add("GOO");
		dictionary.add("DUDE");
		dictionary.add("GOOF");
		dictionary.add("GOLD");
		dictionary.add("DOODLE");
		dictionary.add("GOLF");
		dictionary.add("DAMP");
		dictionary.add("RAMP");
		dictionary.add("LAMP");
		dictionary.add("LAMB");
		dictionary.add("LIMP");
		dictionary.add("LIMB");
		dictionary.add("MIME");
		dictionary.add("LIME");
		dictionary.add("LIKE");
		dictionary.add("BIKE");
		
		System.out.println(WordToWord.findPath("FOOD", "GOLF", dictionary));
	}
}
