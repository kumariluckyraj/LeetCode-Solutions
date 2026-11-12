class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int len= Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            ArrayList<Integer> lst = new ArrayList<>();
          
             ArrayList<Integer> lst3 = new ArrayList<>();
             TreeSet<Integer> set = new TreeSet<>();
            for(int j=i; j<nums.length; j++){
                
              
                lst3.add(nums[j]);
                set.add(nums[j]);
                ArrayList<Integer> temp = new ArrayList<>(set);
                lst.addAll(set);
               
                Collections.reverse(lst);
                if(temp.equals(lst3)||lst.equals(lst3)){
                   len = Math.max(len,lst3.size());
                }
                lst.clear();
               
            }
        }
        return len;
    }
}