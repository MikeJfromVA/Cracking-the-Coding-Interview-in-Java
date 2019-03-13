package remove_duplicates_linked_list;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.HashSet;

import org.junit.Test;

/**
 * 
 * Remove duplicates from an unsorted linked list
 * 
 * Q: What is in the linked list?
 * 
 * A: Strings
 * 
 * Q: Do I have the code for Node? Should I write it?
 * 
 * A: Write it
 * 
 * OK,
 * 
 * class Node { public Node next; public String string; }
 * 
 * Strategy:
 * 
 * Create a data collection. Walk the linked list * For each element, see if the
 * collection "contains" that element. If it contains it, remove it from the
 * linked list * If not, add it to the collection
 * 
 * For performance sake, the collection should be a sorted list or hashmap or
 * something supporting quick lookup.
 * 
 * Walking: cursor = cursor.next Removing: previous.next = previous.next.next
 * Roughly speaking
 * 
 * Lessons learned: Forgot to account for null payload string
 * 
 * @author michaeljohnson
 *
 */
public class RemoveDuplicates { // Leaving off public disabled JUnit

	class Node {
		Node next;
		String string;
	}

	// did not handle null strings
	void removeDuplicates(Node head) {
		Node cursor = head;
		Node previous = null; // Watch out for NPE (checked)
		HashSet<String> found = new HashSet<String>();

		while (cursor != null) {
			if (found.contains(cursor.string)) { // always false first iter
				// delete
				previous.next = cursor.next;
			} else {
				// do not delete
				found.add(cursor.string);
				previous = cursor;
			}
			cursor = cursor.next;
		}

	}

	// tests to think about:
	// Deleting last item
	// Deleting first item

	boolean listsEqual(Node a, Node b) {
		while (a != null || b != null) {
			if (a == null)
				return false;
			if (b == null)
				return false;
			if (!a.string.equals(b.string))
				return false;
			a = a.next;
			b = b.next;
		}
		return true;
	}

	@Test
	public void testRemoveDuplicates() {
		// sanity checks
		Node a = new Node();
		a.string = "hello";
		assertTrue(listsEqual(a, a));
		assertTrue(listsEqual(null, null));
		assertFalse(listsEqual(a, null));
		assertFalse(listsEqual(null, a));

		Node b = new Node();
		b.string = "hello";
		assertTrue(listsEqual(a, b));
		b.next = new Node();
		b.next.string = "world";
		assertFalse(listsEqual(a, b));

		// test implementation
		Node dupes = new Node();
		dupes.string = "hello";
		dupes.next = new Node();
		dupes.next.string = "world";
		dupes.next.next = new Node();
		dupes.next.next.string = "hello";
		dupes.next.next.next = new Node();
		dupes.next.next.next.string = "hello";
		dupes.next.next.next.next = new Node();
		dupes.next.next.next.next.string = "world";

		Node nodupes = new Node();
		nodupes.string = "hello";
		nodupes.next = new Node();
		nodupes.next.string = "world";

		removeDuplicates(dupes);

		assertTrue(listsEqual(nodupes, dupes));

	}
}
