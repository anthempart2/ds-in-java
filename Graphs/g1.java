//adjacency list representation of a g1
import java.util.*;

public class g1 {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public g1(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // Uncomment this line if the g1 is undirected
    }

    public void printg1() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (Integer neighbor : adjacencyList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the g1: ");
        int numVertices = scanner.nextInt();

        g1 graph = new g1(numVertices);

        System.out.println("Enter the edges in the format 'source destination'. Enter -1 to stop.");

        while (true) {
            System.out.print("Enter edge: ");
            int source = scanner.nextInt();

            if (source == -1) {
                break;
            }

            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.println("\nAdjacency List Representation of the g1:");
        graph.printg1();

        scanner.close();
    }
}
