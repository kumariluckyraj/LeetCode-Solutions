
import java.util.*;

class Solution {

    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    int leftSize = 0;
    int rightSize = 0;

    long leftSum = 0;
    long rightSum = 0;

    void addLeft(int num) {
        left.put(num, left.getOrDefault(num, 0) + 1);
        leftSize++;
        leftSum += num;
    }

    void addRight(int num) {
        right.put(num, right.getOrDefault(num, 0) + 1);
        rightSize++;
        rightSum += num;
    }

    void removeLeft(int num) {
        if (left.get(num) == 1) {
            left.remove(num);
        } else {
            left.put(num, left.get(num) - 1);
        }

        leftSize--;
        leftSum -= num;
    }

    void removeRight(int num) {
        if (right.get(num) == 1) {
            right.remove(num);
        } else {
            right.put(num, right.get(num) - 1);
        }

        rightSize--;
        rightSum -= num;
    }

    void balance() {

        int target = (leftSize + rightSize + 1) / 2;

        while (leftSize > target) {
            int num = left.lastKey();

            removeLeft(num);
            addRight(num);
        }

        while (leftSize < target) {
            int num = right.firstKey();

            removeRight(num);
            addLeft(num);
        }
    }

    void add(int num) {

        if (leftSize == 0 || num <= left.lastKey()) {
            addLeft(num);
        } else {
            addRight(num);
        }

        balance();
    }

    void remove(int num) {

        if (left.containsKey(num)) {
            removeLeft(num);
        } else {
            removeRight(num);
        }

        balance();
    }

    long getCost() {

        long median = left.lastKey();

        long a = median * leftSize - leftSum;
        long b = rightSum - median * rightSize;

        return a + b;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        long[] cost = new long[n - x + 1];

        // Step 1: Calculate cost of first window

        for (int i = 0; i < x; i++) {
            add(nums[i]);
        }

        cost[0] = getCost();

        // Step 2: Sliding window

        for (int i = 1; i <= n - x; i++) {

            remove(nums[i - 1]);

            add(nums[i + x - 1]);

            cost[i] = getCost();
        }

        // Step 3: Dynamic Programming

        long INF = Long.MAX_VALUE / 2;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {

            dp[i][0] = 0;

            for (int j = 1; j <= k; j++) {

                // Choice 1: Skip current element

                dp[i][j] = dp[i - 1][j];

                // Choice 2: Take a subarray of size x

                if (i >= x && dp[i - x][j - 1] != INF) {

                    long take = dp[i - x][j - 1] + cost[i - x];

                    dp[i][j] = Math.min(dp[i][j], take);
                }
            }
        }

        return dp[n][k];
    }
}
