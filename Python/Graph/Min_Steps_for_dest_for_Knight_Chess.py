def min_steps(src, dest, N):

    # we are already at target position
    if src == dest:
        return 0

    # initial position co-ordinates
    x1 = src[0]
    y1 = src[1]

    # target position co-ordinates
    x2 = dest[0]
    y2 = dest[1]

    # all possible moves for knight
    next_moves = [(-2, -1), (-2, 1), (-1, 2), (1, 2),
                  (2, 1), (2, -1), (1, -2), (-1, -2)]
    
    # array to keep track of knight, positions left to visit, and distance covered.
    visited = [[0 for j in range(N)] for i in range(N)]

    queue = []
    queue.append((x1,y1))

    while queue:
        curr = queue.pop(0)
        i = curr[0]
        j = curr[1]
        if i==x2 and j==y2:
            return visited[x2][y2]


        for k in next_moves:
            if is_valid(i+k[0], j+k[1], visited, N):
                visited[i+k[0]][j+k[1]] = visited[i][j] + 1
                queue.append((i+k[0], j+k[1]))
    return -1


def is_valid(i, j, vis, N):
    return (i >= 0 and i < N and j >= 0 and j < N and vis[i][j] == 0)


if __name__ == '__main__':
    N = int(input("Enter no. of row in chess board (Counting start from 1) : "))
    print("\nNOTE :- Enter x,y coordinates as space separated integers on same line.")
    print("\tFirst cell is (0,0)", "Last cell is",(N-1,N-1) )
    knightpos = tuple(map(int,input("\nEnter Knight's position : ").split()))
    targetpos = tuple(map(int,input("Enter target position : ").split()))

    print("\nMinimum steps from",knightpos,"to",targetpos," = ",min_steps(knightpos, targetpos, N))



