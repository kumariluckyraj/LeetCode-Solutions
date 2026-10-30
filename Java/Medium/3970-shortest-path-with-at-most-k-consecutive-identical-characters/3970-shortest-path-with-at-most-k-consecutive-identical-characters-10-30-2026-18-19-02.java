class Solution {
    class Pair{
        int node;
        int w;

        public Pair(int node, int w){
            this.node = node;
            this.w = w;
        }
    }

    class Tuple{
        int count;
        int node;
        int w;

        public Tuple(int count, int node, int w){
            this.count = count;
            this.node = node;
            this.w = w;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        ArrayList<ArrayList<Pair>> lst = new ArrayList<>();
        for(int i=0; i<n; i++){
            lst.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            lst.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
        
        int[][] dist = new int[n][k+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], (int)1e9);
        }

       PriorityQueue<Tuple> q = new PriorityQueue<>(
    (a,b) -> Integer.compare(a.w, b.w)
);
     dist[0][1] = 0;
q.add(new Tuple(1, 0, 0));

        while(!q.isEmpty()){
            Tuple curr = q.poll();
           
            for(Pair adj: lst.get(curr.node)){
                int count;
                if(labels.charAt(curr.node)==labels.charAt(adj.node)){
                    count = curr.count+1;
                }else{
                    count =1;
                }
                if(count<=k && curr.w+adj.w<dist[adj.node][count] ){
                    dist[adj.node][count] = curr.w+adj.w;
                    
                    q.add(new Tuple(count,adj.node,adj.w+curr.w));
                }

            }
        }
       
        int ans = (int)1e9;
       for(int i=1; i<=k; i++){
        ans = Math.min(ans, dist[n-1][i]);
       }

        if(ans == (int)1e9) {
            return -1;
        }

        return ans;
    }
}