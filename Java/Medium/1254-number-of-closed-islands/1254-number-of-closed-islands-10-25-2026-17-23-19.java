class Solution {
    class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int closedIsland(int[][] grid) {
       Queue<Pair> q = new LinkedList<>();
       int n = grid.length;
int m = grid[0].length;
       boolean[][] vis = new boolean[n][m];
       int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
       int count=0;

for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
        if(grid[i][j]==0 && vis[i][j]!= true){
        q.add(new Pair(i,j));
        vis[i][j] = true;
        boolean closed = true;
       
        
    
    while(!q.isEmpty()){
        Pair curr = q.poll();

        int r = curr.row;
        int c= curr.col;
        if(r==0 || r==n-1 || c==0 || c==m-1 ){
            closed=false;
        }
        for(int[] d:dir){
                  int nr = r+d[0];
                  int nc = c+d[1];
                  if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]!=true && grid[nr][nc]==0){
q.add(new Pair(nr,nc));
vis[nr][nc] = true;
                  }

        }
    }
        if(closed == true){
            count++;
        }
    }
        }
}

return count;
      
    }
}