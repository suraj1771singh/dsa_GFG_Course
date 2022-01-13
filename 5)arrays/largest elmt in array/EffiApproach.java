/**
 * LargestEleInArray
 */
public class EffiApproach {

    public static void main(String[] args) {
        int[] arr = new int[] { 23, 1, 5, 85, 73, 43 };
        System.out.println(getLargestElement(arr));
    }

    public static int getLargestElement(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            if (max < a[i])
                max = a[i];
        }
        return max;
    }
}

// Time Complexity : theta(n) n= length of an array