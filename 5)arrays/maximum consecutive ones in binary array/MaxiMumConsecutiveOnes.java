/**
 * MaxiMumConsecutiveOnes
 */
public class MaxiMumConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1 };
        System.out.println(getMaxConsectiveOnes(arr));
    }

    public static int getMaxConsectiveOnes(int[] arr) {
        int res = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                count++;
            else
                count = 0;

            res = Math.max(res, count);
        }
        return res;

    }
}
// Time complexity : theta(n)