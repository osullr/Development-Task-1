import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	ArrayList<Node> parentNodes;
	Node left;
	Node right;
	
	Node(int value) {
		data = value;
		parentNodes = new ArrayList<Node>();
		left = right;
		left = null;
		right = null;
	}
}

public class DAG {

	Node root;

	private List<Integer> path1 = new ArrayList<>();
	private List<Integer> path2 = new ArrayList<>();

	int LowestCommonAncestorBinaryTree(int node1, int node2) {
		path1.clear();
		path2.clear();
		return findLowestCommonAncestorBinaryTree(root, node1, node2);
	}

	private int findLowestCommonAncestorBinaryTree(Node root, int node1, int node2) {
		if (!findPathBinaryTree(root, node1, path1) || !findPathBinaryTree(root, node2, path2)) {
			if (path2.size() == 0 && path2.size() == 0) {
				System.out.println("The tree is empty");
			}
			if (path1.size() > 0) {
				System.out.println("Node 1 is present");
			}
			if (path2.size() > 0) {
				System.out.println("Node 2 is present");
			}
			return -1;
		}
		int i;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			if (!path1.get(i).equals(path2.get(i)))
				break;
		}
		return path1.get(i - 1);
	}

	int LowestCommonAncestorDAG(ArrayList<Node> graph, Node node1, Node node2) {
		return findLowestCommonAncestorDAG(graph, root, node1, node2);
	}

	int findLowestCommonAncestorDAG(ArrayList<Node> graph, Node root, Node node1, Node node2) {
		if (node1.parentNodes != null && node2.parentNodes != null || !graphAcyclic(graph)) {
			for (int i = 0; i < node2.parentNodes.size(); i++) {
				for (int j = 0; j < node1.parentNodes.size(); j++) {
					if (node2.parentNodes.get(i) == node1.parentNodes.get(j)) {
						return node2.parentNodes.get(i).data;
					}
				}
			}
		} else
			return root.data;
		return 0;
	}

	private boolean findPathBinaryTree(Node root, int n, List<Integer> path) {
		if (root == null) {
			return false;
		}
		path.add(root.data);

		if (root.data == n) {
			return true;
		}

		if (root.left != null && findPathBinaryTree(root.left, n, path)) {
			return true;
		}

		if (root.right != null && findPathBinaryTree(root.right, n, path)) {
			return true;
		}

		path.remove(path.size() - 1);

		return false;
	}

	boolean graphAcyclic(ArrayList<Node> graph) {
		if (graph == null) {
			return true;
		}
		for (int i = 0; i < graph.size(); i++) {
			boolean notAcyclic = false;
			ArrayList<Node> checked = new ArrayList<Node>();
			Node index = graph.get(i);
			ArrayList<Node> arrList = new ArrayList<Node>();
			notAcyclic = isGraphAcyclic(graph, arrList, checked, notAcyclic, index);
			if (notAcyclic) {
				return false;
			}
		}
		return true;
	}

	private boolean isGraphAcyclic(ArrayList<Node> graph, ArrayList<Node> arrList, ArrayList<Node> checked,
			boolean notAcyclic, Node index) {
		arrList.add(index);
		checked.add(index);
		for (int i = 0; i < index.parentNodes.size(); i++) {
			Node curNode = (Node) index.parentNodes.get(i);
			if (!checked.contains(curNode)) {
				notAcyclic = notAcyclic || isGraphAcyclic(graph, arrList, checked, notAcyclic, curNode);
			} else if (arrList.contains(curNode)) {
				notAcyclic = true;
			}
			return notAcyclic;
		}
		arrList.remove(index);
		return notAcyclic;
	}

	public void addParentNodesToNodeWithLocation(int location, Node node1, Node node2) {
		for (int i = 0; i < node1.parentNodes.size(); i++) {
			if (!node2.parentNodes.contains(node1.parentNodes.get(i))) {
				node2.parentNodes.add(location, node1.parentNodes.get(i));
			}
		}
	}

	public void addParentNodesToNode(Node node1, Node node2) {
		for (int i = 0; i < node1.parentNodes.size(); i++) {
			if (!node2.parentNodes.contains(node1.parentNodes.get(i))) {
				node2.parentNodes.add(node1.parentNodes.get(i));
			}
		}
	}
}