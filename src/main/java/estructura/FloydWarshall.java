package estructura;
import java.util.*;

public class FloydWarshall {
    private final Graph graph;
    private int[][] dist;
    private int[][] next;

    public FloydWarshall(Graph graph) {
        this.graph = graph;
        int V = graph.getNumVertices();
        dist = new int[V][V];
        next = new int[V][V];
        initialize();
    }

    private void initialize() {
        int V = graph.getNumVertices();
        int[][] adjMatrix = graph.getAdjacencyMatrix();

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && adjMatrix[i][j] != Integer.MAX_VALUE) {
                    dist[i][j] = adjMatrix[i][j];
                    next[i][j] = j;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                    next[i][j] = -1;
                }
            }
        }
    }

    public void floydWarshall() {
        int V = graph.getNumVertices();
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    public int[][] getDistances() {
        return dist;
    }

    public int[][] getNext() {
        return next;
    }

    public List<Integer> getPath(int u, int v) {
        if (next[u][v] == -1) return null;
        List<Integer> path = new ArrayList<>();
        int current = u;
        while (current != v) {
            path.add(current);
            current = next[current][v];
        }
        path.add(v);
        return path;
    }
}
