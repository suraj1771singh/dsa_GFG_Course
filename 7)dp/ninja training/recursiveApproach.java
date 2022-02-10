import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TimerTask;

import javax.sound.sampled.ReverbType;

public class recursiveApproach {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int tempn = n;
            int[][] arr = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = s.nextInt();

                }
            }

            System.out.println(new solution().ninjaTraining(tempn, arr));
        }
    }

}

class solution {
    public int ninjaTraining(int n, int[][] point) {
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }

        return getmax(point, n, -1, dp);
    }

    int getmax(int[][] point, int day, int prevtask, int[][] dp) {
        int maxi = 0;
        if (day == 0) {
            for (int i = 0; i < 3; i++)
                if (i != prevtask)
                    maxi = Math.max(maxi, point[day][i]);

            return maxi;
        }
        if (dp[day][prevtask] != -1)
            return dp[day][prevtask];

        for (int i = 0; i < 3; i++) {
            if (i != prevtask) {
                int points = point[day][i] + getmax(point, day - 1, i, dp);
                maxi = Math.max(maxi, points);
            }
        }
        return dp[day][prevtask] = maxi;
    }

}