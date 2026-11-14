class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.size(); i++){
            int sum =0;
            List<Integer> lst = new ArrayList<>();
            for(int j=i; j<nums.size(); j++){
                  lst.add(nums.get(j));
                  sum += nums.get(j);
                  if(lst.size()>=l && lst.size()<=r && sum > 0){
                      ans = Math.min(ans, sum);
                  }
            }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}