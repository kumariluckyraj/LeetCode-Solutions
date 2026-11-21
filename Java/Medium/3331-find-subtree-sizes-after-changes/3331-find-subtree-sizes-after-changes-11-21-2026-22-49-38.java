
class Solution {
    ArrayList<ArrayList<Integer>> adj;
    int[] ans;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }

        ArrayList<ArrayList<Integer>> newAdj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            newAdj.add(new ArrayList<>());
        }

        int[] last = new int[26];
        Arrays.fill(last, -1);

        dfs(0, adj, newAdj, last, s, parent);

        ans = new int[n];

        dfs2(0, newAdj);

        return ans;
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                    ArrayList<ArrayList<Integer>> newAdj,
                    int[] last, String s, int[] parent) {

        int ch = s.charAt(node) - 'a';

        int old = last[ch];

        int newParent = parent[node];

        if (old != -1) {
            newParent = old;
        }

        if (newParent != -1) {
            newAdj.get(newParent).add(node);
        }

        last[ch] = node;

        for (int child : adj.get(node)) {
            dfs(child, adj, newAdj, last, s, parent);
        }

        last[ch] = old;
    }

    public int dfs2(int node, ArrayList<ArrayList<Integer>> adj) {
        int size = 1;

        for (int child : adj.get(node)) {
            size += dfs2(child, adj);
        }

        ans[node] = size;

        return size;
    }
}
