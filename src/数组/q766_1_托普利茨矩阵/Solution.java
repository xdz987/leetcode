package 数组.q766_1_托普利茨矩阵;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };
        ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();
        boolean result = toeplitzMatrix.isToeplitzMatrix(matrix);
        System.out.println(result);
    }
}

/**
 * 判断前一行(除元素1)与后一行(除最后元素)是否相等，如全部相等则为ToeplitzMatrix矩阵
 */
class ToeplitzMatrix {
    //2ms
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (rows <= 1 || columns <= 1) {
            return true;
        }
        // (1)临时存储容器
        int row[] = new int[columns - 1];
        int next_row[] = new int[columns - 1];

        // (1)判断上下行符合条件
        for (int i = 0; i < rows - 1; i++) {
            row = Arrays.copyOfRange(matrix[i], 0, columns - 1);
            next_row = Arrays.copyOfRange(matrix[i + 1], 1, columns);
            if (!Arrays.equals(row, next_row)) {
                return false;
            }
        }
        return true;
    }

    //二刷：1ms
    public boolean isToeplitzMatrix2(int[][] matrix) {
        int n = matrix.length-1;
        int m = matrix[0].length-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] != matrix[i+1][j+1])
                    return false;
            }
        }
        return true;
    }
}