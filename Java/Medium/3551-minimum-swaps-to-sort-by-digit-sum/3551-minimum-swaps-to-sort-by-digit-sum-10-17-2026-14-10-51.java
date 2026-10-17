class Solution {
    public int minSwaps(int[] nums) {
        ArrayList<Integer> lst = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum =0;
        int c=0;
        for(int i=0; i<nums.length; i++){
            int orignal = nums[i];
            int num = nums[i];
         
           sum = 0;
while(num !=0){
       int rem = num%10;
    sum += rem;
    num = num/10;
}
map.put(orignal,sum);
lst.add(orignal);
        }
Collections.sort(lst, (a,b) -> {
    if(!map.get(a).equals(map.get(b))){
      return  map.get(a)-map.get(b);
    }else{
        return a-b;
    }
});
int n = 0;
HashMap<Integer, Integer> map2 = new HashMap<>();
for(int i=0; i<nums.length; i++){
    map2.put(nums[i], i);
}
for(int i=0; i<nums.length; i++){
    if(nums[i]!= lst.get(i)){
       n= map2.get(lst.get(i));
        int temp = nums[i];
        nums[i]=nums[n];
        nums[n]=temp;
        c++;
map2.put(nums[n],n);
map2.put(nums[i], i);
    }
}
return c;
    }
}