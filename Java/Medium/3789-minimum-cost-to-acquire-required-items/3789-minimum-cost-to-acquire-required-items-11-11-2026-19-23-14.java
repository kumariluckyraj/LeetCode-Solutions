class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
       
        long c3=0;
        if(cost1+cost2<=costBoth){
          c3=(long)cost1*need1+ (long)cost2*need2;
             return c3;
        }else{
          long min = Math.min(need1,need2);
          need1 -= min;
          need2 -= min;
          c3 = min *costBoth;
          if(need1 >0){
         c3+= (long)need1*Math.min(cost1,costBoth);
          }
          if(need2 >0){
            c3 += (long)need2*Math.min(cost2, costBoth);
          }
          return c3;
        }




    }
}