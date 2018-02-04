// For a weighted graph, it's convenient to just store the graph in a
// adjacency matrix

/*
  A brief description of Prim MST Algorithm
  First we choose any node as our start node
  Then we know we have got it in our MST
  Nodes adjacent to it are fringe nodes
  Then when there are fringe nodes, which means not all nodes are in our MST
  We choose the shortest arc and go to that node (greedy)
  Then this node becomes a node in our MST
  Then we turn nodes adjacent to this node (and unseen before) fringe nodes
  too, the loop keeps working until there is no more fringe nodes (no nodes
  are unseen)

  The optimisation we have here is we have a "parent" array, the parent of a
  node f in the fringe is the node in the tree t (MST) s.t. (t,f) arc has the
   least weight.

   The difference - to be noted in case I forget it in the future, is that
   the first scheme requires the program to check all arcs between nodes in
   current MST and fringe nodes, while in the second one we ignored arcs
   directed to the same fringe node with higher weight.

   Time complexity if O(n(n+m)) in the first one but it's O(n^2) in the
   second one.
 */
public class PrimMST {
  private int[] parent;
  private int[] weight;

  public void PrimAlgorithm(int[][] adjMatrix, int start) {
    boolean[] tree = new boolean[adjMatrix.length];
    parent = new int[adjMatrix.length];
    boolean[] fringe = new boolean[adjMatrix.length];
    weight = new int[adjMatrix.length];
    tree[start] = true;
    for (int i = 0; i < adjMatrix[start].length; i++) {
      if (adjMatrix[start][i] != Integer.MAX_VALUE) {
        fringe[i] = true;
        parent[i] = start;
        weight[i] = adjMatrix[start][i];
      } else {
        weight[i] = Integer.MAX_VALUE;
      }
    }
    while (fringeNotEmpty(fringe)) {
      int minKey = minKey(weight, tree);
      fringe[minKey] = false;
      tree[minKey] = true;
      // weight[minKey] = Integer.MAX_VALUE;
      for (int i = 0; i < adjMatrix[minKey].length; i++) {
        if (!tree[i]) {
          if (fringe[i]) {
            if (adjMatrix[minKey][i] < weight[i]) {
              weight[i] = adjMatrix[minKey][i];
              parent[i] = minKey;
            }
          } else {
            fringe[i] = true;
            weight[i] = adjMatrix[minKey][i];
            parent[i] = minKey;
          }
        }
      }
    }
  }

  public int minKey(int key[], boolean[] tree) {
    int min = Integer.MAX_VALUE, min_index = -1;

    for (int v = 0; v < tree.length; v++)
      if (tree[v] == false && key[v] < min) {
        min = key[v];
        min_index = v;
      }

    return min_index;
  }

  public boolean fringeNotEmpty(boolean[] bArray) {
    for (int i = 0; i < bArray.length; i++) {
      if (bArray[i])
        return true;
    }
    return false;
  }

  public int[] getParent() {
    return parent;
  }

  public int[] getWeight() {
    return weight;
  }

  public static void main(String[] args) {
    PrimMST t = new PrimMST();
    int graph[][] = new int[][]{
        {Integer.MAX_VALUE, 2, Integer.MAX_VALUE, 6, Integer.MAX_VALUE},
        {2, Integer.MAX_VALUE, 3, 8, 5},
        {Integer.MAX_VALUE, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, 7},
        {6, 8, Integer.MAX_VALUE, Integer.MAX_VALUE, 9},
        {Integer.MAX_VALUE, 5, 7, 9, Integer.MAX_VALUE},
    };
    int start = 0;
    t.PrimAlgorithm(graph, start);
    int[] parent = t.getParent();
    int[] weight = t.getWeight();
    for (int i = 0; i < parent.length; i++) {
      if (i != start) {
        System.out.println(parent[i] + " to " + i);
        System.out.println("Weight : " + weight[i]);
      }
    }
  }
}
