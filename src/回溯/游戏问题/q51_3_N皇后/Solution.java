package 回溯.游戏问题.q51_3_N皇后;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法一：回溯
 * 方案：每一行&每一列必定存在一个皇后，这里以每一行作为回溯遍历
 */
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //初始化棋盘
        char[][] chessboard = new char[n][n];
        for (char[] line : chessboard)
            Arrays.fill(line, '.');
        backTrack(chessboard, n, 0);
        return res;
    }

    private void backTrack(char[][] chessboard, int n, int row) {
        if (row == chessboard.length) {
            //将整副棋盘copy进res
            List<String> copyBoard = new ArrayList<>();
            for (char[] line : chessboard) {
                copyBoard.add(String.valueOf(line));
            }
            res.add(copyBoard);
            return;
        }

        //(1)遍历每个棋子位
        for (int col = 0; col < n; col++) {
            //(2)判断该棋位下'Q'是否合法
            if (!isValid(chessboard, n, row, col))
                continue;

            //(3)回溯
            chessboard[row][col] = 'Q';
            backTrack(chessboard, n, row + 1);
            chessboard[row][col] = '.';

        }
    }

    //判断皇后落子是否合格：判断行(无需判断)、列、左上与右上
    private boolean isValid(char[][] chessboard, int n, int row, int col) {
        //判断列是否存在皇后
        for (int r = 0; r < n; r++) {
            if (chessboard[r][col] == 'Q')
                return false;
        }

        //判断右上方（斜线）是否存在皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q')
                return false;
        }

        //判断左上方（斜线）是否存在皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (chessboard[i][j] == 'Q')
                return false;

        //到此说明皇后落子合格
        return true;
    }
}
