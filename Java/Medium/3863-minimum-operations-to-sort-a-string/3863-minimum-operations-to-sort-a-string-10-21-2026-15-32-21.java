class Solution {
    public int minOperations(String s) {
        boolean sorted = true;
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)>s.charAt(i+1)){
                sorted= false;
            }
        }
        if(sorted==true){
            return 0;
        }
      if(s.length()==2){
        return -1;
      }
      char first='a';
      char last = 'z';

first = s.charAt(0);
last = s.charAt(s.length()-1);

char min = 'z';
char max = 'a';
int minc=0;
int maxc=0;
for(int i=0; i<s.length(); i++){
char ch = s.charAt(i);
min = (char)Math.min(ch,min);
max =(char) Math.max(ch,max);
}
for(int i=0; i<s.length(); i++){
    if(min==s.charAt(i)){
        minc++;
    }
    if(max==s.charAt(i)){
        maxc++;
    }
}
if(first==max && last==min && minc==1 && maxc==1){
  
    return 3;
}
if(first==min ||last ==max){
    return 1;
}

return 2;
      
    }
}