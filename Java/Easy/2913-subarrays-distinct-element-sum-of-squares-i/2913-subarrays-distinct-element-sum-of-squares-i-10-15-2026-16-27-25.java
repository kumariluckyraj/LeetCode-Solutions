class Solution {
    public int sumCounts(List<Integer> nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       int c=0;
       int res =0;
        for(int i=0; i<nums.size(); i++){
            for(int j=i; j<nums.size(); j++){
                ArrayList<Integer> lst = new ArrayList<>();
                 HashSet<Integer> set = new HashSet<>();
                for(int k=i; k<=j; k++){
                    lst.add(nums.get(k));
                }
                for(int m=0; m<lst.size(); m++){
                    set.add(lst.get(m));
                }
                c=0;
                for(int l=0; l<set.size(); l++){
                    c++;
                }
                res += (c*c);
            }
        }
return res;

    }
}