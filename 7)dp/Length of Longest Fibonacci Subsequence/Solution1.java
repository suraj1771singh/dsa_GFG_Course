import java.util.HashMap;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cnt = 0;
                int num = arr[i] + arr[j];
                int temp_i = i;
                int temp_j = j;
                while (map.containsKey(num)) {
                    temp_i = temp_j;
                    temp_j = map.get(num);
                    num = arr[temp_i] + arr[temp_j];
                    cnt++;
                }
                max = Math.max(max, cnt);

            }
        }
        return max == 0 ? max : max + 2;

    }
}
// Time complexity : O(n^2)
// Space complexity : O(n)