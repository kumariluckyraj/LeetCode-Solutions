class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row= row;
            this.col=col;
        }
    }
    public int countIslands(int[][] grid, int k) {
        int count=0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                  if(grid[i][j]>0 && vis[i][j]!=true ){
                    q.add(new Pair(i,j));
                    vis[i][j] = true;
                     long sum =0;
                  
                 
                  while(!q.isEmpty()){
                  Pair curr = q.poll();
                  
                  int r = curr.row;
                  int c = curr.col;
                  sum += grid[r][c];
                  for(int[] d: dir){
                    int nr= r+d[0];
                    int nc= c+d[1];

                    if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]!=true && grid[nr][nc]>0){
                        q.add(new Pair(nr,nc));
                        vis[nr][nc]=true;
                    }
                  }
                  }
                  
                  if(sum%k==0){
                    count++;
                  }
                  }

            }
        }
        return count;
    }
}