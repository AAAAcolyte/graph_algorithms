import java.util.LinkedList;

public class DFS {
  public static void DFSAlgorithm(NonWeightedGraph graph, int start, boolean[]
      visited) {
    LinkedList<Integer>[] adjList = graph.getAdjList();
    int v = start;
    visited[v] = true;
    System.out.println(start + " visited");
    for (int i = 0; i < adjList[v].size(); i++) {
      if (visited[adjList[v].get(i)] == false) {
        DFSAlgorithm(graph, adjList[v].get(i), visited);
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
    DFSAlgorithm(graph, 2, visited);
  }
}
