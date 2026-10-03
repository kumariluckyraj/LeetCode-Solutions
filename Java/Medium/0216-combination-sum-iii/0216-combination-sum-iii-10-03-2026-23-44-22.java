class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> lst = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        return backtracking(k,n,1,lst,ans);
    }
    public List<List<Integer>> backtracking(int k, int n, int i,List<Integer> lst, List<List<Integer>> ans){
        if(n == 0 && lst.size()==k){
           ans.add(new ArrayList<>(lst));
           return ans;
        }
        if(i>9||n<0){
            return ans;
        }
lst.add(i);
backtracking(k,n-i,i+1,lst,ans);
lst.remove(lst.size()-1);
backtracking(k,n,i+1,lst,ans);
return ans;
    }
}