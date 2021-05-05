def find_degree(adj_mat,ver):
    V = len(adj_mat)
    deg = 0
    for i in range(V):
        if adj_mat[ver][i] == 1:
            deg += 1
    return deg




def main():
    V = int(input("Enter number of vertices : "))
    adj_mat = []
    print("Enter your adjacency matrix (row-wise) : ")
    for i in range(V):
        row = list(map(int, input().split()))
        adj_mat.append(row)
    ver = int(input("\nEnter the vertex to know about it's degree : "))
    if ver < (V-1) and ver >= 0:
        print("\nDegree of",ver,"is : ",find_degree(adj_mat,ver))
    else:
        print("\nGiven vertex",ver,"doesn't exist!")

if __name__ == "__main__":
    main()


