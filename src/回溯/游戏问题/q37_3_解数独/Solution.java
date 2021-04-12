package 回溯.游戏问题.q37_3_解数独;

/**
 * 方法一：回溯
 */
class Solution {
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }

    //到了决策树的叶节点就直接返回，毕竟数独答案只有一种解
    private boolean backTrack(char[][] board) {
        //(1)遍历决策树每条【路径】
        for (int row = 0; row < 9; row++) {
            //(2)遍历决策树【选择列表】
            for (int col = 0; col < 9; col++) {
                //(3)如果为空白则充数字，则尝试1~9进行填充，满足条件则回溯
                if (board[row][col] != '.') continue;
                for (char num = '1'; num <= '9'; num++) {
                    //(3.1)该空白填充合法，回溯
                    if (isValid(board, row, col, num)) {
                        board[row][col] = num;
                        //(3.2)回溯结果为true，该路径是合法的，无需填充回'.'
                        if (backTrack(board))
                            return true;
                        board[row][col] = '.';
                    }
                }
                //(3.3)测试9个数都不行，返回false，重新尝试
                return false;
            }
        }
        //数字num放置成功
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        //查看行或列是否存在num
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }

        //查找当小矩阵内是否存在num
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}