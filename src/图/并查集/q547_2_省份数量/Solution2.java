package 图.并查集.q547_2_省份数量;

/**
 * 方法二：DFS（省份0递增）
 */
public class Solution2 {
    public int findCircleNum(int[][] isConnected) {
        int cityCount = isConnected.length;
        int province = 0;
        boolean[] visited = new boolean[cityCount];
        //(1)遍历每个城市，对每个城市进行DFS联通（设对应visited为true）
        for (int i = 0; i < cityCount; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                province++;
            }
        }
        return province;
    }

    //(2)对城市进行联通
    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }
}
