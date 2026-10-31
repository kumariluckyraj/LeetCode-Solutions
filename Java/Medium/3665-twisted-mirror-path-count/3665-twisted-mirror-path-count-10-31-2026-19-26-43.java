
class Solution {
    public int uniquePaths(int[][] grid) {
        int mod = 1000000007;
        int n = grid.length;
        int m = grid[0].length;

        long[][] dp = new long[n][m];
        dp[0][0] = 1;

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {

                if(dp[r][c] == 0) {
                    continue;
                }

                // Right and Down
                int[][] dir = {{0,1}, {1,0}};

                for(int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    while(nr < n && nc < m &&
                          grid[nr][nc] == 1) {

                        if(d[0] == 0) {
                            nr++;
                            d = new int[]{1,0};
                        } else {
                            nc++;
                            d = new int[]{0,1};
                        }
                    }

                    if(nr < n && nc < m) {
                        dp[nr][nc] =
                            (dp[nr][nc] + dp[r][c]) % mod;
                    }
                }
            }
        }

        return (int)dp[n-1][m-1];
    }
}
