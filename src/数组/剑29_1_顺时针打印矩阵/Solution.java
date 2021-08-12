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

    //二刷：更好理解版本
    public int[] spiralOrder2(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return new int[]{};
        int m = matrix[0].length;
        int[] res = new int[n * m];
        int resI = 0;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;
        while (resI <= res.length) {
            for (int i = left; i <= right; i++) {
                res[resI++] = matrix[top][i];
            }

            if (top == bottom) break;
            //右上角已经遍历过
            top++;
            for (int i = top; i <= bottom; i++) {
                res[resI++] = matrix[i][right];
            }

            if (left == right) break;
            //右下角已经遍历过
            right--;
            for (int i = right; i >= left; i--) {
                res[resI++] = matrix[bottom][i];
            }

            if (top == bottom) break;
            //左下角已经遍历过
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[resI++] = matrix[i][left];
            }

            if (left == right) break;
            //左上角已经遍历过
            left++;
        }
        return res;
    }

    //三刷：直接写出
    public int[] spiralOrder3(int[][] matrix) {
        int n = matrix.length;
        if(n==0) return new int[]{};
        int m = matrix[0].length;
        int length = n*m;
        int[] res = new int[length];
        int resI = 0;
        int left = 0;
        int right = m-1;
        int top = 0;
        int bottom = n-1;
        while(resI<length){
            if(left>right) break;
            for(int i=left;i<=right;i++){
                res[resI++] = matrix[top][i];
            }
            top++;
            if(top>bottom) break;
            for(int i=top;i<=bottom;i++){
                res[resI++] = matrix[i][right];
            }
            right--;
            if(right<left) break;
            for(int i=right;i>=left;i--){
                res[resI++] = matrix[bottom][i];
            }
            bottom--;
            if(bottom<top) break;
            for(int i=bottom;i>=top;i--){
                res[resI++] = matrix[i][left];
            }
            left++;
        }
        return res;
    }
}
