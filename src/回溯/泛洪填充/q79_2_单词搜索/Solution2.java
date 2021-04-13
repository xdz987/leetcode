package 回溯.泛洪填充.q79_2_单词搜索;

/**
 * 方法二：回溯[自己写优化版]
 * 优化：used数组改为【填充法】、backTrack直接返回、优化方向数组、优化base case判断
 * Java：60% 90%
 */
public class Solution2 {
    //方向数组
    int[][] d = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        //(1)初始化行/列
        int n = board.length;
        int m = board[0].length;
        char[] wordArr = word.toCharArray();
        //(2)遍历每个字符，查找word的起点字符
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                //(2.1)找到起点字符，进行回溯查找
                if (board[row][col] == wordArr[0]) {
                    if (backTrack(board, wordArr, row, col, n, m, 0))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, char[] wordArr, int row, int col, int n, int m, int next) {
        //base case：当前坐标字符不为目标字符，直接跳过该方向
        if (board[row][col] != wordArr[next]) {
            return false;
        }
        //找到目标，返回true
        if (next == wordArr.length - 1) {
            return true;
        }
        //(1)设为已使用
        char tmp = board[row][col];
        board[row][col] = '.';

        //(2)遍历上下左右四个方向
        if (row - 1 >= 0 && backTrack(board, wordArr, row - 1, col, n, m, next + 1))
            return true;
        if (col - 1 >= 0 && backTrack(board, wordArr, row, col - 1, n, m, next + 1))
            return true;
        if (row + 1 < n && backTrack(board, wordArr, row + 1, col, n, m, next + 1))
            return true;
        if (col + 1 < m && backTrack(board, wordArr, row, col + 1, n, m, next + 1))
            return true;

        //(3)回溯，设为未使用
        board[row][col] = tmp;
        return false;
    }
}
