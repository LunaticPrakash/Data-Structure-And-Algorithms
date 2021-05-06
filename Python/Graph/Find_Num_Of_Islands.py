def num_islands(grid):

    if not grid:
        return 0
    row = len(grid)
    col = len(grid[0])
    visited = [[False for j in range(col)]for i in range(row)]
    count = 0
    for i in range(row):
        for j in range(col):
            if visited[i][j] == False and grid[i][j] == 1:
                dfs(i, j, visited, grid)
                count += 1
    return count


def dfs(row, col, vis, grid):
    vis[row][col] = True

    # neighbours - 4 diagonal and 2 vertical and 2 horizontal elements
    neighb = [(-1, 0), (-1, 1), (0, 1), (1, 1),
              (1, 0), (1, -1), (0, -1), (-1, -1)]

    for k in neighb:
        if is_safe((row+k[0]), (col+k[1]), vis, grid): # check if neighbours are safe and valid to visit
            dfs(row+k[0], col+k[1], vis, grid)


def is_safe(i, j, vis, grid):
    return (i >= 0 and i < len(grid) and j >= 0 and j < len(grid[0]) and vis[i][j] == False and grid[i][j] == 1)


graph1 = [[1, 1, 0, 0, 0],
          [0, 1, 0, 0, 1],
          [1, 0, 0, 1, 1],
          [0, 0, 0, 0, 0],
          [1, 0, 1, 0, 1]]

graph2 = [[0, 1, 1, 1, 0, 0, 0],
          [0, 0, 1, 1, 0, 1, 0]]

print("\nNumber of islands = ", num_islands(graph1))
