package 图.拓扑排序.q207_2_课程表;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法二：DFS+标记表
 * Java：98% 81%
 * 复杂度：O(N+M) O(N+M) 其中N和M分别为节点数量和临边数量
 */
public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //(1)初始化邻接表、标记表
        int[] flags = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adjacency.get(pre[1]).add(pre[0]);
        }
        //(2)对每个节点DFS
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        //base case 说明其他节点已经dfs过，返回true
        if (flags[i] == -1) return true;
        //base case 说明当前节点已经DFS过，即为环，返回false
        if (flags[i] == 1) return false;
        //(1)只有flags[i]==0才后走这里
        //设为1即为已访问邻接节点
        flags[i] = 1;
        //(2)遍历当前节点i的所有邻接节点
        for (int j : adjacency.get(i)) {
            if (!dfs(adjacency, flags, j)) return false;
        }
        //(3)设当前节点为已经访问过
        flags[i] = -1;
        //(4)到此，说明以节点i作为起点不存在环，返回true
        return true;
    }
}
