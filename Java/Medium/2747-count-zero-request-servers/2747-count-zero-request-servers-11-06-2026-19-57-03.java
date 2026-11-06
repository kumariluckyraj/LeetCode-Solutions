class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a,b) -> Integer.compare(a[1], b[1]));

        int[][] q = new int[queries.length][2];

        for(int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a,b) -> Integer.compare(a[0], b[0]));

        int[] arr = new int[queries.length];

        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        for(int i = 0; i < queries.length; i++) {

            int start = q[i][0] - x;
            int end = q[i][0];

            while(right < logs.length && logs[right][1] <= end) {
                int id = logs[right][0];

                map.put(id, map.getOrDefault(id, 0) + 1);
                set.add(id);

                right++;
            }

            while(left < right && logs[left][1] < start) {
                int id = logs[left][0];

                map.put(id, map.get(id) - 1);

                if(map.get(id) == 0) {
                    map.remove(id);
                    set.remove(id);
                }

                left++;
            }

            arr[q[i][1]] = n - set.size();
        }

        return arr;
    }
}