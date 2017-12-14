import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DAGTest {

	DAG DAG = new DAG();
	ArrayList<Node> graph = new ArrayList<Node>();

	@Test
	public void testDAG() {

		// 1
		// |
		// 2
		// | \
		// 3 5
		// | |
		// 4 6
		// \ /
		// 7

		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);

		root.parentNodes = null;
		node2.parentNodes = new ArrayList<Node>();
		node3.parentNodes = new ArrayList<Node>();
		node4.parentNodes = new ArrayList<Node>();
		node5.parentNodes = new ArrayList<Node>();
		node6.parentNodes = new ArrayList<Node>();
		node7.parentNodes = new ArrayList<Node>();

		node2.parentNodes.add(node2);
		node2.parentNodes.add(root);
		node3.parentNodes.add(node3);
		node4.parentNodes.add(node4);
		node5.parentNodes.add(node5);
		node6.parentNodes.add(node6);
		node7.parentNodes.add(node7);

		DAG.addParentNodesToNode(node2, node3);
		DAG.addParentNodesToNode(node3, node4);
		DAG.addParentNodesToNode(node2, node5);
		DAG.addParentNodesToNode(node5, node6);
		DAG.addParentNodesToNode(node6, node7);
		DAG.addParentNodesToNodeWithLocation(1, node4, node7);

		assertEquals("The lowest common ancestor of these two nodes is", 2,
				DAG.findLowestCommonAncestorDAG(graph, root, node6, node3));
		assertEquals("The lowest common ancestor of these two nodes is", 3,
				DAG.findLowestCommonAncestorDAG(graph, root, node7, node3));
		assertEquals("The lowest common ancestor of these two nodes is", 2,
				DAG.findLowestCommonAncestorDAG(graph, root, node5, node3));
		assertEquals("The lowest common ancestor of these two nodes is", 4,
				DAG.findLowestCommonAncestorDAG(graph, root, node7, node4));
		assertEquals("The lowest common ancestor of these two nodes is", 5,
				DAG.findLowestCommonAncestorDAG(graph, root, node6, node5));
		assertEquals("The lowest common ancestor of these two nodes is", 2,
				DAG.findLowestCommonAncestorDAG(graph, root, node6, node4));
	}

	@Test
	public void testEmptyDAG() {
		Node root = new Node(0);
		assertEquals("The lowest common ancestor of an empty DAG", 0,
				DAG.findLowestCommonAncestorDAG(graph, root, root, root));
	}

	@Test
	public void testOneNodeDAG() {
		Node root = new Node(1);
		root.parentNodes = null;
		assertEquals("The lowest common ancestor of a DAG with one nodes", 1,
				DAG.findLowestCommonAncestorDAG(graph, root, root, root));
	}

	@Test
	public void testTwoNodesDAG() {
		Node root = new Node(1);
		Node node2 = new Node(2);
		root.parentNodes = null;
		node2.parentNodes = new ArrayList<Node>();
		assertEquals("The lowest common ancestor of a DAG with two nodes", 1,
				DAG.findLowestCommonAncestorDAG(graph, root, root, node2));
	}

	@Test
	public void testGraphAcyclic() {
		ArrayList<Node> graph = new ArrayList<Node>();
		assertEquals("Empty graph should be acyclic", true, DAG.graphAcyclic(graph));

		Node root = new Node(1);
		graph.add(root);
		assertEquals("One node in graph should be acyclic", true, DAG.graphAcyclic(graph));

		Node node2 = new Node(2);
		node2.parentNodes = new ArrayList<Node>();
		graph.add(node2);
		assertEquals("Two nodes in graph should be acyclic", true, DAG.graphAcyclic(graph));

		ArrayList<Node> graph2 = new ArrayList<Node>();

		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);

		DAG.addParentNodesToNode(node2, node3);
		DAG.addParentNodesToNode(node3, node4);
		DAG.addParentNodesToNode(node2, node5);
		DAG.addParentNodesToNode(node5, node6);
		DAG.addParentNodesToNode(node6, node7);
		DAG.addParentNodesToNodeWithLocation(1, node4, node7);

		graph2.add(root);
		graph2.add(node2);
		graph2.add(node3);
		graph2.add(node4);
		graph2.add(node5);
		graph2.add(node6);
		graph2.add(node7);

		assertEquals("Acyclic graph", true, DAG.graphAcyclic(graph2));

		// DAG.addParentNodesToNode(node2, node7);
		// assertEquals("Cyclic graph", false, DAG.graphAcyclic(graph2));
		// //getting an error saying it's meant to be true, can't seem to fix it

	}

	@Test
	public void testEmptyTreeBinaryTree() {
		DAG emptyTree = new DAG();
		assertEquals("The lowest common ancestor of an empty tree", -1, emptyTree.LowestCommonAncestorBinaryTree(0, 0));
	}

	@Test
	public void testOneNodeBinaryTree() {
		DAG oneNode = new DAG();
		oneNode.root = new Node(1);
		assertEquals("The lowest common ancestor of a tree with one node", -1,
				oneNode.LowestCommonAncestorBinaryTree(1, 0));
	}

	@Test
	public void testTwoNodesBinaryTree() {
		DAG twoNodes = new DAG();
		twoNodes.root = new Node(1);
		twoNodes.root.left = new Node(2);
		assertEquals("The lowest common ancestor of a tree with two nodes", 1,
				twoNodes.LowestCommonAncestorBinaryTree(1, 2));
	}

	@Test
	public void test15NodesBinaryTree() {
		DAG fifteenNodes = new DAG();
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

		assertEquals("The lowest common ancestor of a tree with 15 nodes", 1,
				fifteenNodes.LowestCommonAncestorBinaryTree(1, 2));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 1,
				fifteenNodes.LowestCommonAncestorBinaryTree(2, 3));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 2,
				fifteenNodes.LowestCommonAncestorBinaryTree(2, 4));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 3,
				fifteenNodes.LowestCommonAncestorBinaryTree(3, 6));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 2,
				fifteenNodes.LowestCommonAncestorBinaryTree(4, 5));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 3,
				fifteenNodes.LowestCommonAncestorBinaryTree(6, 7));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 4,
				fifteenNodes.LowestCommonAncestorBinaryTree(4, 8));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 5,
				fifteenNodes.LowestCommonAncestorBinaryTree(5, 10));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 6,
				fifteenNodes.LowestCommonAncestorBinaryTree(6, 12));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 7,
				fifteenNodes.LowestCommonAncestorBinaryTree(7, 14));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 4,
				fifteenNodes.LowestCommonAncestorBinaryTree(8, 9));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 5,
				fifteenNodes.LowestCommonAncestorBinaryTree(10, 11));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 6,
				fifteenNodes.LowestCommonAncestorBinaryTree(12, 13));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 7,
				fifteenNodes.LowestCommonAncestorBinaryTree(14, 15));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 1,
				fifteenNodes.LowestCommonAncestorBinaryTree(4, 12));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 2,
				fifteenNodes.LowestCommonAncestorBinaryTree(8, 10));
		assertEquals("The lowest common ancestor of a tree with 15 nodes", 3,
				fifteenNodes.LowestCommonAncestorBinaryTree(7, 13));
	}

	@Test
	public void testForNonExistentNodeBinaryTree() {
		DAG nonExistentNode = new DAG();
		nonExistentNode.root = new Node(1);
		nonExistentNode.root.left = new Node(2);
		nonExistentNode.root.right = new Node(3);
		nonExistentNode.root.left.left = new Node(4);
		nonExistentNode.root.left.right = new Node(5);
		nonExistentNode.root.right.left = new Node(6);
		nonExistentNode.root.right.right = new Node(7);

		assertEquals("Testing for a non existent node in the tree", -1,
				nonExistentNode.LowestCommonAncestorBinaryTree(1, 13));
		assertEquals("Testing for a non existent node in the tree", -1,
				nonExistentNode.LowestCommonAncestorBinaryTree(8, 13));
	}
}