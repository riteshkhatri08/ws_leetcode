import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Q2642_DesignGraphWithShortestPathCalculator {

    public static void main(String[] args) {

        int n = 4;
        int[][] edges = new int[][] { { 0, 2, 5 }, { 0, 1, 2 }, { 1, 2, 1 }, { 3, 0, 3 } };
        var graph = new Q2642_DesignGraphWithShortestPathCalculator().new Graph(n, edges);
        graph.shortestPath(3, 2);
        System.out.println(graph.graph);
    }

    class Node {

        int name;
        int cost;

        Node(int name, int cost) {
            this.name = name;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "[name=" + name + ", cost=" + cost + "]";
        }

    }

    class Graph {
        // hashMap maping vertice to min heap of destinations and their cost
        // to keep closest destination at top
        HashMap<Integer, List<Node>> graph = new HashMap<Integer, List<Node>>();
        int n;

        private static final Comparator<Node> nodeComparator = (o1, o2) -> {
            return o1.cost > o2.cost ? 1 : o1.cost < o2.cost ? -1 : 0;
        };

        public Graph(int n, int[][] edges) {
            this.n = n;
            // Traverse input and convert it to hashmap
            for (int[] edge : edges) {
                List<Node> neighbours = graph.getOrDefault(edge[0], new ArrayList<Node>());
                neighbours.add(new Node(edge[1], edge[2]));
                graph.put(edge[0], neighbours);
            }
            // System.out.println("Init Graph: \n" + this.graph);
        }

        public void addEdge(int[] edge) {
            List<Node> neighbours = graph.getOrDefault(edge[0], new ArrayList<Node>());
            neighbours.add(new Node(edge[1], edge[2]));
            graph.put(edge[0], neighbours);

            // System.out.println("ADDED EDGE - " + edge[0] + " -> " + edge[1] + ", cost=" +
            // edge[2]);
        }

        public int shortestPath(int node1, int node2) {
            int answer;
            {
                // System.out.println("SPF: " + node1 + " ==to== " + node2 + "\n In Graph : " +
                // this.graph);
                if (node1 == node2) {
                    return 0;
                }
                // Store initial distance from node1 to everyother node as INTEGER.MAX_VALUE;
                int[] destcosts = new int[n];
                // int[] visited = new int[n];
                Arrays.fill(destcosts, Integer.MAX_VALUE);

                // costs from source to source
                destcosts[node1] = 0;

                PriorityQueue<Node> pq = new PriorityQueue<Node>(nodeComparator);
                // Add node1 to pq and explore its neighbours
                pq.add(new Node(node1, 0));

                while (!pq.isEmpty()) {
                    // Get Node from pq
                    Node cur = pq.poll();

                    // cost from source to cur node
                    int curcost = destcosts[cur.name];

                    if (cur.cost > destcosts[cur.name]) {
                        continue;
                    }

                    if (cur.name == node2) {
                        return destcosts[cur.name];
                    }

                    List<Node> neighbours = graph.get(cur.name);
                    if (neighbours == null) {
                        continue;
                    }

                    // Explore all neighbours
                    for (Node neigh : neighbours) {
                        // For each neighbour if new cost (curcost+ cost from current node to neighbour)
                        // < cost from source to neighbour
                        // then update it
                        if (curcost + neigh.cost < destcosts[neigh.name]) {
                            destcosts[neigh.name] = curcost + neigh.cost;
                            // if (visited[neigh.name] == 0) {
                            // add neighbour to pq
                            pq.add(new Node(neigh.name, destcosts[neigh.name]));
                            // }
                        }
                    }
                    // Mark current node as visited
                    // visited[cur.name] = 1;

                }

                answer = destcosts[node2] == Integer.MAX_VALUE ? -1 : destcosts[node2];
            }
            // System.gc();
            // System.out.println("ANSWER = " + answer);
            return answer;
        }
    }

    /**
     * Your Graph object will be instantiated and called as such:
     * Graph obj = new Graph(n, edges);
     * obj.addEdge(edge);
     * int param_2 = obj.shortestPath(node1,node2);
     */
}
