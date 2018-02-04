import java.util.LinkedList;
import java.util.Queue;

public class BFS {
  public static void BFSAlgorithm(NonWeightedGraph graph, int start, boolean[]
      visited, Queue<Integer> Q) {
    LinkedList<Integer>[] adjList = graph.getAdjList();
    int v = start;
    visited[v] = true;
    Q.add(v);
    while (!Q.isEmpty()) {
      int y = Q.poll();
      System.out.println(y + "visited");
      for (int i = 0; i < adjList[y].size(); i++) {
        if (!visited[adjList[y].get(i)]) {
          int z = adjList[y].get(i);
          visited[z] = true;
          Q.add(z);
        }
      }
    }
  }

  public static void main(String[] args) {
    NonWeightedGraph graph = new NonWeightedGraph(4); // Whatever number
    // Add edges
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);
    boolean[] visited = new boolean[graph.getNoV()];
    Queue<Integer> Q = new LinkedList<>();
    BFSAlgorithm(graph, 2, visited, Q);
  }
}
