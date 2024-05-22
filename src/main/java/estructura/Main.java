package estructura;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/estructura/guategrafo.txt"));
            List<String[]> edges = new ArrayList<>();
            Set<String> cities = new HashSet<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                edges.add(parts);
                cities.add(parts[0]);
                cities.add(parts[1]);
            }

            int numVertices = cities.size();
            Graph graph = new Graph(numVertices);
            int index = 0;
            for (String city : cities) {
                graph.addCity(city, index++);
            }

            for (String[] edge : edges) {
                graph.addEdge(edge[0], edge[1], Integer.parseInt(edge[2]));
            }

            FloydWarshall floydWarshall = new FloydWarshall(graph);
            floydWarshall.floydWarshall();

            GraphCenter graphCenter = new GraphCenter(floydWarshall);

            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("Menu:");
                System.out.println("1. Calcular la ruta más corta entre dos ciudades.");
                System.out.println("2. Mostrar la ciudad que queda en el centro del grafo.");
                System.out.println("3. Modificar el grafo.");
                System.out.println("4. Finalizar el programa.");
                System.out.print("Seleccione una opción: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Ingrese la ciudad de origen: ");
                        String origin = scanner.nextLine();
                        System.out.print("Ingrese la ciudad de destino: ");
                        String destination = scanner.nextLine();
                        int originIndex = graph.getCityIndex(origin);
                        int destinationIndex = graph.getCityIndex(destination);
                        List<Integer> path = floydWarshall.getPath(originIndex, destinationIndex);
                        if (path == null) {
                            System.out.println("No hay ruta disponible.");
                        } else {
                            System.out.println("Ruta más corta: ");
                            for (int i : path) {
                                System.out.print(graph.getCity(i) + " ");
                            }
                            System.out.println("\nDistancia: " + floydWarshall.getDistances()[originIndex][destinationIndex] + " KM");
                        }
                        break;

                    case 2:
                        int center = graphCenter.findCenter();
                        System.out.println("El centro del grafo es: " + graph.getCity(center));
                        break;

                    case 3:
                        System.out.println("1. Interrupción de tráfico entre dos ciudades.");
                        System.out.println("2. Establecer conexión entre dos ciudades.");
                        System.out.print("Seleccione una opción: ");
                        int modifyChoice = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese la ciudad de origen: ");
                        String modOrigin = scanner.nextLine();
                        System.out.print("Ingrese la ciudad de destino: ");
                        String modDestination = scanner.nextLine();

                        if (modifyChoice == 1) {
                            graph.removeEdge(modOrigin, modDestination);
                        } else if (modifyChoice == 2) {
                            System.out.print("Ingrese la distancia en KM: ");
                            int distance = scanner.nextInt();
                            graph.addEdge(modOrigin, modDestination, distance);
                        }

                        floydWarshall = new FloydWarshall(graph);
                        floydWarshall.floydWarshall();
                        graphCenter = new GraphCenter(floydWarshall);
                        System.out.println("Modificación realizada.");
                        break;

                    case 4:
                        running = false;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
