package 数组.q240_2_有序矩阵查找;

public class Solution {
    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        //有
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix.searchMatrix(matrix, 9));
        //无
        matrix = new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix.searchMatrix(matrix, 20));
    }
}

/**
 * 减而治之 从左下或右上出发遍历矩阵，不符合条件则减掉部分行或部分列的元素，无需遍历
 */
class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //(1)初始化数据 左下角
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;
        int i = rowLen - 1;
        int j = 0;

        //(2)遍历矩阵查找target
        while (i >= 0 && j < columnLen) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}