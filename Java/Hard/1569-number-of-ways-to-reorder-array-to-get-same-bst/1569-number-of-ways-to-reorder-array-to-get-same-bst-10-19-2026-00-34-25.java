class Solution {
    int[][] PT;
    int mod = 1000000007;
    public int numOfWays(int[] nums) {
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            lst.add(nums[i]);
        }
      
      int c=0;
       PT = new int[1001][1001];
      int n= nums.length;
      for(int i=0; i<nums.length; i++){
        PT[i][0] = 1;
        PT[i][i] = 1;
        for(int j=1; j<i; j++){
            PT[i][j] = (PT[i-1][j] +PT[i-1][j-1])%mod;
        }
      }
      return (int)(solve(lst)-1+mod)%mod;
    }

    public long solve(ArrayList<Integer> nums){
        int n = nums.size();
        if(nums.size()<3){
            return 1;
        }
       
int root = nums.get(0);
    ArrayList<Integer> left = new ArrayList<>();
    ArrayList<Integer> right = new ArrayList<>();
    for(int i=1; i<n; i++){
    if(nums.get(i)<root){
        left.add(nums.get(i));
    }
    else{
        right.add(nums.get(i));
    }
    }
    long l = solve(left)%mod;
    long r = solve(right)%mod;
    long ans = (((l*r)%mod)*PT[n-1][left.size()])%mod;
    return ans;

    }
}