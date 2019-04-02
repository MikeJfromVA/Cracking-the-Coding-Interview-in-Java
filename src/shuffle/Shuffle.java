package shuffle;

import java.util.List;

public class Shuffle {

	public static T void shuffle(List<T> deck) {
		  for (int i=0; i<deck.length; i++) {
		    // swap
		    int slot = random() * deck.length;
		    T tmp1 = deck.get(slot);
		    S tmp2 = deck.get(i);
		    deck.set(i, tmp1);
		    deck.set(slot, tmp2);
		  }
		}
	
}
