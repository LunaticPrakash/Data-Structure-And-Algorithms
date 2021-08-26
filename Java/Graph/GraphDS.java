import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

class Graph {

    private Map<Integer, LinkedList<Integer>> graph = new HashMap<>();

    public void addVertex(int v) {
        graph.put(v, new LinkedList<>());
    }

    public void addEdge(int src, int dest, boolean bidirection) {
        if (!graph.containsKey(src))
            addVertex(src);
        if (!graph.containsKey(dest))
            addVertex(dest);

        graph.get(src).add(dest);
        if (bidirection == true)
            graph.get(dest).add(src);
    }

    public void deleteEdge(int src, int dest, boolean bidirection) {
        if (!graph.containsKey(src) || !graph.containsKey(dest))
            System.out.println("\nEither Source or Destination doesn't exist");
        else {
            graph.get(src).remove(Integer.valueOf(dest));
            if (bidirection == true)
                graph.get(dest).remove(Integer.valueOf(src));
        }
    }

    public void display() {
        // System.out.println(graph.values());
        System.out.println("\nAdjacency List representation of graph :- \n");
        for (Map.Entry<Integer, LinkedList<Integer>> map : graph.entrySet()) {
            System.out.println(map.getKey() + " -> " + map.getValue());
        }
    }

    public ArrayList<Integer> getPath(int src, int dest, ArrayList<Integer> path) {
        if (!graph.containsKey(src) || !graph.containsKey(dest)) {
            System.out.println("\nEither Source or Destination doesn't exist");
            return null;
        }
        path.add(src);
        if (src == dest)
            return path;
        if (graph.get(src).contains(dest))
            return path;
        for (int node : graph.get(src)) {
            if (!path.contains(node)) {
                ArrayList<Integer> newPath = getPath(node, dest, path);
                if (newPath != null && newPath.size() > 0)
                    return newPath;
                else
                    path.remove(path.size() - 1);
            }
        }
        return null;
    }

    public ArrayList<Integer> dfs(int v) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> traversed = new ArrayList<>();

        stack.push(v);
        while (!stack.isEmpty()) {
            v = stack.pop();
            if (!visited.contains(v)) {
                traversed.add(v);
                visited.add(v);
                Collections.reverse(graph.get(v));
                for (int w : graph.get(v)) {
                    if (!visited.contains(w))
                        stack.add(w);
                }
            }
        }
        return traversed;
    }

    public void dfsRec(int v, HashSet<Integer> visited) {
        visited.add(v);
        System.out.print(v + " ");
        Collections.reverse(graph.get(v));
        for (int w : graph.get(v)) {
            if (!visited.contains(w)) {
                dfsRec(w, visited);
            }
        }
    }

    public ArrayList<Integer> bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> traversed = new ArrayList<>();

        queue.add(v);
        visited.add(v);
        while (!queue.isEmpty()) {
            v = queue.remove();
            traversed.add(v);
            for (int w : graph.get(v)) {
                if (!visited.contains(w)) {
                    queue.add(w);
                    visited.add(w);
                }
            }
        }
        return traversed;
    }

    public int[][] adjListToMatrix() {
        int n = graph.size();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < graph.get(i).size(); j++)
                matrix[i][graph.get(i).get(j)] = 1;
        return matrix;
    }

    public int[][] warshallAlgo(int[][] adjMatrix) {
        int n = adjMatrix.length;
        int[][] TC = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                TC[i][j] = adjMatrix[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // TC[i][j] = TC[i][j] || (TC[i][k] && TC[k][j]);
                    if (TC[i][k] == 1 && TC[k][j] == 1)
                        TC[i][j] = 1;
                    else if (TC[i][k] == 0 || TC[k][j] == 0)
                        TC[i][j] = TC[i][j];
                }
            }
        }
        return TC;
    }
}

public class GraphDS {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Graph graph = new Graph();

        int choice = 1, a = 1, src, dest;
        while (choice != 5) {
            System.out.println("\n1.Insert\n2.Delete\n3.Display\n4.Extras\n5.Exit\n");
            choice = in.nextInt();
            switch (choice) {

                case 1:
                    System.out.print("\nEnter source and destination vertex to insert : ");
                    src = in.nextInt();
                    dest = in.nextInt();
                    // System.out.print("Are edges Bi-directional ? [Y/N] : ");
                    // String c = in.next();
                    // Boolean bi = c == "Y" ? true : false;
                    graph.addEdge(src, dest, true);
                    break;

                case 2:
                    System.out.print("\nEnter source and destination vertex to delete the edge: ");
                    src = in.nextInt();
                    dest = in.nextInt();
                    // System.out.print("Do you want to delete edges bi-directionally ? [Y/N] : ");
                    // String c = in.next();
                    // Boolean bi = c == "Y" ? true : false;
                    graph.deleteEdge(src, dest, true);
                    break;

                case 3:
                    graph.display();
                    break;

                case 4:
                    System.out.println("\n1. Find Path\n2. Find all path\n3. DFS\n4. BFS\n5. Adj List to Matrix"
                            + "\n6. Warshall Algorithm\n");
                    a = in.nextInt();
                    if (a == 1) {
                        System.out.print("\nEnter source and destination vertex : ");
                        src = in.nextInt();
                        dest = in.nextInt();
                        ArrayList<Integer> path = graph.getPath(src, dest, new ArrayList<>());
                        if (path != null) {
                            for (int v : path)
                                System.out.print(v + " -> ");
                            System.out.println(dest);
                        } else
                            System.out.println("No Path Exists!");
                    } else if (a == 2) {
                        System.out.print("\nEnter source and destination vertex : ");
                        src = in.nextInt();
                        dest = in.nextInt();
                        // graph.getAllPath(src, dest, new ArrayList<>());
                        // System.out.println(graph.result);
                    } else if (a == 3) {
                        System.out.print("\nEnter start vertex : ");
                        src = in.nextInt();
                        ArrayList<Integer> traversed = graph.dfs(src);
                        System.out.println(traversed);
                        graph.dfsRec(src, new HashSet<Integer>());
                    } else if (a == 4) {
                        System.out.print("\nEnter start vertex : ");
                        src = in.nextInt();
                        ArrayList<Integer> traversed = graph.bfs(src);
                        System.out.println(traversed);
                    } else if (a == 5) {
                        int[][] matrix = graph.adjListToMatrix();
                        int n = matrix.length;
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++)
                                System.out.print(matrix[i][j] + "  ");
                            System.out.println();
                        }
                    } else if (a == 6) {
                        int[][] TC = graph.warshallAlgo(graph.adjListToMatrix());
                        for (int i = 0; i < TC.length; i++) {
                            for (int j = 0; j < TC.length; j++)
                                System.out.print(TC[i][j] + "  ");
                            System.out.println();
                        }
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("\nWrong Choice!\n");
            }
        }
        in.close();
    }
}