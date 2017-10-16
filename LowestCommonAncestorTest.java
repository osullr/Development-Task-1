import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {

	@Test
	public void testEmptyTree() {
		LowestCommonAncestor emptyTree = new LowestCommonAncestor();
		assertEquals("The lowest common ancestor of an empty tree", -1, emptyTree.LowestCommonAncestor(0,0));
	}
	
	@Test
	public void testOneNode(){
		LowestCommonAncestor oneNode = new LowestCommonAncestor();
		oneNode.root = new Node(1);
		assertEquals("The lowest common ancestor of a tree with one node", -1, oneNode.LowestCommonAncestor(1,0));
	}
	
	@Test
	public void testTwoNodes(){
		LowestCommonAncestor twoNodes = new L=LowestCommonAncestor();
		twoNodes.root = new Node(1);
		twoNodes.root = new Node(2);
		assertEquals("The lowest common ancestor of a tree with two nodes", 1, twoNodes.LowestCommonAncestor(1,2));
	}

}
