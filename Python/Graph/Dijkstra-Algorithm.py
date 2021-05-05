class Graph:

    def print_result(self, distance):
        print("\nVertex\t\tDistance")
        for i in range(len(distance)):
            print(f"{i}\t\t{distance[i]}")

    def vertex_with_min_distance(self, dist, vis):
        min_dist = float("Inf")
        for i in range(len(dist)):
            if not vis[i] and dist[i] < min_dist:
                min_dist = dist[i]
                min_ver = i
        return min_ver

    def dijkstra(self, cost_mat, src):

        V = len(cost_mat)
        visited = [False]*V
        distance = [float("Inf")]*V
        distance[src] = 0

        # Calculating shortest possible distances for other vertices
        for _ in range(V):
            w = self.vertex_with_min_distance(distance, visited)
            visited[w] = True
            for v in range(V):
                if not visited[v]:
                    if cost_mat[w][v] > 0 and distance[v] > distance[w]+cost_mat[w][v]:
                        distance[v] = distance[w]+cost_mat[w][v]

        self.print_result(distance)


def input_matrix(n):
    mat = [0]*n
    for i in range(n):
        row = list(map(int, (input().split())))
        mat[i] = row
    return mat


if __name__ == "__main__":
    my_graph = Graph()

    g = [[0, 4, 0, 0, 0, 0, 0, 8, 0],
         [4, 0, 8, 0, 0, 0, 0, 11, 0],
         [0, 8, 0, 7, 0, 4, 0, 0, 2],
         [0, 0, 7, 0, 9, 14, 0, 0, 0],
         [0, 0, 0, 9, 0, 10, 0, 0, 0],
         [0, 0, 4, 14, 10, 0, 2, 0, 0],
         [0, 0, 0, 0, 0, 2, 0, 1, 6],
         [8, 11, 0, 0, 0, 0, 1, 0, 7],
         [0, 0, 2, 0, 0, 0, 6, 7, 0]
         ]

    n = int(input("Enter number of vertices : "))
    print("\nEnter your cost matrix (row-wise)")
    print("\nNOTE :- If there is no edge between vertices insert 0\n\n")
    cost_matrix = input_matrix(n)
    src = int(input("Enter your source vertices : (integer like 0,1,2,...) : "))
    my_graph.dijkstra(cost_matrix, src)

    # my_graph.dijkstra(g,0) example
