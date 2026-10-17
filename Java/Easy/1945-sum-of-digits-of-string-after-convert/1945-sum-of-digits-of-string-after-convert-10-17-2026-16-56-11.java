class Solution {
    public int getLucky(String s, int k) {
        String ans ="";
        int sum =0;
        int res =0;

         for(int i=0; i<s.length(); i++){
              int num = s.charAt(i)-'a'+1;
            ans += num;
         }
         for(int i=0; i<ans.length(); i++){
            res += (ans.charAt(i)-'0');
         }
k--;
         while( k!= 0){
           sum =0;
         while(res !=0 ){
            int rem = res%10;
            sum += rem;
            res = res/10;
           
         }
         
         res = sum;
         k--;

         }

         
return res;

    }
}