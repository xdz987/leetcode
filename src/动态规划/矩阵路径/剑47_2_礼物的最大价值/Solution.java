package 动态规划.矩阵路径.剑47_2_礼物的最大价值;

/**
 * 与q64一模一样，只是min换成max
 * 方法一：DP
 * Java：83% 22%/98% 65%
 * 复杂度：O(N^2) O(N^2)/O(1)
 */
class Solution {
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum += grid[i][0];
            dp[i][0] = preSum;
        }
        preSum = 0;
        for (int i = 0; i < m; i++) {
            preSum += grid[0][i];
            dp[0][i] = preSum;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }

    //原地替换法
    public int maxValue2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[n - 1][m - 1];
    }
}