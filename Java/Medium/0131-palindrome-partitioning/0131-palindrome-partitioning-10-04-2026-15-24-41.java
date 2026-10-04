class Solution {
    public List<List<String>> partition(String s) {
    List<String> lst = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();
         return backtracking(s,0,lst,ans);
    }
    public List<List<String>> backtracking(String s, int i,List<String> lst, List<List<String>> ans){
        if(i==s.length()){
            ans.add(new ArrayList<>(lst));
            return ans;
        }
        for(int j=i; j<s.length(); j++){
            if(ispalindrome(s,i,j)){
                lst.add(s.substring(i,j+1));
                backtracking(s,j+1,lst,ans);
                lst.remove(lst.size()-1);

            }
        }
        return ans;

    }

    public boolean ispalindrome(String s,int i, int j){
        StringBuilder sb = new StringBuilder();
        String sub = s.substring(i,j+1);
        sb.append(sub);
        sb.reverse();
        if(sub.equals(sb.toString())){
            return true;
        }else{
            return false;
        }
    }
}