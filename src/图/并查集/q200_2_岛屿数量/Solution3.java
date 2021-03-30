package 图.并查集.q200_2_岛屿数量;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 方法三：BFS（超时）
 * PS：实质为使用队列实现DFS
 */
public class Solution3 {
    //方向控制
    int[][] d = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //用于存放坐标的队列
        Queue<int[]> queue = new LinkedList<>();

        //(1)遍历所有节点，统计岛屿数量
        int isLandCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //(1.1)只有为陆地才需要加入队列进行陆地联通判断
                if (grid[i][j] == '1') {

                    /* 与DFS不同的地方，使用栈实现方法二的DFS */
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        //"1"的坐标
                        int[] coordinate = queue.poll();
                        //设为已访问过
                        grid[coordinate[0]][coordinate[1]] = '0';

                        //(1.2)向陆地的四个方向判断：不越界、为"1"
                        for (int k = 0; k < 4; k++) {
                            int x = coordinate[0] + d[k][0];
                            int y = coordinate[1] + d[k][1];
                            if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1') {
                                queue.offer(new int[]{x, y});
                            }
                        }
                    }

                    //(1.3)岛屿数量+1
                    isLandCount++;
                }
            }
        }
        return isLandCount;
    }
}
