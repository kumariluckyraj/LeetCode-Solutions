class Solution {
    public int dayOfYear(String date) {
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        int month = Integer.parseInt(date.substring(5,7));
        int day =Integer.parseInt(date.substring(8));
        int year = Integer.parseInt(date.substring(0,4));
        if(month>2 &&(year%400==0 ||(year%4==0&&year%100!=0))){
            day= day+1;
        }
        for(int i=0; i<month-1; i++){
    day += months[i];
        }
        return day;
    }
}