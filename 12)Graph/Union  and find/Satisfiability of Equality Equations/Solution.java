https://leetcode.com/problems/satisfiability-of-equality-equations/discuss/234486/JavaC%2B%2BPython-Easy-Union-Find
//------UNION AND FIND methodes

class Solution {
    int[] uf = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++)
            uf[i] = i;
        for (String s : equations)
            if (s.charAt(1) == '=')
                uf[find(s.charAt(0) - 'a')] = find(s.charAt(3) - 'a');
        for (String s : equations) {
            if (s.charAt(1) == '!' && find(s.charAt(0) - 'a') == find(s.charAt(3) - 'a'))
                return false;
        }
        return true;

    }

    public int find(int i) {
        if (uf[i] != i)
            uf[i] = find(uf[i]);
        return uf[i];
    }
}
// Time complexity : O(n)
// Space complexity : O(n)