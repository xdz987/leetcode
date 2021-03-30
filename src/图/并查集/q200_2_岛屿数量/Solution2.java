package 图.并查集.q200_2_岛屿数量;

/**
 * 方法二：DFS
 */
public class Solution2 {
    //方向控制
    int[][] d = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        //(1)遍历所有节点，统计岛屿数量
        int isLandCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //(1.1)只有为陆地才需要进行DFS
                if (grid[i][j] == '1') {
                    //(1.2)向陆地的四个方向进行DFS
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        dfs(grid, x, y, n, m);
                    }
                    //(1.3)DFS结束，岛屿数+1
                    isLandCount++;
                }
            }
        }
        return isLandCount;
    }

    //以某块陆地为中心向四周（上下左右）DFS
    public void dfs(char[][] grid, int x, int y, int n, int m) {
        //base case：当节点越界、已访问过、为'水'
        if (x < 0 || y < 0 || x > n - 1 || y > m - 1  || grid[x][y] == '0') {
            return;
        }
        //(1)设为已访问过 '0'
        grid[x][y] = '0';

        //(2)向当前的节点四周继续dfs
        for (int k = 0; k < 4; k++) {
            int xx = x + d[k][0];
            int yy = y + d[k][1];
            dfs(grid, xx, yy, n, m);
        }
    }
}
