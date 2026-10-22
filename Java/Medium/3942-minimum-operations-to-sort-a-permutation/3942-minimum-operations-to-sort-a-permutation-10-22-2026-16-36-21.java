class Solution {

 public int minOperations(int[] nums) {
    int c = Integer.MAX_VALUE;
       boolean isdecreasing = false;
int n = nums.length;
       int minidx =0;
 for(int i=0; i<nums.length; i++){
             if(nums[i]==0){
                minidx =i;
             }
        }
  boolean increasing = isincreasing(nums);
    if(increasing==false){
       int i=0;
       int j = n-1;
       while(i<=j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
        i++;
        j--;
       }
        isdecreasing = isincreasing(nums);
minidx = nums.length-minidx-1;

    }

if(!increasing && !isdecreasing){
    return -1;
}
if(increasing){
c = Math.min(minidx, 2+n-minidx);
}
if(isdecreasing){
    c = Math.min(minidx+1, 1+n-minidx);
}
 return c;
 }

 public boolean isincreasing(int[] nums){
    int n = nums.length;
   int minidx =0;
    for(int i=0; i<nums.length; i++){
             if(nums[i]==0){
                minidx =i;
             }
        }
    int i;
        for (i = minidx; i < minidx + n; ++i) {
            if (nums[(i + 1) % n] - 1 != nums[i % n]) {
                break;
            }
        }
        if ((i + 1) % n == minidx) {
            return true;
        }
        return false;
    
 }
   
}