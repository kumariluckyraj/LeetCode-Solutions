class Solution {
    class Pair{

        int row;
        int col;
        int t;

        public Pair(int row, int col, int t){
            this.row = row;
            this.col = col;
            this.t = t;
        }
    }
   
    public int orangesRotting(int[][] grid) {
        int co=0;
        int time = 0;
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int fresh =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] != 1 && grid[i][j]==2){
                    vis[i][j] = 1;
                    q.add(new Pair(i,j,0));

                }

                if(grid[i][j] ==1){
                    fresh++;
                }
            }
        }

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int ti = curr.t;
            time = Math.max(time, ti);
            
            int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            for(int[] d: dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc] != 1 && grid[nr][nc]==1){
                    q.add(new Pair(nr,nc, ti+1));
                    vis[nr][nc] = 1;
                    fresh--;
                }
            }
        }
        if(fresh != 0){
            return -1;
        }else{
            return time;
        }
    }
}