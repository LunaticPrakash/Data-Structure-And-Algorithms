import java.util.ArrayList;
import java.util.Arrays;

class Graphds {

    private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public void addEdgeWithWeight(int u, int v, int w) {
        graph.add(new ArrayList<>(Arrays.asList(u, v, w)));
    }

    public int[] initializeSource(int src, int n) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        return dist;
    }

    public int[] relax(int[] dist, int u, int v, int w) {
        if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + w)
            dist[v] = dist[u] + w;
        return dist;
    }

    public void bellman(int src, int n) {
        int[] dist = initializeSource(src, n);
        for (int i = 0; i < n - 1; i++) {
            dist = relax(dist, graph.get(i).get(0), graph.get(i).get(1), graph.get(i).get(2));
        }

        for (int i = 0; i < n - 1; i++) {
            int u = graph.get(i).get(0);
            int v = graph.get(i).get(1);
            int w = graph.get(i).get(2);

            if (dist[v] > dist[u] + w) {
                System.out.println("\nGraph contains negative cycle");
                return;
            }
        }
        for (int i = 0; i < n; i++)
            System.out.print(dist[i] + " ");
    }
}

public class BellmanFord {
    public static void main(String[] args) {
        Graphds graph = new Graphds();
        graph.addEdgeWithWeight(0, 1, 4);
        graph.addEdgeWithWeight(0, 2, 2);
        graph.addEdgeWithWeight(1, 2, 3);
        graph.addEdgeWithWeight(1, 3, 2);
        graph.addEdgeWithWeight(1, 4, 3);
        graph.addEdgeWithWeight(2, 1, 1);
        graph.addEdgeWithWeight(2, 4, 5);
        graph.addEdgeWithWeight(4, 3, -5);

        graph.bellman(0, 5);
    }
}
