package 动态规划.矩阵路径.q63_2_不同路径2;

/**
 * //思路同q62
 * 方法一：DP——矩阵路径
 * Java：100% 65%
 * 复杂度：O(N^2) O(1)
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //终点起点为障碍物直接返回0路径（存在这样的测试用例...）
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        //(1)初始化第一行/列为1。当遇到障碍后，那么后续路径直接走不通改为0（因为不能往上和往左走）
        boolean isObstacle = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                isObstacle = true;
            }
            obstacleGrid[i][0] = isObstacle ? 0 : 1;
        }
        isObstacle = false;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                isObstacle = true;
            }
            obstacleGrid[0][i] = isObstacle ? 0 : 1;
        }

        //(2)遍历除第一行/列外的所有元素
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //(3)当遇到障碍物时，处理改为0，并跳过
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                //(4)计算路径和
                obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}