package 图.并查集.q200_2_岛屿数量;

/**
 * 方法一：并查集
 */
class Solution {
    //联通分量
    int count = 0;
    int[] parent;
    //用于平衡parent树
    int[] size;

    public int numIslands(char[][] grid) {
        //(1)初始化并查集、联通分量为"1"的数量
        int n = grid[0].length;
        int m = grid.length;
        int total = n * m;
        parent = new int[total];
        size = new int[total];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int position = i * n + j;
                parent[position] = position;
                size[position] = 1;
                if (grid[i][j] == '1')
                    count++;
            }
        }

        //(2)遍历每个元素，联通每个元素"1"与其"上下左右"的"1"
        int[][] d = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //(2.1)如为"1"则进行联通处理
                if (grid[i][j] == '1') {
                    //(2.2)上下左右
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        //(2.3)联通目标为：不越界且为"1"
                        if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1') {
                            union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        //(3)返回最后的联通分量
        return count;
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int x1, int x2) {
        int rootX1 = find(x1);
        int rootX2 = find(x2);
        if (rootX1 == rootX2) return;
        if (size[rootX1] > size[rootX2]) {
            parent[rootX2] = rootX1;
            size[rootX1] += size[rootX2];
        } else {
            parent[rootX1] = rootX2;
            size[rootX2] += size[rootX1];
        }
        count--;
    }
}