
class Solution {

    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        int LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Find next greater element on the right
        int[] next = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {

            while (top >= 0 && nums[stack[top]] <= nums[i]) {
                top--;
            }

            if (top >= 0) {
                next[i] = stack[top];
            } else {
                next[i] = n;
            }

            stack[++top] = i;
        }

        // Binary lifting
        int[][] up = new int[LOG][n];
        long[][] cost = new long[LOG][n];

        for (int i = 0; i < n; i++) {

            up[0][i] = next[i];

            cost[0][i] = (long) nums[i] * (next[i] - i)
                       - (prefix[next[i]] - prefix[i]);
        }

        for (int j = 1; j < LOG; j++) {

            for (int i = 0; i < n; i++) {

                int mid = up[j - 1][i];

                if (mid < n) {
                    up[j][i] = up[j - 1][mid];

                    cost[j][i] = cost[j - 1][i]
                               + cost[j - 1][mid];
                } else {
                    up[j][i] = n;
                }
            }
        }

        // Sliding window
        int right = 0;
        long ans = 0;

        for (int left = 0; left < n; left++) {

            while (right + 1 < n &&
                   getCost(left, right + 1, nums, prefix, up, cost, LOG) <= k) {

                right++;
            }

            ans += right - left + 1;
        }

        return ans;
    }

    public long getCost(int left, int right, int[] nums,
                        long[] prefix, int[][] up,
                        long[][] cost, int LOG) {

        long ans = 0;
        int cur = left;

        for (int j = LOG - 1; j >= 0; j--) {

            int nxt = up[j][cur];

            if (nxt <= right) {
                ans += cost[j][cur];
                cur = nxt;
            }
        }

        ans += (long) nums[cur] * (right - cur + 1)
             - (prefix[right + 1] - prefix[cur]);

        return ans;
    }
}
