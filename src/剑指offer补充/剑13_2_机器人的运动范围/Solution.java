package 剑指offer补充.剑13_2_机器人的运动范围;

/**
 * 方法一：DFS
 * Java：84% 40%
 * 复杂度：O(NM) O(NM)
 * //泛洪遍历+限定条件的计数
 */
class Solution {
    int res = 0;

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(0, 0, m, n, k, visited);
        return res;
    }

    private void dfs(int x, int y, int m, int n, int k, boolean[][] visited) {
        if (x < 0 || y < 0 || x > m - 1 || y > n - 1 || visited[x][y] || !canGo(x, y, k)) {
            return;
        }
        res++;
        visited[x][y] = true;
        dfs(x - 1, y, m, n, k, visited);
        dfs(x, y - 1, m, n, k, visited);
        dfs(x + 1, y, m, n, k, visited);
        dfs(x, y + 1, m, n, k, visited);
    }

    private boolean canGo(int x, int y, int k) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum <= k;
    }
}