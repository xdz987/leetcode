package 数组.q566_1_重塑矩阵;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int nums[][] = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };
        MatrixReshape matrixReshape = new MatrixReshape();
        int result[][] = matrixReshape.matrixReshape(nums, 2, 6);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}

/**
 * 判断重塑目标矩阵面积是否等于原矩阵，如相等则根据目标矩阵宽长 重塑为新矩阵
 */
class MatrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        //(1)判断r,c是否可重塑为新矩阵
        int rows = nums.length;
        int columns = nums[0].length;
        if (rows * columns != r * c) {
            return nums;
        }
        //(2)初始化容器
        int newShape[][] = new int[r][c];

        //(3)填充新矩阵
        int v = 0;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                // 当前为第v个元素
                v = (row * columns) + column;
                newShape[v / c][v % c] = nums[row][column];
            }
        }
        return newShape;
    }
}