
import java.util.*;

class Solution {
    int[] tin, tout, depth;
    int[][] up;
    int timer;
    int LOG;
    int[] bit;
    int[] parent;
    int[] nodeMask;

    void dfs(int u, int p, List<Integer>[] adj) {
        parent[u] = p;
        up[0][u] = p;
        tin[u] = ++timer;

        for (int j = 1; j < LOG; j++) {
            up[j][u] = up[j - 1][up[j - 1][u]];
        }

        for (int v : adj[u]) {
            if (v == p) continue;

            depth[v] = depth[u] + 1;
            dfs(v, u, adj);
        }

        tout[u] = timer;
    }

    void updateBIT(int i, int val) {
        while (i < bit.length) {
            bit[i] ^= val;
            i += i & -i;
        }
    }

    int queryBIT(int i) {
        int ans = 0;

        while (i > 0) {
            ans ^= bit[i];
            i -= i & -i;
        }

        return ans;
    }

    void rangeUpdate(int l, int r, int val) {
        updateBIT(l, val);
        updateBIT(r + 1, val);
    }

    int getPrefixMask(int u) {
        return queryBIT(tin[u]);
    }

    int lift(int u, int k) {
        for (int j = 0; j < LOG; j++) {
            if ((k & (1 << j)) != 0) {
                u = up[j][u];
            }
        }
        return u;
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        u = lift(u, depth[u] - depth[v]);

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return parent[u];
    }

    public List<Boolean> palindromePath(
        int n, int[][] edges, String s, String[] queries
    ) {
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        up = new int[LOG][n];
        parent = new int[n];
        nodeMask = new int[n];
        bit = new int[n + 2];

        for (int i = 0; i < n; i++) {
            nodeMask[i] = 1 << (s.charAt(i) - 'a');
        }

        dfs(0, 0, adj);

        // Initialize root-to-node XOR masks.
        for (int u = 0; u < n; u++) {
            rangeUpdate(tin[u], tout[u], nodeMask[u]);
        }

        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int newMask = 1 << (c - 'a');
                int delta = nodeMask[u] ^ newMask;

                rangeUpdate(tin[u], tout[u], delta);
                nodeMask[u] = newMask;

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int w = lca(u, v);

                int mask = getPrefixMask(u)
                         ^ getPrefixMask(v)
                         ^ nodeMask[w];

                answer.add(mask == 0 || (mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }
}
