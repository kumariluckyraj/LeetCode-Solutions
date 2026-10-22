class Solution {
    public boolean check(int[] nums) {
      int c=0;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }
        if(set.size()==1){
            return true;
        }
        for(int i = 0; i<n; i++){
            if(nums[i]>nums[(i+1)%n]){
c++;
            }
        }
        if(c==1){
            return true;
        }else{
            return false;
        }
    }
}