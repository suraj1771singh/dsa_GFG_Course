
//PROBLEM : given array of binary , now make every element
// same using minumum number of consective flips
// either consective  flip 0's or 1's
public class EffiApproach {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 1, 1, 0, 0, 1 };
        minimumConsecutiveFlips(arr);

    }

    public static void minimumConsecutiveFlips(int[] arr) {
        int n = arr.length;

        if (arr[0] == arr[n - 1]) {
            if (arr[0] == 1) {
                // this means consective 0's are less than consective 1's
                // so flip consective 0's for minimum flips
                flips(arr, 0);
            } else {
                // flip consective 1's for minimum flips
                flips(arr, 1);
            }
        } else {
            flips(arr, arr[0]);
        }

    }

    public static void flips(int[] arr, int target) {
        int n = arr.length, count = 0, start = -1, i;
        for (i = 0; i < n; i++) {
            if (arr[i] == target) {
                count++;
                if (start == -1) {
                    start = i;
                    System.out.print("From " + i);
                }
            } else {
                if (start != -1) {
                    System.out.println(" to " + (start + count - 1));
                    start = -1;
                }
                count = 0;
            }
        }
        if (count > 0)
            System.out.println(" to " + (start + count - 1));
    }
}

// Time complexity : theta(n)