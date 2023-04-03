import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int arr[] = { 8, 7, 6, 1, 0, 9, 2 };
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int pivot = high;
        int smaller = low - 1;
        for (int i = low; i <= high; i++) {
            if (arr[i] <= arr[pivot]) {
                smaller++;
                swap(smaller, i, arr);
            }

        }
        quickSort(arr, low, smaller - 1);
        quickSort(arr, smaller + 1, high);

    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}