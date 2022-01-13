//IDEA : traverse from right and keep track of max
public class EffiApproach {
    public static void main(String[] args) {
        int[] arr = new int[] { 7, 10, 4, 3, 6,6, 5, 2 };
        printLeader(arr);
    }

    public static void printLeader(int[] arr) {
        int n = arr.length;
        int max = arr[n - 1];
        System.out.print(max + " ");
        for (int i = n - 1; i >= 0; i--) {
            if (max < arr[i]) {
                max = arr[i];
                System.out.print(max + " ");
            }
        }

    }

}

// Time complexity : theta(n)
