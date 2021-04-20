class Graph:

    graph_dict = {}

    def add_edges(self,node,neighbour):
        if node in self.graph_dict:
            self.graph_dict[node].append(neighbour)
        else:
            self.graph_dict[node] = [neighbour]

    def show_edges(self):
        for node in self.graph_dict:
            for neighbour in self.graph_dict[node]:
                print(node,"->",neighbour)

    def find_path(self,start,end,path=[]):
    
        path = path + [start]
        if start == end:
            return path
        else:
            if start in self.graph_dict:
                for node in self.graph_dict[start]:
                    if node not in path:
                        new_path = self.find_path(node,end,path)
                        if new_path:
                            return new_path
            return None
        
    def find_all_path(self,start,end,path=[]):
        
        path = path + [start]
        if start == end:
            print(path)
        else:
            if start in self.graph_dict:
                for node in self.graph_dict[start]:
                    if node not in path:
                        self.find_all_path(node,end,path)
            return None

    def dfs(self,v):
        stack = []
        visited = set()
        traversed = []

        stack.append(v)
        while stack:
            v = stack.pop()
            traversed.append(v)
            if v not in visited:
                visited.add(v)
                if v in self.graph_dict:
                    for w in self.graph_dict[v][::-1]:
                        if w not in visited:
                            stack.append(w)
        return traversed 

    def dfs_rec(self,v,visited=set()):
        visited.add(v)
        print(v,end=" ")
        if v in self.graph_dict:
            for w in self.graph_dict[v]:
                if w not in visited:
                    self.dfs_rec(w,visited)

    def bfs(self,v):
        queue = []
        visited = set()
        traversed = []

        queue.append(v)
        while queue:
            v = queue.pop(0)
            traversed.append(v)

            if v in self.graph_dict:
                for w in self.graph_dict[v]:
                    if w not in visited:
                        queue.append(w)
                        visited.add(w)
        return traversed


my_graph = Graph() 
my_graph.add_edges(1,2)
my_graph.add_edges(1,3)
my_graph.add_edges(1,4)      
my_graph.add_edges(2,5)
my_graph.add_edges(2,6)
my_graph.add_edges(3,6)


my_graph.show_edges()

print("\nAll Path from 1 to 6 :-")
my_graph.find_all_path(1,6)

print("\nBFS Path : ",my_graph.bfs(1))

