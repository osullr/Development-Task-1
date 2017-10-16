import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	Node left, right;

	Node(int value) {
		data = value;
		left = right = null;
	}
}

public class LowestCommonAncestor {

	Node root;
	private List<Integer> path1 = new ArrayList<>();
	private List<Integer> path2 = new ArrayList<>();

	int LowestCommonAncestor(int node1, int node2) {
		path1.clear();
		path2.clear();
		return findLowestCommonAncestor(root, node1, node2);

	}

	private int findLowestCommonAncestor(Node root, int node1, int node2) {
		if (!findPath(root, node1, path1) || !findPath(root, node2, path2)) {
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

	private boolean findPath(Node root, int n, List<Integer> path) {
		if (root == null) {
			return false;
		}
		path.add(root.data);

		if (root.data == n) {
			return true;
		}

		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}

		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}

		path.remove(path.size() - 1);

		return false;
	}

}
