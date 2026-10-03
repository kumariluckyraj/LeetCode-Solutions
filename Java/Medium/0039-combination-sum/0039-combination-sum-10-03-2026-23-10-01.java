class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> lst = new ArrayList<>();
       return backtracking(candidates,target,lst,ans,0);
    }
      public List<List<Integer>> backtracking(int[] candidates, int target, List<Integer> lst, List<List<Integer>> ans, int i){
if(target==0){
    ans.add(new ArrayList<>(lst));
    return ans;
}
if(i==candidates.length||target<0){
    return ans;
}
lst.add(candidates[i]);
backtracking(candidates,target-candidates[i],lst,ans,i);
lst.remove(lst.size()-1);
backtracking(candidates,target,lst,ans,i+1);
return ans;
}
      
        
    
}