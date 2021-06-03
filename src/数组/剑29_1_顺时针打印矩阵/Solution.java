package 数组.剑29_1_顺时针打印矩阵;

/**
 * 方法一：判断四个方向遍历按序遍历元素
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};
        int left = 0, top = 0;
        int right = matrix[0].length - 1, bottom = matrix.length - 1;
        int len = (right + 1) * (bottom + 1);
        int[] res = new int[len];
        int resI = 0;
        while (resI <= len) {
            //(1)左到右
            for (int i = left; i <= right; i++) {
                res[resI++] = matrix[top][i];
            }
            //上到下的边界判断
            if (++top > bottom) break;
            //(2)上到下
            for (int i = top; i <= bottom; i++) {
                res[resI++] = matrix[i][right];
            }

            //右到左的边界判断
            if (--right < left) break;
            //(3)右到左
            for (int i = right; i >= left; i--) {
                res[resI++] = matrix[bottom][i];
            }

            //下到上的边界判断
            if (--bottom < top) break;
            //(4)下到上
            for (int i = bottom; i >= top; i--) {
                res[resI++] = matrix[i][left];
            }

            //左到右的边界判断
            if (++left > right) break;
        }
        return res;
    }
}
