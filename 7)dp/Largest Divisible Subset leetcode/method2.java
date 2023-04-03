import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LIS type

public class method2 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int hash[] = new int[nums.length];
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            hash[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0) {

                    if (1 + dp[prev] > dp[i]) {
                        hash[i] = prev;
                        dp[i] = 1 + dp[prev];
                    }
                }
            }
            if (dp[i] > dp[maxi]) {
                maxi = i;
            }
        }
        // now tracing back elements using hash array
        int index = maxi;
        while (index != hash[index]) {
            res.add(nums[index]);
            index = hash[index];
        }
        res.add(nums[index]);

        return res;

    }
}
