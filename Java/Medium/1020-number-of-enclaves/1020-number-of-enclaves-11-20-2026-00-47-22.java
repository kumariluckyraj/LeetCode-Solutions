class Solution {
    class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int co=0;

        for(int i=0; i<n; i++){
             if(vis[i][0] != 1 && grid[i][0]==1){
                vis[i][0] =1;
                q.add(new Pair(i,0));
             }

             if(vis[i][m-1] != 1 && grid[i][m-1]==1){
                vis[i][m-1]=1;
                q.add(new Pair(i,m-1));
             }
            
        }

        for(int j=0; j<m; j++){
            if(vis[0][j] != 1 && grid[0][j] == 1){
                vis[0][j] =1;
                q.add(new Pair(0,j));
            }

             if(vis[n-1][j] != 1 && grid[n-1][j] == 1){
                vis[n-1][j] =1;
                q.add(new Pair(n-1,j));
            }

        }

        

                    while(!q.isEmpty()){
                        Pair curr = q.poll();
                        int r = curr.row;
                        int c = curr.col;

                        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
                        for(int[] d: dir){
                            int nr = r+d[0];
                            int nc = c+d[1];
                            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc] != 1 && grid[nr][nc]==1){
                                vis[nr][nc] = 1;
                                q.add(new Pair(nr, nc));
                            }
                        }
                    }
                
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(vis[i][j] != 1 && grid[i][j]==1){
                        co++;
                    }
                }
            }
        return co;
    }
}