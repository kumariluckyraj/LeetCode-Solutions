class Solution {
    public int[] frequencySort(int[] nums) {
      HashMap<Integer, Integer> map = new HashMap<>();
      ArrayList<Integer> lst = new ArrayList<>();
      for(int i=0; i<nums.length; i++){
         lst.add(nums[i]);
        map.put(nums[i], map.getOrDefault(nums[i],0)+1);
      } 
Collections.sort(lst, (a,b)->{
    if(!map.get(a).equals(map.get(b))){
  return  map.get(a)-map.get(b);
    }else{
       return b-a;
    }
});
for(int i=0; i<lst.size(); i++){
    nums[i] = lst.get(i);
}
return nums;
    }
}