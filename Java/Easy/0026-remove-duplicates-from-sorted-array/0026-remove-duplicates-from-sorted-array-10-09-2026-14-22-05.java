class Solution {
    public int removeDuplicates(int[] nums) {

     HashSet<Integer> set = new HashSet<>();
     for(int i=0; i<nums.length; i++){
        set.add(nums[i]);
     }
     ArrayList<Integer> lst = new ArrayList<>();
     lst.addAll(set);
     Collections.sort(lst);
     int[] arr = new int[set.size()];
     for(int i=0; i<set.size(); i++){
        arr[i]= lst.get(i);
     }
    Arrays.sort(arr);
    for(int i=0; i<arr.length; i++){
        nums[i]= arr[i];
     }
    return arr.length;
    }
}