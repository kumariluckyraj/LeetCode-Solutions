
class Solution {
    public boolean isBipartite(int[][] graph) {
      int n = graph.length;
      Queue<Integer> q = new LinkedList<>();
      int[] color = new int[n];
      for(int i=0; i<n; i++){
        color[i] = -1;
      }

      for(int i=0; i<n; i++){
        if(color[i] == -1){
            color[i] = 0;
            q.add(i);

            while(!q.isEmpty()){
                int curr = q.poll();
                for(int j=0; j<graph[curr].length; j++){
                    int adjnode = graph[curr][j];
                    if(color[adjnode] == -1){
                        color[adjnode] = 1-color[curr];
                        q.add(adjnode);
                    }else{
                        if(color[adjnode] == color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
      }
      return true;
    }
}
