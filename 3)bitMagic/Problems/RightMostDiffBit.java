class Solution {
    // Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n) {

        int a = m ^ n;
        int k = 1;
        while (a > 0) {
            if ((a & 1) == 1)
                return k;
            k++;
            a = a >> 1;
        }
        return 0;

    }
}
