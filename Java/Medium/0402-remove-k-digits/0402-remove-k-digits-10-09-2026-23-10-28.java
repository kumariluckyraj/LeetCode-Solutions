class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num.length(); i++){
            char ch = num.charAt(i);
            while(sb.length()>0 && ch<sb.charAt(sb.length()-1) && k>0){
                      k--;
                      sb.deleteCharAt(sb.length()-1);
            }
            sb.append(ch);
        }
        while(k>0 && sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }

      int i=0;
      while(i<sb.length() && sb.charAt(i)=='0'){
        i++;
      }
      String s = sb.substring(i);
      if(s.length()>0){
               return s;
      }else{
        return "0";
      }
      
    }
}