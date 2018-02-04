import java.util.LinkedList;

// This is a class implementing non-weighted graph
public class NonWeightedGraph {
  private int noV; // Number of vertices
  private LinkedList<Integer> adjList[]; // Adjacency list to store the graph

  // Constructor
  NonWeightedGraph(int v) {
    this.noV = v;
    adjList = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  // Add edge
  public void addEdge(int v, int w) {
    this.adjList[v].add(w);
  }

  public int getNoV() {
    return noV;
  }

  public LinkedList<Integer>[] getAdjList() {
    return adjList;
  }
}
