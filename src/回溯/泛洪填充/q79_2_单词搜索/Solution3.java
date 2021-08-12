package 回溯.泛洪填充.q79_2_单词搜索;

/**
 * 三刷：优化版 95% 95%
 */
class Solution3 {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        char[] sArr = word.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == sArr[0] && backTrack(board, i, j, sArr, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, int x, int y, char[] sArr, int target) {
        if (target == sArr.length)
            return true;
        if (x < 0 || y < 0 || x == board.length || y == board[0].length || board[x][y] != sArr[target]) {
            return false;
        }
        char tmp = sArr[target];
        board[x][y] = '.';
        boolean res = backTrack(board, x + 1, y, sArr, target + 1) ||
                backTrack(board, x, y + 1, sArr, target + 1) ||
                backTrack(board, x - 1, y, sArr, target + 1) ||
                backTrack(board, x, y - 1, sArr, target + 1);
        board[x][y] = tmp;

        return res;
    }
}