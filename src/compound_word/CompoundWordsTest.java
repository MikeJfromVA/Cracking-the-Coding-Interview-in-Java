package compound_word;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import compound_word.CompoundWords.Implementation;

public class CompoundWordsTest {

	private void testAllImplementations(String word, List<String> dictionary, boolean expected) {
		for (Implementation method : Implementation.values()) {
			assertEquals(expected, CompoundWords.isCompoundWord(word, dictionary, method));
		}
	}

	@Test
	public void test() {
		List<String> dictionary = new ArrayList<String>();
		dictionary.add("house");
		dictionary.add("boat");
		dictionary.add("birth");
		dictionary.add("day");
		dictionary.add("bar");
		dictionary.add("dream");
		dictionary.add("day");
		dictionary.add("crow");
		
		testAllImplementations("", dictionary, true);
		testAllImplementations("houseboat", dictionary, true);
		testAllImplementations("boathouse", dictionary, true);
		testAllImplementations("birthday", dictionary, true);
		testAllImplementations("daydream", dictionary, true);
		testAllImplementations("crowbar", dictionary, true);
		testAllImplementations("dreamboat", dictionary, true);
		testAllImplementations("dayday", dictionary, true);
		testAllImplementations("birthdaycrow", dictionary, true);
		testAllImplementations("dreamdreamdream", dictionary, true);
		
		testAllImplementations("pudding", dictionary, false);
		testAllImplementations("birthpig", dictionary, false);
	}
}
