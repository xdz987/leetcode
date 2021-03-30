package 图.并查集.q547_2_省份数量;

/**
 * 题意：二维矩阵实为城市对应表，即对称矩阵，为正方形即n=m。题目要求返回最后的联通分量数
 * 方法一：并查集(省份n递减)
 */
public class Solution {
    private int[] parent;
    private int[] size;
    private int count = 0;

    public int findCircleNum(int[][] isConnected) {
        //(1)初始化并查集
        int n = isConnected.length;
        int m = isConnected[0].length;
        parent = new int[n];
        size = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        //(2)联通相连的城市
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        //(3)统计省份，即联通分量的数量
        return count;
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int q, int p) {
        int rootQ = find(q);
        int rootP = find(p);
        if (rootQ == rootP)
            return;
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }
}
