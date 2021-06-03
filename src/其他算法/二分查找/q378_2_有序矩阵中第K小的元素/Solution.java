package 其他算法.二分查找.q378_2_有序矩阵中第K小的元素;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
        };
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(matrix, 8));
    }
}

/**
 * 升序矩阵行列升序的性质 左侧边界二分查找
 */
class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        //(1)初始化二分查找的边界与中间值
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        int mid = 0;

        //(2)其他算法.二分查找
        while (left < right) {
            // 解决int越界问题如 2147483647+2147483646=-3
            mid = left + ((right - left) >> 1);

            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //(3)判断第k位位于二分后的哪一半
    // 每次都从(n-1,0)即最左下角开始 true为左半
    public boolean check(int[][] matrix, int mid, int k, int n) {
        int num = 0;
        int i = n - 1;
        int j = 0;
        //越界与否
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }

        return num >= k;
    }
}
