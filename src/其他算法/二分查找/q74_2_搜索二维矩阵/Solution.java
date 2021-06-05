package 其他算法.二分查找.q74_2_搜索二维矩阵;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        };
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(matrix, 23));
    }
}

/**
 * 基本二分查找
 * 由于无重复数而且后一行还大于前一行，所以可以将矩阵看作一维数组
 */
class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //(1)初始化边界
        int n = matrix.length;
        int m = matrix[0].length;
        int size = n*m;
        int left = 0;
        int right = size-1;

        //(2)其他算法.二分查找
        while (left <= right) {
            int mid = (left+right)>>1;
            int x = mid/m;
            int y = mid-(x*m);
            if (target == matrix[x][y]) {
                return true;
            } else if (target > matrix[x][y]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}