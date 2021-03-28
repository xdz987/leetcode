package 图.并查集.q130_2_被围绕的区域;

//DFS
public class Solution2 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        //将边界O进行递归：替换为#，并dfs替换围绕它的O也为#...
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }
        //恢复#为O，O替换为#
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    //dfs实施替换O为#动作
    private void dfs(char[][] board, int i, int j) {
        //base case 不越界并为O
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
