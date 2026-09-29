class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";
      for(int i=0; i<s.length(); i++){
        char ch = s.charAt(i);
        if(ch=='('){
           
            if(!st.isEmpty()){
                ans += ch;
            }
             st.push(ch);
        }
        if(ch==')'){
            st.pop();
            if(!st.isEmpty()){
                ans += ch;
            }
        }
      }
      return ans;
    }
}