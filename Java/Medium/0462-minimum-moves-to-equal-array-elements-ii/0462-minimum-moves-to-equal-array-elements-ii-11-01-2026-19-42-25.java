class Solution {
    public int minMoves2(int[] nums) {
         Arrays.sort(nums);
         int n =  nums.length;
         int mid = n/2;
         int num = nums[mid];
         int ans =0;

         for(int i=0; i<n; i++){
ans += Math.abs(num-nums[i]);
         }
         return ans;
    }
}