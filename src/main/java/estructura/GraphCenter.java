package estructura;

public class GraphCenter {
    private final FloydWarshall floydWarshall;

    public GraphCenter(FloydWarshall floydWarshall) {
        this.floydWarshall = floydWarshall;
    }

    public int findCenter() {
        int V = floydWarshall.getDistances().length;
        int[] eccentricity = new int[V];

        for (int i = 0; i < V; i++) {
            int maxDist = Integer.MIN_VALUE;
            for (int j = 0; j < V; j++) {
                if (i != j && floydWarshall.getDistances()[i][j] < Integer.MAX_VALUE) {
                    maxDist = Math.max(maxDist, floydWarshall.getDistances()[i][j]);
                }
            }
            eccentricity[i] = maxDist;
        }

        int center = 0;
        for (int i = 1; i < V; i++) {
            if (eccentricity[i] < eccentricity[center]) {
                center = i;
            }
        }

        return center;
    }
}
