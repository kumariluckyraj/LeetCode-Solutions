
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {

            int factor = items[i][0];
            int price = items[i][1];

            int cnt = 0;

            for (int j = 0; j < n; j++) {
                if (items[j][0] % factor == 0) {
                    cnt++;
                }
            }

            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + cnt);
            }
        }

        int ans = 0;

        for (int i = 0; i <= budget; i++) {
            int extra = (budget - i) / minPrice;

            ans = Math.max(ans, dp[i] + extra);
        }

        return ans;
    }
}
