class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
       return backtrack(nums,ls,ans,0);
    }

    public List<List<Integer>> backtrack(int[] nums, List<Integer> ls, List<List<Integer>> ans,int index){
        if(index==nums.length){
            ans.add(new ArrayList<>(ls));
            return ans;
        }
ls.add(nums[index]);
        backtrack(nums,ls,ans,index+1);
        ls.remove(ls.size()-1);
        backtrack(nums,ls,ans,index+1);
        return ans;
    }
}