package 动态规划.矩阵路径.q64_2_最小路径和;

/**
 * 思路同q64，只是从【当前=上左之和】换成【当前=当前+min(上,左)】
 * 方法一：DP——矩阵路径
 * Java：98% 73%
 * 复杂度：O(N^2) O(1)
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int sum = 0;
        //(1)当只存在一行或一列时，最多只有一条路径，所以初始化为直线路径之和
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }

        //(2)遍历除第一行/列之外的元素，取得到达[i][j]的最小路径之和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    //原地修改，将grid改为dp数组
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            grid[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            grid[0][i] = sum;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }
}