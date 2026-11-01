class Solution {
    public int minMoves(int[] nums) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
int c=0;
    for(int i=0; i<nums.length; i++){
    min = Math.min(min, nums[i]);
    max = Math.max(max, nums[i]);
    }
   
   for(int i=0; i<nums.length; i++){
    c += (nums[i]-min);
   }
return c;


    }
}