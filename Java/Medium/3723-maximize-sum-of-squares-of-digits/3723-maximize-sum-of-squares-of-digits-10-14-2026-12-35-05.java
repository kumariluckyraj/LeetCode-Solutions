class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num){
            return "";
        }
      StringBuilder sb = new StringBuilder(num);
      int nine = sum/9;
      for(int i=0; i<nine; i++){
        sb.append("9");
      }
     
      int rem= sum%9;
      
       if(sb.length()<num){
      sb.append(rem);
       }
      while(sb.length()<num){
 sb.append("0");
      }
     return sb.toString();
    }
}