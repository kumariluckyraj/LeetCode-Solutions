class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int[] arr = new int[n];
    for(int i=0; i<nums.length; i++){
       
              arr[(k+i)%n] =nums[i];

        
      
    }
    for(int i=0; i<nums.length; i++){
            nums[i] = arr[i];
    }
    }
} 