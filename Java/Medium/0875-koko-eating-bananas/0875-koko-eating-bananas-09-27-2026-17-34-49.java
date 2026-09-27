class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
     
        for(int i=0;i<piles.length;i++){
            if(piles[i]>max){
                max = piles[i];
            }

        }
int start = 1;
int end = max;
int ans =0;
while(start<=end){
    int total =0;
    int mid = start +(end-start)/2;
    for(int i=0;i<piles.length;i++){
total += Math.ceil((double)piles[i]/mid);
    }

    if(total<=h){
ans = mid;
end = mid-1;
    }else{
        start = mid+1;
    }

}

return ans;

    }  
    
}