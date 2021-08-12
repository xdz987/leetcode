package 动态规划.矩阵路径.q63_2_不同路径2;

public class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n && obstacleGrid[i][0] != 1; i++) dp[i][0] = 1;
        for (int i = 0; i < m && obstacleGrid[0][i] != 1; i++) dp[0][i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
}
