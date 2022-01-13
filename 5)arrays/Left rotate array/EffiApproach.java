public class EffiApproach {
    public static void main(String[] args) {
        int[] arr = new int[] { 10, 20, 30, 40, 50 };
        int d = 3; // d < arr.length
        leftRotate(arr, d);
    }

    // left rotate by d
    public static void leftRotate(int[] arr, int d) {
        int[] temp = new int[d];

        // tranferring first d elements to temp array
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        // getting last n-d element to beginning
        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }

        // copying elements and add them after n-d
        for (int i = 0; i < d; i++) {
            arr[arr.length - d + i] = temp[i];
        }

        // printing resulting array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

// Time complexity: theta(n)
// Auxillary : theta(d)
