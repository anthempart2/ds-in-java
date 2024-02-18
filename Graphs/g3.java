//DFS algorithm

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class g2 {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public g2(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // Uncomment this line if the graph is undirected
    }

    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        System.out.println("Depth-First Search starting from vertex " + startVertex + ":");

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (!visited[currentVertex]) {
                System.out.print(currentVertex + " ");
                visited[currentVertex] = true;
            }

            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int numVertices = scanner.nextInt();

        g2 graph = new g2(numVertices);

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

        System.out.print("Enter the starting vertex for DFS: ");
        int startVertex = scanner.nextInt();

        graph.dfs(startVertex);

        scanner.close();
    }
}
