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

        //(2)左侧边界二分查找
        while (left < right) {
            // 解决int越界问题如 2147483647+2147483646=-3
            int mid = left+((right-left)>>1);
            int count = countNoMoreThanK(matrix,mid);
            if(count>=k){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    private int countNoMoreThanK(int[][] matrix,int mid){
        int count = 0;
        int y = matrix.length-1;
        for(int x=0;x<matrix.length;x++){
            while(y>=0 && matrix[x][y]>mid){
                y--;
            }
            count+=y+1;
        }
        return count;
    }
}
