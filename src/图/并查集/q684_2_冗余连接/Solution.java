package 图.并查集.q684_2_冗余连接;

/**
 * 题意：边集数组去掉一条边，使得图变成树
 */
public class Solution {
    int[] parent;
    int[] size;

    public int[] findRedundantConnection(int[][] edges) {
        //(1)初始化并查集
        int len = edges.length;
        parent = new int[len + 1];
        size = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        //一开始所有顶点都是分散的。
        //(2)union所有顶点，如已经联通，则为附加边直接返回
        for (int i = 0; i < len; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            if (!connected(v1, v2)) {
                union(v1, v2);
            } else {
                return edges[i];
            }
        }
        //基本不会执行到此
        return new int[0];
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}