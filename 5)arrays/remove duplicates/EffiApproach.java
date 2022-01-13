public class EffiApproach {
    public static void main(String[] args) {
        int[] arr = { 10, 10, 10, 20, 20, 20, 30, 40, 40 };
        int index = removeDuplicates(arr);
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static int removeDuplicates(int arr[]) {
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[res - 1]) {
                arr[res] = arr[i];
                res++;
            }
        }
        return res;

    }
}
// Time complexity : theta(n)
// auxiallary space: O(1)
