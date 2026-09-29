class Solution {
    public int repeatedStringMatch(String a, String b) {
        int c=0;
     StringBuilder sb = new StringBuilder();
     while(sb.length()<b.length()){
        sb.append(a);
c++;
     }
if(sb.toString().contains(b)){
    return c;
}
sb.append(a);
c++;
if(sb.toString().contains(b)){
    return c;
}
return -1;
    }
}