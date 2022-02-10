import java.util.ArrayList;
import java.util.Scanner;

class backtrackingApproach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        scanner.nextLine();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            scanner.nextLine();
            String ans;
            ans = new Solution().getPermutation(n, k);
            System.out.println(ans);
        }
        scanner.close();
    }
}

class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            s.append(i);
        }
        ArrayList<String> list = new ArrayList<>();
        String ans = new String();
        getKthPermutation(s, n, k, 0, ans, list);
        return list.get(list.size() - 1);

    }

    public boolean getKthPermutation(StringBuilder s, int n, int k, int index, String ans, ArrayList<String> list) {
        if (index == n) {
            if (list.size() == k - 1) {
                list.add(s.toString());
                return true;
            }
            list.add(s.toString());
            return false;
        }
        for (int i = index; i < n; i++) {
            swap(s, index, i);
            if (getKthPermutation(s, n, k, index + 1, ans, list))
                return true;

            swap(s, index, i);
        }
        return false;

    }

    public void swap(StringBuilder str, int i, int j) {
        // StringBuilder sb = new StringBuilder(str);
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);

    }
}

// Time complexity : O(n!*n)
// Auxiallry space : O(n!)

// leetcode not accept this , go for optimal solution from striver recursion
// series
