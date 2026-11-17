
class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();

        int[][] cost = new int[n][n];

        // Step 1: Precompute cost for every substring
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;

                cost[i][j] = Integer.MAX_VALUE;

                // Try every valid divisor
                for (int d = 1; d < len; d++) {
                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    // Compare characters in each group
                    for (int x = 0; x < d; x++) {
                        int left = i + x;
                        int right = i + x + ((len - 1) / d) * d;

                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }

        // Step 2: DP
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int p = 0; p <= k; p++) {
                dp[i][p] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;

        // Step 3: Partition into exactly k substrings
        for (int p = 1; p <= k; p++) {
            for (int i = 2 * p; i <= n; i++) {

                for (int j = 2 * (p - 1); j <= i - 2; j++) {

                    if (dp[j][p - 1] == Integer.MAX_VALUE) {
                        continue;
                    }

                    dp[i][p] = Math.min(
                        dp[i][p],
                        dp[j][p - 1] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
