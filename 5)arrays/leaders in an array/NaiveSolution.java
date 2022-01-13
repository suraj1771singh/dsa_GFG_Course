// --------------leaders are when elements on right side are strictly smaller
//---facts

//1-- last elements is always leader becoz nothing is on its right side
//2-- leader is that elements whoes right side elements are stictly smaller
//3-- there can be more than 1 leader

// IDEA : for each element  traverse to its right and find out it is leader for not 
public class NaiveSolution {
    //
    public static void main(String[] args) {
        int[] arr = new int[] { 7, 10, 4, 3, 6,6, 5, 2 };
        printLeaders(arr);
    }

    public static void printLeaders(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader)
                System.out.print(arr[i] + " ");
        }

    }

}

// Time complexity : O(n^2)