public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return node;
		}

		//traverse the graph to get all the nodes in a list
		ArrayList<UndirectedGraphNode> nodes = getNodes(node);
		HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
		for (UndirectedGraphNode n : nodes) {
			mapping.put(n, new UndirectedGraphNode(n.label)); //what does n.label do
		} 
		for (UndirectedGraphNode n : nodes) {
      UndirectedGraphNode newNode = mapping.get(n);
      for (UndirectedGraphNode neighbor : n.neighbors) {
          UndirectedGraphNode newNeighbor = mapping.get(neighbor);
          newNode.neighbors.add(newNeighbor);
      }
    }
    return mapping.get(node);
	}

	private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
		Queue<UndirectedGraphNode> queue = new LinkednList<UndirectedGraphNode>();
		HashSet<UndirectedGraphNode> set = new HashSet<>();

		queue.offer(node);
		set.add(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode head = queue.poll();
			for (UndirectedGraphNode neighbor : head.neighbors) {
				if (!set.contains(neighbor)) {
					set.add(neighbor);
					queue.offer(neighbor);
				}
			}
		}

		return new ArrayList<UndirectedGraphNode>(set);
	}
}