class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

int max = Integer.MIN_VALUE;
for(int i=0; i<nums.length; i++){
    if(nums[i]>max){
        max = Math.max(max,nums[i]);
    }
}
int start =1;
int end =max;

int ans =0;
while(start<=end){
    int total =0;
    int mid = start +(end-start)/2;
    for(int i=0; i<nums.length; i++){
total += Math.ceil((double)nums[i]/mid);
    }
if(total <= threshold){
ans = mid;
end = mid-1;
}else{
    start = mid+1;
}
}
return ans;
    }
}