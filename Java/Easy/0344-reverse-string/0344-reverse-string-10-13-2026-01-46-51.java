class Solution {
    public void reverseString(char[] s) {
        ArrayList<Character> lst = new ArrayList<>();
        for(int i=0; i<s.length; i++){
            lst.add(s[i]);
        }
      Collections.reverse(lst);
      for(int i=0; i<lst.size(); i++){
        s[i] = lst.get(i);
      }
    }
}