class Solution {
    public int minInsertions(String s) {
        int c = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (c %2== 1) {
                    ans++;
                    c --;
                }
                c += 2;
            } else {
                c--;

                if (c < 0) {
                    ans++;
                    c = 1;
                }
            }
        }

        return ans + c;
    }
}