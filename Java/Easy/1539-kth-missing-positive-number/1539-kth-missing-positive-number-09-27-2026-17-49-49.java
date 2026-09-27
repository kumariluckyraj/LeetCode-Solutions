class Solution {
    public int findKthPositive(int[] arr, int k) {

     int current =1;
     int[] num = new int[k];
     int idx=0;
     int i=0;
     while(idx<k){
        if(i<arr.length && arr[i]==current){
            i++;
        }else{
            num[idx]=current;
            idx++;
        }
        current++;
     }
     return num[k-1];
    }
}