package 剑指offer补充.剑12_2_矩阵中的路径;

/**
 * 方法一：回溯
 * Java：98% 10%
 * 复杂度：O(3^kMN) O(K) 其中K为字符串长度
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        char[] target = word.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == target[0] && backTrack(board, target, 0, i, j, n, m)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, char[] target, int targetIndex,
                              int x, int y, int n, int m) {
        if (targetIndex == target.length) return true;
        if (x < 0 || y < 0 || x > n - 1 || y > m - 1 || board[x][y] == '#' || board[x][y] != target[targetIndex]) {
            return false;
        }
        board[x][y] = '#';
        boolean res = backTrack(board, target, targetIndex + 1, x - 1, y, n, m)
                || backTrack(board, target, targetIndex + 1, x, y - 1, n, m)
                || backTrack(board, target, targetIndex + 1, x + 1, y, n, m)
                || backTrack(board, target, targetIndex + 1, x, y + 1, n, m);
        board[x][y] = target[targetIndex];
        return res;
    }
}