
class Solution {
    class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int co=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(vis[i][j] != 1 && grid[i][j]=='1'){
                    vis[i][j] = 1;
                    q.add(new Pair(i,j));
                        co++;
                    while(!q.isEmpty()){
                        Pair curr = q.poll();
                        
                        int r = curr.row;
                        int c = curr.col;
                        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
                        for(int[] d: dir){
                            int nr = r +d[0];
                            int nc = c+d[1];
                            if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='1' && vis[nr][nc] !=1 ){
                                vis[nr][nc] =1 ;
                                q.add(new Pair(nr, nc));
                            }
                        }
                    }
                }
            }
        }
        return co;
    }
}