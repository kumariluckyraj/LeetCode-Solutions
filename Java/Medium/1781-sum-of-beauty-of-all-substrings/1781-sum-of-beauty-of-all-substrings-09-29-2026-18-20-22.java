class Solution {
    public int beautySum(String s) {
       
        int total=0;
        for(int i=0; i<s.length(); i++){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j=i; j<s.length(); j++){
                   map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
 int max =Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
                   for(char val:map.keySet()){
                           if(map.get(val)>max){
                            max = map.get(val);
                           }
                            if(map.get(val)<min){
                            min = map.get(val);
                           }
                           
                   }
                   total += (max-min);
            }
        }
        return total;
    }
}