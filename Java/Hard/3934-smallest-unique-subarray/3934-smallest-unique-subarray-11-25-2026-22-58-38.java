
import java.util.*;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int[] sa = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            sa[i] = i;
            rank[i] = nums[i];
        }

        // Build Suffix Array
        for (int k = 1; k < n; k *= 2) {

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                int first = rank[i] + 1;
                int second = (i + k < n) ? rank[i + k] + 1 : 0;

                arr[i] = ((long) first << 34)
                       | ((long) second << 17)
                       | i;
            }

            Arrays.sort(arr);

            int[] newRank = new int[n];

            int r = 0;
            sa[0] = (int)(arr[0] & 131071);

            for (int i = 1; i < n; i++) {
                int prev = sa[i - 1];
                int curr = (int)(arr[i] & 131071);

                int prevFirst = rank[prev];
                int currFirst = rank[curr];

                int prevSecond = (prev + k < n) ? rank[prev + k] : -1;
                int currSecond = (curr + k < n) ? rank[curr + k] : -1;

                if (prevFirst != currFirst ||
                    prevSecond != currSecond) {
                    r++;
                }

                newRank[curr] = r;
                sa[i] = curr;
            }

            newRank[sa[0]] = 0;
            rank = newRank;

            if (r == n - 1) {
                break;
            }
        }

        // Build LCP Array using Kasai's Algorithm
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[sa[i]] = i;
        }

        int[] lcp = new int[n];
        int len = 0;

        for (int i = 0; i < n; i++) {
            int r = pos[i];

            if (r == 0) {
                continue;
            }

            int j = sa[r - 1];

            while (i + len < n && j + len < n &&
                   nums[i + len] == nums[j + len]) {
                len++;
            }

            lcp[r] = len;

            if (len > 0) {
                len--;
            }
        }

        // Find minimum unique subarray length
        int ans = n;

        for (int i = 0; i < n; i++) {
            int maxLcp = lcp[i];

            if (i + 1 < n) {
                maxLcp = Math.max(maxLcp, lcp[i + 1]);
            }

            int uniqueLen = maxLcp + 1;

            if (uniqueLen <= n - sa[i]) {
                ans = Math.min(ans, uniqueLen);
            }
        }

        return ans;
    }
}
