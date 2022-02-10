import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class suraj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        scanner.nextLine();
        while (tc-- > 0) {
            String s = scanner.nextLine();
            List<List<String>> ans = new ArrayList<>();
            ans = new Solution().partition(s);
            System.out.println(ans);
        }
        scanner.close();
    }
}

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(ans, new ArrayList<>(), 0, s);
        return ans;
    }

    public void solve(List<List<String>> ans, List<String> ds, int s_index, String s) {
        if (s_index >= s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 1; i <= s.length() - s_index; i++) {
            if (isValid(s_index, s_index + i - 1, s)) {
                ds.add(s.substring(s_index, s_index + i));
                solve(ans, ds, s_index + i, s);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public boolean isValid(int start, int end, String s) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}

// Time complexity : O(n* 2^n)