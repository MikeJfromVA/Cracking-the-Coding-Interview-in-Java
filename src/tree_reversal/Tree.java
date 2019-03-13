package tree_reversal;

/*
 * Take a tree in child/sibling representation and reverse all of its sibling list.
 * 
 * A tree like this:
 * 
 * A
 * /
 * B----C----D
 * /    /    /
 * E-F  G-H  I
 * 
 * should be transformed into this:
 * 
 * A
 * /
 * D----C----B
 * /    /    /
 * I   H-G   F-E
 * 
 */

public class Tree {

	static class Node {
		String value;
		Node sibling;
		Node child;
		Node(String value) {
			this.value = value;
		}
	}

	static Node reverse(Node root) {
		// null do nothing
		if (root == null)
			return null;

		root.child = reverse(root.child);

		// One child do nothing
		if (root.sibling == null)
			return root;

		// Reverse siblings for all items but the last
		Node previous = root;
		Node cursor = root.sibling;
		previous.sibling = null;
		Node next = cursor.sibling;
		while (next != null) {
			cursor.sibling = previous;

			previous = cursor;
			cursor = next;
			next = next.sibling;
		}
		cursor.sibling = previous;

		return cursor;
	}
}
