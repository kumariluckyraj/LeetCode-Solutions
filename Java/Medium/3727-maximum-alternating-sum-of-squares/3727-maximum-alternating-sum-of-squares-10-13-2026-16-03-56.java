class Solution {
    public long maxAlternatingSum(int[] nums) {
        ArrayList<Integer> lst = new ArrayList<>();
             for(int i=0; i<nums.length; i++){
        nums[i] = Math.abs(nums[i]);

      }
        Arrays.sort(nums);
        int m =0;
        int n = nums.length-1;
        while(m<=n){
            int temp = nums[m];
            nums[m] = nums[n];
            nums[n] = temp;
            m++;
            n--;
        }

        int i=0;
        int j = nums.length-1;
        long score=0;
        int l=0;
      while(i<=j){
                if(l%2==0){
                     lst.add(nums[i]);
                     i++;
                }else{
                    lst.add(nums[j]);
                    j--;
                } 
                l++;     
      }
 
      int k=0;
      while(k<lst.size()){
        if(k%2==0){
score += ((long)lst.get(k)*lst.get(k));
        }else{
            score -= ((long)lst.get(k)*lst.get(k));
        }
 
 k++;
      }

        return score;
    }
}