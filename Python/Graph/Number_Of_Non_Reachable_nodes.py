class Graph:

    def __init__(self, V):
        self.V = V
        self.graph_dict = {}
        self.adj_mat = [[0 for j in range(self.V)] for i in range(self.V)]

    def __str__(self):
        return str(self.graph_dict)

    #############  Method-1 Using Python Dictionary  ########################

    # since for undirected graph if there is edge from 0 to 1
    # it means there's also an edge from 1 to 0
    def add_edges(self, node, neighbour):
        if (node in self.graph_dict) and (neighbour in self.graph_dict):
            self.graph_dict[node].append(neighbour)
            self.graph_dict[neighbour].append(node)

        elif (node not in self.graph_dict) and (neighbour in self.graph_dict):
            self.graph_dict[node] = [neighbour]
            self.graph_dict[neighbour].append(node)

        elif (node in self.graph_dict) and (neighbour not in self.graph_dict):
            self.graph_dict[node].append(neighbour)
            self.graph_dict[neighbour] = [node]

        elif (node not in self.graph_dict) and (neighbour not in self.graph_dict):
            self.graph_dict[node] = [neighbour]
            self.graph_dict[neighbour] = [node]

    def dfs_dict(self, v, visited):
        visited[v] = True
        if v in self.graph_dict:
            for w in self.graph_dict[v]:
                if not visited[w]:
                    self.dfs_dict(w, visited)
        return visited

    #############  Method-2 Using Adjacency Matrix  ########################

    def create_adj_mat(self, node, neighbour):
        self.adj_mat[node][neighbour] = 1
        self.adj_mat[neighbour][node] = 1

    def dfs_adj(self, v, visited):
        for i in range(self.V):
            if not visited[i]:
                if self.adj_mat[v][i] == 1 or v == i:
                    visited[i] = True
                    self.dfs_adj(i, visited)

    # function that count un reachable nodes
    def count_non_reachable(self, v):
        visited = [False]*self.V

        if not visited[v]:
            # self.dfs_adj(v,visited) replace below line by this to use Method-2
            self.dfs_dict(v, visited)  # Using Method-1

        count = 0
        for i in range(self.V):
            if not visited[i]:
                count += 1
        return count


if __name__ == "__main__":

    # uncomment below lines & comment rest to run directly with pre-defined example
    # my_graph = Graph(8)
    # my_graph.add_edges(0, 1)
    # my_graph.add_edges(0, 2)
    # my_graph.add_edges(1, 2)
    # my_graph.add_edges(3, 4)
    # my_graph.add_edges(4, 5)
    # my_graph.add_edges(6, 7)
    # print("\nNumber of non-reachable nodes : ",my_graph.count_non_reachable(0))

    n = int(input("Enter number of vertices : "))
    my_graph = Graph(n)
    print("\nEnter edges :- ")
    print("NOTE :- If there is edge from 0 to 1 enter 0 1. Enter 'N' or 'n' when all edges are entered :-\n")
    while True:
        edge = input().split()
        if edge == ['N'] or edge == ['n']:
            break
        edge = list(map(int, edge))
        my_graph.add_edges(edge[0], edge[1])  # Method-1
        # my_graph.create_adj_mat(edge[0], edge[1]) # Method-2

    print("\nNumber of non-reachable nodes : ",my_graph.count_non_reachable(0))
