class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        int c = 0;

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && vis[i][j] == 0) {

                    c++;

                    q.add(new Pair(i, j));
                    vis[i][j] = 1;

                    // BFS
                   
                

                 while (!q.isEmpty()) {

                        Pair curr = q.poll();

                        int r = curr.row;
                        int col = curr.col;

                        for (int[] d : dir) {

                            int nr = r + d[0];
                            int nc = col + d[1];

                            if (nr >= 0 && nr < n &&
                                nc >= 0 && nc < m &&
                                grid[nr][nc] == '1' &&
                                vis[nr][nc] == 0) {

                                q.add(new Pair(nr, nc));
                                vis[nr][nc] = 1;
                            }
                        }
                    }
                }
            }
        }

        return c;
    }
}