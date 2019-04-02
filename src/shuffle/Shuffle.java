package shuffle;

import java.util.List;

public class Shuffle {

	public static <T> void shuffle(List<T> deck) {
		  for (int i=0; i<deck.size(); i++) {
		    // swap
		    int slot = (int)(Math.random() * (double) deck.size());
		    T tmp1 = deck.get(slot);
		    T tmp2 = deck.get(i);
		    deck.set(i, tmp1);
		    deck.set(slot, tmp2);
		  }
		}
	
}
