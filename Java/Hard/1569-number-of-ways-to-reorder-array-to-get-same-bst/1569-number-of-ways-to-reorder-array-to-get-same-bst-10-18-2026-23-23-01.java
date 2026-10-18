
class Solution {
    int mod = 1000000007;
    long[][] comb = new long[1001][1001];

    public int numOfWays(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % mod;
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }

        return (int)((solve(arr) - 1 + mod) % mod);
    }

    public long solve(ArrayList<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        int root = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        long l = solve(left);
        long r = solve(right);

        long ways = comb[left.size() + right.size()][left.size()];

        ways = (ways * l) % mod;
        ways = (ways * r) % mod;

        return ways;
    }
}
