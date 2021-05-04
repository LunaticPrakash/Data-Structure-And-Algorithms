class Graph:

    def __init__(self):
        self.graph = []

    def add_edges_with_weight(self, u, v, w):
        self.graph.append([u, v, w])

    def print_result(self, distance):
        print("Vertex\t\tDistance")
        for i in range(len(distance)):
            print(f"{i}\t\t{distance[i]}")

    # Step 1: Initialize distances from src to all other vertices
    # as INFINITE
    def initialize_source(self, src, V):
        distance = [float("Inf")]*V
        distance[src] = 0
        return distance

    # Step 2: Relax all edges |V| - 1 times. A simple shortest
    # path from src to any other vertex can have at-most |V| - 1
    # edges
    def relax(self, distance, u, v, w):
        if distance[v] > distance[u]+w:
            distance[v] = distance[u]+w
        return distance

    def bellman_ford(self, src, V):
        dist = self.initialize_source(src, V)

        for i in range(V-1):
            for u, v, w in self.graph:
                dist = self.relax(dist, u, v, w)

        # Step 3: check for negative-weight cycles. The above step
        # guarantees shortest distances if graph doesn't contain
        # negative weight cycle. If we get a shorter path, then there
        # is a cycle.
        for u, v, w in self.graph:
            if dist[v] > dist[u]+w:
                print("Graph contains negative weight cycle")
                return

        self.print_result(dist)


my_graph = Graph()

my_graph.add_edges_with_weight(0, 1, 4)
my_graph.add_edges_with_weight(0, 2, 2)
my_graph.add_edges_with_weight(1, 2, 3)
my_graph.add_edges_with_weight(1, 3, 2)
my_graph.add_edges_with_weight(1, 4, 3)
my_graph.add_edges_with_weight(2, 1, 1)
my_graph.add_edges_with_weight(2, 4, 5)
my_graph.add_edges_with_weight(4, 3, -5)

my_graph.bellman_ford(0, 5)
