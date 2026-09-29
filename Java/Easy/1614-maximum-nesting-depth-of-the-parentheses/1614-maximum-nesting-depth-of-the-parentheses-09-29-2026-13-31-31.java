class Solution {
    public int maxDepth(String s) {
        int c=0;
      int max = 0;
       for(int i=0; i<s.length(); i++){
        char ch = s.charAt(i);
        if(ch=='('){
          c++;
          max = Math.max(max, c);
        }
        if(ch==')'){
          c--;
        }
       }
       return max;
    }
}