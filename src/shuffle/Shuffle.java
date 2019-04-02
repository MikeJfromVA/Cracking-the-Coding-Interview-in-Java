package shuffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shuffle {

	public static <T> void shuffle(List<T> deck) {
		for (int i = 0; i < deck.size(); i++) {
			// swap
			int slot = (int) (Math.random() * (double) deck.size() - 1) + 1;
			T tmp1 = deck.get(slot);
			T tmp2 = deck.get(i);
			deck.set(i, tmp1);
			deck.set(slot, tmp2);
		}
	}

	public static void main(String[] args) {
		List<String> deck = Arrays.asList(new String[] { "a", "b", "c", "d", "e", "f" });
		System.out.println(deck);
		shuffle(deck);
		System.out.println(deck);
		shuffle(deck);
		System.out.println(deck);
		shuffle(deck);
		System.out.println(deck);
	}

}
