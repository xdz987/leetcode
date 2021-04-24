package 图.二分图.q785_2_判断二分图;

/**
 * 方法二：DFS+标记数组
 * Java：100% 60%
 * 复杂度：O(N+M) O(N) 其中N是无向图的顶点数，M是无向图的边数
 */
public class Solution2 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        //(1)初始化标记数组
        int[] flags = new int[n];
        //(2)遍历所有顶点，如果未染色即flags[i]==0，则以i为起点进行DFS
        for (int i = 0; i < n; i++) {
            if (flags[i] == 0 && !dfs(graph, flags, i, 1))
                return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] flags, int v, int color) {
        //base case：flags[v]不为0说明已经染过色，返回与要染的color是否相等
        if (flags[v] != 0)
            return flags[v] == color;

        //(1)将顶点v染为参数color颜色
        flags[v] = color;
        //(2)遍历该顶点v的所有联通顶点，dfs让色为相反即-color色
        for (int w : graph[v]) {
            if (!dfs(graph, flags, w, -color))
                return false;
        }
        //(3)到此说明该顶点联通的顶点为(局部)二分图
        return true;
    }
}
