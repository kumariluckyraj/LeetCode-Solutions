class Solution {
    public String removeOuterParentheses(String s) {
       int c=0;
       String st = "";
       for(int i=0;i<s.length(); i++){
        char ch = s.charAt(i);
        if(ch=='('){
            if(c!=0){
                st+=ch;
            }
            c++;
        }else{
            c--;
            if(c!=0){
                st+=ch;
            }
        }
       }
       return st;
    }
}