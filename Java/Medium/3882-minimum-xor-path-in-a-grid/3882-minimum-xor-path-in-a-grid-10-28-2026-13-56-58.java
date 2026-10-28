class Solution {
    class Pair{
        int row;
        int col;
        int sum;

        public Pair(int row, int col,int sum){
            this.row=row;
            this.col=col;
            this.sum = sum;
        }
}

    public int minCost(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
      
       Queue<Pair> q = new LinkedList<>();
       boolean[][][] vis = new boolean[n][m][1024];
            
q.add(new Pair(0,0,grid[0][0]));
vis[0][0][grid[0][0]]=true;
int ans = Integer.MAX_VALUE;
while(!q.isEmpty()){
Pair curr = q.poll();

int r = curr.row;
int c = curr.col;
int sum = curr.sum;

if(r==n-1 && c == m-1){
ans = Math.min(ans,sum);
continue;
}

int[][] dir = {{1,0},{0,1}};
for(int[] d: dir){
  int  nr = r+d[0];
  int  nc= c+d[1];
 
    if(nr>=0 && nr<n && nc>=0 && nc<m ){
         int newsum = sum ^ grid[nr][nc];
         if(vis[nr][nc][newsum]!=true){
        q.add(new Pair(nr,nc,sum^grid[nr][nc]));
        vis[nr][nc][newsum] = true;
         }
       
    }
}
}

return ans;
    }
}