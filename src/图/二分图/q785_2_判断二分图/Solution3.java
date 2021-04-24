package 图.二分图.q785_2_判断二分图;

/**
 * 方法一：并查集
 * Java：46% 73%
 * 复杂度：O(N+M) O(N) 其中N是无向图的顶点数，M是无向图的边数
 */
public class Solution3 {
    int[] parent;
    int[] size;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        //(1)初始化并查集
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        //(2)遍历顶点，将i的邻接顶点相互联通（i顶点不联通）
        for (int i = 0; i < n; i++) {
            int[] vs = graph[i];
            //(2.1)遍历顶点i的邻接顶点v
            for (int v : vs) {
                //(2.2)还未联通就已经联通，说明交叉了，返回false
                if (isConnected(v, i))
                    return false;
                //(2.3)将顶点进行联通
                union(vs[0], v);
            }
        }
        return true;
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private boolean isConnected(int p, int q) {
        return find(q) == find(p);
    }
}