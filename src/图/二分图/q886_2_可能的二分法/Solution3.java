package 图.二分图.q886_2_可能的二分法;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法三：并查集
 * Java：56% 95%
 * 复杂度：O(N+M) O(N) 其中N是无向图的顶点数，M是无向图的边数
 */
public class Solution3 {
    int[] parent;
    int[] size;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        N++;
        //(1)初始化并查集
        parent = new int[N];
        size = new int[N];
        for (int i = 1; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        //(2)建立邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            adjacency.get(dislike[0]).add(dislike[1]);
            adjacency.get(dislike[1]).add(dislike[0]);
        }
        //(3)合并除了顶点自己i的邻接顶点
        for (int i = 1; i < N; i++) {
            List<Integer> vs = adjacency.get(i);
            for (int v : vs) {
                //(3.1)还未合并，顶点i就与与邻接顶点联通，说明交叉了，直接false
                if (isConnected(i, v))
                    return false;
                union(vs.get(0), v);
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
        return find(p) == find(q);
    }
}
