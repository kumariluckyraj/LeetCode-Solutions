class Solution {
    int mod = 1000000007;
    long[] sum;
    long[] sq;
    long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int l = last[nums[i]] + 1;
            int r = i;

            update(0, 0, n - 1, l, r);

            ans = (ans + sq[0]) % mod;

            last[nums[i]] = i;
        }

        return (int) ans;
    }

    public void push(int node, int start, int end) {
        if (lazy[node] == 0) {
            return;
        }

        long val = lazy[node];
        long len = end - start + 1;

        sq[node] = (sq[node] + 2 * val * sum[node]
                    + val * val * len) % mod;

        sum[node] = (sum[node] + val * len) % mod;

        if (start != end) {
            lazy[node * 2 + 1] =
                (lazy[node * 2 + 1] + val) % mod;

            lazy[node * 2 + 2] =
                (lazy[node * 2 + 2] + val) % mod;
        }

        lazy[node] = 0;
    }

    public void update(int node, int start, int end,
                       int l, int r) {
        push(node, start, end);

        if (start > r || end < l) {
            return;
        }

        if (start >= l && end <= r) {
            lazy[node] = 1;
            push(node, start, end);
            return;
        }

        int mid = start + (end - start) / 2;

        update(node * 2 + 1, start, mid, l, r);
        update(node * 2 + 2, mid + 1, end, l, r);

        sum[node] = (sum[node * 2 + 1]
                    + sum[node * 2 + 2]) % mod;

        sq[node] = (sq[node * 2 + 1]
                   + sq[node * 2 + 2]) % mod;
    }
}