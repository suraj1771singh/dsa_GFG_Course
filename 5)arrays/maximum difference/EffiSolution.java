//IDEA: Keep track of minimum element from left and find diff of this minimum with current element
public class EffiSolution {
    public static void main(String[] args) {
        int[] arr = new int[] { 10, 34, 12, 89, 54, 87 };
        System.out.println(getMaxDiffBetweenPairs(arr));
    }

    public static int getMaxDiffBetweenPairs(int[] arr) {
        int res = arr[1] - arr[0];
        int minElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res, arr[i] - minElement);
            minElement = Math.min(minElement, arr[i]);
        }
        return res;

    }
}
// Time complexity: Theta(n)
