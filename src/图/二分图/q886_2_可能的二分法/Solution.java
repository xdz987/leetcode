package 图.二分图.q886_2_可能的二分法;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法一：DFS+标记表
 * Java：80% 60%
 * 复杂度：O(N+M) O(N+M) 其中N和M分别为节点数量和临边数量
 */
public class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        //编号从1开始，所以要补1
        N++;
        //(1)初始化邻接表、标记表
        int[] flags = new int[N];
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            //(1.1)分为两组且按dislikes[]切分。可设为二分图，那么从二分图的角度来看，不为同组即为可设为相邻节点，相邻节点染为不同颜色
            adjacency.get(dislike[0]).add(dislike[1]);
            adjacency.get(dislike[1]).add(dislike[0]);
        }
        //(2)遍历以每个顶点为起点进行DFS
        for (int i = 1; i < N; i++) {
            if (flags[i] == 0 && !dfs(adjacency, flags, i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int v, int color) {
        //(1)如已经染色，那么返回判定邻接顶点是否相等
        if (flags[v] != 0)
            return flags[v] == color;
        //(2)染色顶点v为1
        flags[v] = color;
        //(3)将与v邻接的节点染为相反的颜色
        for (int j : adjacency.get(v)) {
            if (!dfs(adjacency, flags, j, -color))
                return false;
        }
        //(4)到此说明没有颜色冲突，返回true
        return true;
    }
}
