package tree_reversal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tree_reversal.Tree.Node;

public class TreeTest {
	
	@Test
	public void testReversal() {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		Node G = new Node("G");
		Node H = new Node("H");
		Node I = new Node("I");
		
		A.child = B;
		B.sibling = C;
		C.sibling = D;
		B.child = E;
		E.sibling = F;
		C.child = G;
		G.sibling = H;
		D.child = I;
		
		Tree.reverse(A);
		
		assertEquals(D, A.child);
		assertEquals(null, A.sibling);
		assertEquals(F, B.child);
		assertEquals(null, B.sibling);
		assertEquals(H, C.child);
		assertEquals(B, C.sibling);
		assertEquals(I, D.child);
		assertEquals(C, D.sibling);
		assertEquals(null, E.child);
		assertEquals(null, E.sibling);
		assertEquals(null, F.child);
		assertEquals(E, F.sibling);
		assertEquals(null, G.child);
		assertEquals(null, G.sibling);
		assertEquals(null, H.child);
		assertEquals(G, H.sibling);
		assertEquals(null, I.child);
		assertEquals(null, I.sibling);
	}
	
}
