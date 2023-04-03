import java.util.ArrayList;

public class binarysearchApproach {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                // use binary search to find correct index
                int index = binarySearch(temp, nums[i]);
                temp.set(index, nums[i]);
            }
        }
        return temp.size();
    }

    private int binarySearch(ArrayList<Integer> temp, int value) {
        int res = -1;
        int l = 0;
        int h = temp.size() - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (temp.get(mid) == value) {
                return mid;
            } else if (value > temp.get(mid)) {
                l = mid + 1;
            } else {
                res = mid;
                h = mid - 1;
            }
        }
        return res;
    }

}
