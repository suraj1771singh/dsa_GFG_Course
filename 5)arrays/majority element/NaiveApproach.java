
//PROBLEM : find that element whoes freq is more than n/2 ,n is the length of the array

//IDEA : for each element traverse array and calculate its freq, and keep track for which freq>n/2

public class NaiveApproach {

    public static void main(String[] args) {
        int[] arr = new int[] { 8, 3, 4, 8, 8 };
        System.out.println(getMajorityElement(arr));
    }

    public static int getMajorityElement(int[] arr) {
        int res = -1, n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count > n / 2)
                res = arr[i];
        }
        return res;
    }
}
// Time Complexity : theta(n^2)