class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[nums.length];
        ArrayList<Integer> lst = new ArrayList<>();
        int n = nums.length;
        for(int i=2*n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            if(i<n){
            if(st.isEmpty()){
                lst.add(-1);
            }else{
                lst.add(st.peek());
            }
            }
            st.push(nums[i%n]);
        }
        Collections.reverse(lst);
        for(int j=0;j<lst.size(); j++){
            arr[j]=lst.get(j);
        }
        return arr;
    }
}