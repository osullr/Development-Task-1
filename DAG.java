import java.util.ArrayList;

class Node<T> {
	int data;
	public ArrayList<Node<T>> childNodes;
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
			// TODO Auto-generated method stub
			return false;
		}

		private boolean graphAcyclic(ArrayList<Node> graph) {
			// TODO Auto-generated method stub
			return false;

		}
	}
}
