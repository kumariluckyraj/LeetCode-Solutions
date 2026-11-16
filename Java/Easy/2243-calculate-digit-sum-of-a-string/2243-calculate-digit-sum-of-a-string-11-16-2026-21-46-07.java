class Solution {
    public String digitSum(String s, int k) {
        
        while(s.length()>k){
             StringBuilder sb2 = new StringBuilder();
            for(int i=0; i<s.length(); i+=k){
                StringBuilder sb = new StringBuilder();
                int j =i;
                while(sb.length()<k && j<s.length()){
                    sb.append(s.charAt(j));
                    j++;
                }
                String st = sb.toString();
                int sum =0;
                for(int l=0; l<st.length(); l++){
                    sum += st.charAt(l)-'0';
                }
               
                sb2.append(sum);
            }
            s= sb2.toString();

        }
        return s;
    }
}