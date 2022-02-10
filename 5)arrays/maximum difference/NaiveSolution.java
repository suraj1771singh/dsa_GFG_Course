
//IDEA :take each pair and calculate diff and keep track of max diff
public class NaiveSolution {

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 34, 12, 89, 54, 87 };
        System.out.println(getMaxDiffBetweenPairs(arr));
    }

    public static int getMaxDiffBetweenPairs(int[] arr) {
        int res = arr[1] - arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                res = Math.max(res, arr[j] - arr[i]);
            }

        }
        return res;

    }
}
// Time complexity : theta(n^2)