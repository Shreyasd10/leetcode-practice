import java.util.*;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node clonedNode = new Node(node.val);
        map.put(node,clonedNode);
        q.offer(node);

        while(!q.isEmpty()){
            Node currentNode = q.poll();
            for(Node neighbor : currentNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor , new Node(neighbor.val));
                    q.offer(neighbor);
                }
                map.get(currentNode).neighbors.add(map.get(neighbor));
            }
        }
        return clonedNode;
    }
}
