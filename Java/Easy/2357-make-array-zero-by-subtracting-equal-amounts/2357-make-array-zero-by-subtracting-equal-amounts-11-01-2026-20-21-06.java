class Solution {
    public int minimumOperations(int[] nums) {
       HashMap<Integer, Integer> map = new HashMap<>();
       int c=0;
       for(int i=0; i<nums.length; i++){
        map.put(nums[i], map.getOrDefault(nums[i],0)+1);
       }
for(int num: map.keySet()){
if(num !=0){
    c++;
}
}
return c;
    }
}