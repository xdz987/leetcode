package 动态规划.矩阵路径.q62_2_不同路径;

/**
 * 方法一：DP——矩阵路径
 * Java：100% 93%
 * 复杂度：O(N^2) O(N)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //(1)当只存在一行或一列时，最多只有一条路径，所以初始化dp表第一行/列值均为1
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        //(2)遍历除了第一行/列的每个元素，等于上和左路径之和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //路径压缩
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}