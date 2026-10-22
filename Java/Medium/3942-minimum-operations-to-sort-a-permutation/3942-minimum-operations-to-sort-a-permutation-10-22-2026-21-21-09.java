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
      int c=0;
        int n = nums.length;
       
        for(int i = 0; i<n; i++){
            if(nums[i]>=nums[(i+1)%n]){
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