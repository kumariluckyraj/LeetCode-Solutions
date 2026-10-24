class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
       

        int amonth1 = Integer.parseInt(arriveAlice.substring(0,2));
        int amonth2 = Integer.parseInt(leaveAlice.substring(0,2));
        int bmonth1 = Integer.parseInt(arriveBob.substring(0,2));
        int bmonth2 = Integer.parseInt(leaveBob.substring(0,2));

        int aday1 = Integer.parseInt(arriveAlice.substring(3));
        int aday2 = Integer.parseInt(leaveAlice.substring(3));
        int bday1 = Integer.parseInt(arriveBob.substring(3));
        int bday2 = Integer.parseInt(leaveBob.substring(3));
       int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
       for(int i=0; i<amonth1-1; i++){
           aday1 += months[i];
       }
       for(int i=0; i<amonth2-1; i++){
        aday2 += months[i];
       }
       for(int i=0; i<bmonth1-1; i++){
        bday1 += months[i];
       }
       for(int i=0; i<bmonth2-1; i++){
        bday2 += months[i];
       }

       int arrive = Math.max(aday1,bday1);
       int leave = Math.min(aday2,bday2);
       if(arrive>leave){
        return 0;
       }
       int ans = leave-arrive+1;
        return ans;
       
       
           }
}