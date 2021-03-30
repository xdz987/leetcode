package 图.并查集.q200_2_岛屿数量;

/**
 * 【理解错题】
 * 暴力破解法
 * 方案：遍历每个节点，如果该节点为"陆地"，则判断该节点上下左右是否为"陆地"，当最后上下左右的"陆地"数量<=1时说明为岛屿
 */
class Ignore {
    public int numIslands(char[][] grid) {
        int[][] d = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int n = grid.length;
        int m = grid[0].length;
        int Island = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    int landCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (x >= 0 && x < n && y >= 0 && y < m) {
                            if (grid[x][y] == '1') {
                                landCount++;
                            }
                        }
                    }
                    if (landCount <= 1) {
                        Island++;
                    }
                }
            }
        }
        return Island;
    }
}