import java.util.ArrayList;

class Node<T> {
	int data;
	private ArrayList<Node<T>> childNodes;
	int child[];

	Node(int value) {
		this.data = value;
		childNodes = new ArrayList<Node<T>>();
		child = null;
	}

	public class DAG {

		Node root;

		public Node getLCA(ArrayList<Node> graph, Node node1, Node node2) {

			if (!notNull(graph, node1, node2) && !graphAcyclic(graph)) {
				return null;
			} else {

			}
			return null;
		}

		private boolean notNull(ArrayList<Node> graph, Node node1, Node node2) {
			if (graph == null) {
				return false;
			}
			if (node1 == null || node2 == null) {
				return false;
			}
			if (!graph.contains(node1) || !graph.contains(node2)) {
				return false;
			}
			return true;
		}

		private boolean graphAcyclic(ArrayList<Node> graph) {
			if (graph == null) {
				return true;
			}
			for (int i = 0; i < graph.size(); i++) {
				boolean notAcyclic = false;
				ArrayList<Node> checked = new ArrayList<Node>();
				Node index = graph.get(i);
				ArrayList<Node> listToCompare = new ArrayList<Node>();
				notAcyclic = isGraphAcyclic(graph, listToCompare, checked, notAcyclic, index);
				if (notAcyclic) {
					return false;
				}
			}
			return false;
		}

		private boolean isGraphAcyclic(ArrayList<Node> graph, ArrayList<Node> listToCompare, ArrayList<Node> checked,
				boolean notAcyclic, Node index) {
			for (int i = 0; i < index.childNodes.size(); i++) {
				Node currentNode = (Node) index.childNodes.get(i);
				if (!checked.contains(currentNode))
					isGraphAcyclic(graph, listToCompare, checked, notAcyclic, index);
				else if (listToCompare.contains(currentNode)) {
					return true;
				}
			}
			listToCompare.remove(index);
			return notAcyclic;
		}

	}
}
