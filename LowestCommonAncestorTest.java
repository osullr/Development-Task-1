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
	
	@Test
	public void test15Nodes(){
		LowestCommonAncestor fifteenNodes = new LowestCommonAncestor()
		fifteenNodes.root = new Node(1);
		fifteenNodes.root.left = new Node(2);
		fifteenNodes.root.right = new Node(3);
		fifteenNodes.root.left.left = new Node(4);
		fifteenNodes.root.left.right = new Node(5);
		fifteenNodes.root.right.left = new Node(6);
		fifteenNodes.root.right.right = new Node(7);
		fifteenNodes.root.left.left.left = new Node(8);
		fifteenNodes.root.left.left.right = new Node(9);
		fifteenNodes.root.left.right.left = new Node(10);
		fifteenNodes.root.left.right.right = new Node(11);
		fifteenNodes.root.right.left.left = new Node(12);
		fifteenNodes.root.right.left.right = new Node(13);
		fifteenNodes.root.right.right.left = new Node(14);
		fifteenNodes.root.right.right.right = new Node(15);
		
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 1, fifteenNodes.LowestCommonAncestor(1,2));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 2, fifteenNodes.LowestCommonAncestor(2,3));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 2, fifteenNodes.LowestCommonAncestor(2,4));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 3, fifteenNodes.LowestCommonAncestor(3,6));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 2, fifteenNodes.LowestCommonAncestor(4,5));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 3, fifteenNodes.LowestCommonAncestor(6,7));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 4, fifteenNodes.LowestCommonAncestor(4,8));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 5, fifteenNodes.LowestCommonAncestor(5,10));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 6, fifteenNodes.LowestCommonAncestor(6,12));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 7, fifteenNodes.LowestCommonAncestor(7,14));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 4, fifteenNodes.LowestCommonAncestor(8,9));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 5, fifteenNodes.LowestCommonAncestor(10,11));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 6, fifteenNodes.LowestCommonAncestor(12,13));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 7, fifteenNodes.LowestCommonAncestor(14,15));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 1, fifteenNodes.LowestCommonAncestor(4,12));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 2, fifteenNodes.LowestCommonAncestor(8,10));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 3, fifteenNodes.LowestCommonAncestor(7,13));
		
		}
	
	@Test
	public void testForNonExistentNode(){
		LowestCommonAncestor nonExistentNode = new LowestCommonAncestor();
		nonExistentNode.root = new Node(1);
		nonExistentNode.root.left = new Node(2);
		nonExistentNode.root.right = new Node(3);
		nonExistentNode.root.left.left = new Node(4);
		nonExistentNode.root.left.right = new Node(5);
		nonExistentNode.root.right.left = new Node(6);
		nonExistentNode.root.right.right = new Node(7);
		
		assertEquals("Testing for a non existent node in the tree", -1, nonExistentNode.LowestCommonAncestor(1,13));
		assertEquals("Testing for a non existent node in the tree", -1, nonExistentNode.LowestCommonAncestor(8,13));
	}

}
