package estructura;

import java.util.*;

public class Graph {
    private final int[][] adjacencyMatrix;
    private final int numVertices;
    private final Map<String, Integer> cityToIndex;
    private final Map<Integer, String> indexToCity;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
        this.cityToIndex = new HashMap<>();
        this.indexToCity = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(adjacencyMatrix[i], Integer.MAX_VALUE);
        }
    }

    public void addCity(String city, int index) {
        cityToIndex.put(city, index);
        indexToCity.put(index, city);
    }

    public void addEdge(String city1, String city2, int distance) {
        int i = cityToIndex.get(city1);
        int j = cityToIndex.get(city2);
        adjacencyMatrix[i][j] = distance;
    }

    public void removeEdge(String city1, String city2) {
        int i = cityToIndex.get(city1);
        int j = cityToIndex.get(city2);
        adjacencyMatrix[i][j] = Integer.MAX_VALUE;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public String getCity(int index) {
        return indexToCity.get(index);
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getCityIndex(String city) {
        return cityToIndex.get(city);
    }
}
