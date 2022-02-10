
//Problem find max length continous odd or even terms subarray
//IDEA : check for every subarray 

public class NaiveApproach {

    public static void main(String[] args) {
        int[] arr = { 5, 10, 20, 6, 3, 8 };
        System.out.println(getMax(arr));

    }

    public static int getMax(int[] arr) {
        int res = 1, n = arr.length;

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if ((arr[j] % 2 == 0 && arr[j - 1] % 2 == 0) || (arr[j] % 2 != 0 && arr[j - 1] % 2 != 0))
                    count++;
                else
                    break;
            }
            res = Math.max(res, count);
        }
        return res;

    }
}

// Time complexity : theta(n^2)