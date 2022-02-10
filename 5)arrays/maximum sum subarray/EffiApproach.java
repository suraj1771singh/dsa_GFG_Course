
//IDEA : maxend[i]=max(maxend[i-1]+arr[i],arr[i])
//----------Kadens's algo
public class EffiApproach {
    public static void main(String[] args) {
        int[] arr = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr) {
        int res = arr[0], n = arr.length, maxending = arr[0];
        for (int i = 1; i < n; i++) {
            maxending = Math.max(maxending + arr[i], arr[i]);
            res = Math.max(res, maxending);
        }
        return res;

    }

}
// Time complexity : theta(n)