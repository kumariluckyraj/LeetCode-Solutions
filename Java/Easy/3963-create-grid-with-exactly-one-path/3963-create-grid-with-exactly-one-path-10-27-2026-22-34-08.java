class Solution {
    public String[] createGrid(int m, int n) {
        
        String[] ans = new String[m];
        int j=n;
        for(int i=0; i<m; i++){
            if(i==0){
                StringBuilder one= new StringBuilder();
            while(j!=0 ){
          one.append(".");
            j--;
             }

             ans[i]=one.toString();
        }
        else{
            StringBuilder two= new StringBuilder();
          for(int k=0;k<n-1; k++){
            two.append("#");
          }
          two.append(".");
           ans[i]=two.toString();

         
        }
        }
       

return ans;
    }
}