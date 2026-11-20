import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            int a = dp.getOrDefault(x - 1, 0) + 1;
            int b = dp.getOrDefault(x, 0) + 1;

            dp.put(x, a);
            dp.put(x + 1, b);

            ans = Math.max(ans, Math.max(a, b));
        }

        return ans;
    }
}