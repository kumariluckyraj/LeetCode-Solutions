
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n + 1];
        int[] suffMin = new int[n + 1];
        int[] prefDrop = new int[n];

        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
        }

        suffMin[n] = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }

        for (int i = 1; i < n; i++) {
            prefDrop[i] = prefDrop[i - 1];

            if (nums[i - 1] > nums[i]) {
                prefDrop[i]++;
            }
        }

        int num = 1;
        int ans = 0;

        while (num <= n / num) {
            if (n % num == 0) {
                int k = num;

                if (check(nums, prefMax, suffMin, prefDrop, k)) {
                    ans += k;
                }

                int other = n / num;

                if (other != k) {
                    if (check(nums, prefMax, suffMin, prefDrop, other)) {
                        ans += other;
                    }
                }
            }

            num++;
        }

        return ans;
    }

    public boolean check(int[] nums, int[] prefMax,
                         int[] suffMin, int[] prefDrop, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i += k) {
            int end = i + k - 1;

            int c = prefDrop[end] - prefDrop[i];

            if (nums[end] > nums[i]) {
                c++;
            }

            if (c > 1 || prefMax[i] > suffMin[i]) {
                return false;
            }
        }

        return true;
    }
}
