//IDEA : its a sorted array
public class FrequencyInSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 10, 20, 30, 30, 30, 40, 40, 50 };
        getFreqency(arr);
    }

    public static void getFreqency(int[] arr) {
        int freq = 1;
        int curr_ele = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == curr_ele) {
                freq++;
            } else {
                System.out.println(curr_ele + ":" + freq);
                curr_ele = arr[i];
                freq = 1;
            }
        }
        System.out.println(curr_ele + ":" + freq);

    }
}

// Time complexity : theta(n)