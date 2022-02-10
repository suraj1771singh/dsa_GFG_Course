/**
 * EffiApproach
 */
public class EffiApproach {

    public static void main(String[] args) {
        int[] arr = new int[] { 89, 45, 101, 90, 101 };
        int index = getSecondLargest(arr);
        if (index == -1)
            System.out.println("No, second largest element");
        else
            System.out.println(arr[index]);
    }

    // traverse only one time through array
    public static int getSecondLargest(int[] arr) {
        int secondLargest = -1;
        int Largest = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[Largest]) {
                secondLargest = Largest;
                Largest = i;

            } else if (arr[i] != arr[Largest]) {
                if (secondLargest == -1 || arr[i] > arr[secondLargest])
                    secondLargest = i;
            }

        }

        return secondLargest;

    }
}