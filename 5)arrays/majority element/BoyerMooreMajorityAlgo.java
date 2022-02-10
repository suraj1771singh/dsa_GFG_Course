public class BoyerMooreMajorityAlgo {
    public static void main(String[] args) {
        int[] arr = new int[] { 8, 3, 4, 8, 8 };
        System.out.println(getMajorityElement(arr));
    }

    public static int getMajorityElement(int[] arr) {
        int candidateIndex = getCandidate(arr), freq = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[candidateIndex] == arr[i])
                freq++;
        }
        if (freq <= n / 2)
            return -1;
        return arr[candidateIndex];

    }

    public static int getCandidate(int[] arr) {
        int candidateIndex = 0, votes = 1, n = arr.length;
        for (int i = 0; i < n; i++) {
            if (votes == 0) {
                candidateIndex = i;
                votes = 1;
            }
            if (arr[candidateIndex] == arr[i])
                votes++;
            else
                votes--;
        }
        return candidateIndex;
    }
}
// Time Complexity : O(n)
