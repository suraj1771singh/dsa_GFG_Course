//Binary search recursive solution
class Solution {
    public int search(int[] nums, int target) {
        return f(nums, target, 0, nums.length - 1);
    }

    public int f(int[] a, int target, int l, int h) {
        if (l <= h) {
            int mid = (l + h) / 2;
            if (a[mid] == target)
                return mid;
            if (a[l] <= a[mid]) {
                if (target >= a[l] && target < a[mid])
                    return f(a, target, l, mid - 1);
                else
                    return f(a, target, mid + 1, h);
            } else {
                if (target > a[mid] && target <= a[h])
                    return f(a, target, mid + 1, h);
                else
                    return f(a, target, l, mid - 1);
            }
        } else
            return -1;
    }
}
