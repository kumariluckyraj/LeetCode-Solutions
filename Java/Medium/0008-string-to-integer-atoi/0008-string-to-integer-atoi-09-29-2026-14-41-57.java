class Solution {
    public int myAtoi(String s) {
        int i=0;
 while(i< s.length() && s.charAt(i)==' '){
    i++;
 }
 int sign =1;
 if( i< s.length() && (s.charAt(i)=='-'||s.charAt(i)=='+')){
    if(s.charAt(i)=='-'){
        sign = -1;
    }
    i++;
 }
long result =0;
 while(i<s.length()){
    char ch = s.charAt(i);
    if(!(ch-'0'>=0 && ch-'0'<=9)){
        break;
    }else{
result = result*10 + (ch - '0');
int max = Integer.MAX_VALUE;
int min = Integer.MIN_VALUE;
if(sign==1&&result>max){
    return max;
}
if(sign==-1 &&-result<min){
    return min;
}
i++;
    }
 }
 return (int)(sign*result);
    }
}