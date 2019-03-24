package word_to_word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two words of equal length and a dictionary, 
 * write a method to transform one word into the other changing only one letter at a time. 
 * The new word you get at each step must also be in the dictionary. Example:
 * DAMP -> LAMP -> LIMP -> LIME -> LIKE
 * 
 * This problem will require a dictionary search that finds words of L length that are one-letter away from matching a given word. When such words are found they need to be tracked. A newly found word should be queued as to mark it so that another dictionary search will be started to find every one-letter different word as before. When a word is fully explored it should be marked complete so that, if it is found again, it will not be explored again. Every time a new word is found in the dictionary, its origin word should be saved so that, at the end, we can trace back to the origin word.

Data Structures:

- HashMap < String, String > origin : Map from word -> originword
- HashSet < String > explored : Words that have already been explored (or are being explored)
- LinkedList < String > queue : Words found in dictionary to be explored (add(0), get()), used to implement a kind of breadth-first search
- LinkedList < String > result : Lots of add(0) as we build our result list up
- HashSet < String > dictionary : Given 

 * 
 * @author michaeljohnson
 *
 */
public class WordToWord {
	  // assume startWord, endWord, and dictionary are in all caps
	  public static List findPath (String startWord, String endWord, HashSet<String> dictionary) {
	    HashMap <String,String> origin = new HashMap<>();
	    HashSet <String> explored = new HashSet<>(); // HashSet not HashMap
	    LinkedList <String> queue = new LinkedList<>();
	    
	    queue.add(0, startWord); // push to low end
	    origin.put(startWord, null);

	    
	    while (!queue.isEmpty()) {
	      String searchWord = queue.remove(queue.size()-1); // Needed an index
	      // REMOVE not GET
	      explored.add(searchWord);
	      
	      for (String foundWord: oneOffWords(searchWord)) {
	        if (foundWord.equals(endWord)) {
	          LinkedList<String> answer = new LinkedList<>();
	          origin.put(endWord, searchWord);
	          String word = endWord;
	          answer.add(0, word); // add not put
	          while (origin.get(word) != null) {
	            word = origin.get(word);
	            answer.add(0, word); // add not put
	          }
	          return answer;
	        }
	        if (dictionary.contains(foundWord) && !explored.contains(foundWord)) {
	          queue.add(0, foundWord);
	          origin.put(foundWord, searchWord);
	        }
	      }
	    }
	    
	    return null;
	  }
	 
	  private static List<String> oneOffWords(String word) { // Needed generic type
	    ArrayList<String> foundWords = new ArrayList<>();
	    for (int i=0; i<word.length(); i++) { // String.length() is method
	      char[] wordArray = word.toCharArray();
	      for (char c='A'; c<='Z'; c++) { // char not int
	        wordArray[i] = c;
	        String newWord = new String(wordArray);
	        if (!newWord.equals(word)) foundWords.add(newWord);
	      }
	    }
	    return foundWords;
	  }
	}