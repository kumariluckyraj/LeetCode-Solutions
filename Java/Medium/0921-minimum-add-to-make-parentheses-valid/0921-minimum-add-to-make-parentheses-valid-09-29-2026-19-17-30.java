class Solution {
    public int minAddToMakeValid(String s) {
        int c=0;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
st.push(ch);
            }
            if(ch==')'){
                if(!st.isEmpty()){
                    st.pop();
                }else{
c++;
                }
            }
        }
        return c+st.size();
    }
}