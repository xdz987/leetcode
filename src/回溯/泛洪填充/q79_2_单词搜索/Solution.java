package 回溯.泛洪填充.q79_2_单词搜索;

/**
 * 方法一：回溯[自己写版本]
 * Java：35% 91%
 */
public class Solution {
    //方向数组
    int[][] d = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //结果存放，也作为剪枝的触发器
    boolean find = false;

    public boolean exist(char[][] board, String word) {
        //(1)初始化行/列、初始化使用数组used
        int n = board.length;
        int m = board[0].length;
        char[] wordArr = word.toCharArray();
        boolean[][] used = new boolean[n][m];
        //(2)遍历每个字符，查找word的起点字符
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                //(2.1)找到起点字符，进行回溯查找
                if (board[row][col] == wordArr[0]) {
                    backTrack(board, wordArr, used, row, col, n, m, 0);
                }
                //(2.2)剪枝：已找到
                if (find)
                    return true;
            }
        }
        return false;
    }

    private void backTrack(char[][] board, char[] wordArr, boolean[][] used, int row, int col, int n, int m, int next) {
        //base case：找到目标
        if (next == wordArr.length - 1) {
            find = true;
            return;
        }
        //(1)设为已使用
        used[row][col] = true;
        //(2)遍历上下左右四个方向
        for (int k = 0; k < 4; k++) {
            //(2.1)剪枝：已找到目标，直接return
            if (find)
                return;

            int x = row + d[k][0];
            int y = col + d[k][1];
            //(2.2)越界、已使用、当前坐标字符不为目标字符：直接跳过该方向
            if (x < 0 || y < 0 || x >= n || y >= m || used[x][y] || board[x][y] != wordArr[next + 1]) {
                continue;
            }
            //(2.3)坐标[x][y]符合条件，继续深入
            backTrack(board, wordArr, used, x, y, n, m, next + 1);
        }
        //(3)回溯，设为未使用
        used[row][col] = false;
    }
}
