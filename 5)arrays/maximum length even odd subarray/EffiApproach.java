
// IDEA :  replace odd with 1 and even with 0

public class EffiApproach {
    public static void main(String[] args) {
        int[] arr = { 5, 10, 20, 6, 3, 8 };
        System.out.println(getMax(arr));

    }

    public static int getMax(int[] arr) {
        int res = 1, n = arr.length, count = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0)
                // if even -> replace with 1
                arr[i] = 1;
            else
                // if odd -> replace with 0
                arr[i] = 0;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] + arr[i - 1] == 1)
                count = 1;
            else
                count++;
            res = Math.max(res, count);
        }

        return res;

    }
}

// Time complexity : theta (n)