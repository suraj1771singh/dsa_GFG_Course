class Solution {
    public int maximalRectangle(char[][] b) {
        int maxArea = 0;
        int n = b.length;
        int m = b[0].length;
        int height[] = new int[m];

        // convert char to int 2D grid
        int[][] matrix = convertToInt(b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            int area = largestRectangleArea(height);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res = 0;
        int[] lessFromLeft = new int[n];
        int[] lessFromRight = new int[n];
        lessFromLeft[0] = -1;
        lessFromRight[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]) {
                left = lessFromLeft[left];
            }
            lessFromLeft[i] = left;
            int right = n - i;
            while (right < n && heights[right] >= heights[n - i - 1]) {
                right = lessFromRight[right];
            }
            lessFromRight[n - i - 1] = right;

        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (lessFromRight[i] - lessFromLeft[i] - 1) * heights[i]);
        }
        return res;

    }

    public int[][] convertToInt(char[][] a) {
        int n = a.length;
        int m = a[0].length;
        int b[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = (a[i][j] == '1') ? 1 : 0;
            }
        }
        return b;
    }
}