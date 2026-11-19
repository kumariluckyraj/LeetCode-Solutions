class Solution {
    class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col= col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> q= new LinkedList<>();
        int n = image.length;
        int m = image[0].length;
        int[][] vis = new int[n][m];
int orignal= image[sr][sc];
                if(image[sr][sc] != color){
                    image[sr][sc] = color;
                    vis[sr][sc] = 1;
                    q.add(new Pair(sr,sc));

                    while(!q.isEmpty()){
                        Pair curr = q.poll();
                        int r = curr.row;
                        int c = curr.col;

                        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
                        for(int[] d: dir){
                            int nr = r +d[0];
                            int nc = c + d[1];
         if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc] != 1 && image[nr][nc] == orignal ){
                                image[nr][nc] = color;
                                vis[nr][nc]=1;
                                q.add(new Pair(nr,nc));
                            }
                        }
                    }
                }

           return image;
    }
}