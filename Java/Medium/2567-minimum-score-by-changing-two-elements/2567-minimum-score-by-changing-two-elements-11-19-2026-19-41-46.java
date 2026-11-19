class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
int n = nums.length;
        ans = Math.min(Math.abs(nums[2]-nums[n-1]),ans);
        ans = Math.min(Math.abs(nums[1]-nums[n-2]),ans);
        ans = Math.min(Math.abs(nums[0]-nums[n-3]),ans);
        return ans;
    }
}